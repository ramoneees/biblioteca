package com.example.biblioteca.autor;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    private final ModelMapper modelMapper;


    private AutorDTO convertDto(Autor autor) {
        return this.modelMapper.map(autor, AutorDTO.class);
    }

    private Autor convertFromDto(AutorDTO autorDto) {
        return this.modelMapper.map(autorDto, Autor.class);
    }

    public List<AutorDTO> listarAutores() {
        return this.autorRepository.findAll().stream()
                .map(this::convertDto)
                .collect(Collectors.toList());
    }

    public AutorDTO salvar(AutorDTO autorDto) {
        var autor = this.convertFromDto(autorDto);
        autor.setUuid(UUID.randomUUID());
        var savedAutor = this.autorRepository.save(autor);
        return this.convertDto(savedAutor);
    }

    public Optional<AutorDTO> buscarPorUuid(UUID uuid) {
        return this.autorRepository.findByUuid(uuid).map(this::convertDto);
    }

    public void excluir(UUID uuid) {
        var autor = this.autorRepository.findByUuid(uuid).orElseThrow();
        this.autorRepository.delete(autor);
    }

}
