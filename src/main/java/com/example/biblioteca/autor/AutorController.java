package com.example.biblioteca.autor;

import com.example.biblioteca.exceptions.NaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/autor")
@RequiredArgsConstructor
public class AutorController {
    private final AutorService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<AutorDTO> listarTodos() {
        return this.service.listarAutores().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{uuid}")
    public Optional<AutorDTO> buscarPorUuid (@PathVariable("uuid") UUID uuid) {
        return this.service.buscarPorUuid(uuid);
    }

    @DeleteMapping("/{uuid}")
    public void excluir (@PathVariable("uuid") UUID uuid) {
         this.service.excluir(uuid);
    }

    @PostMapping
    public AutorDTO inserir (@RequestBody AutorDTO dto) {
        return this.service.salvar(dto);
    }


}
