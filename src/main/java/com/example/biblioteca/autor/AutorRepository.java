package com.example.biblioteca.autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    public Optional<Autor> findByUuid(UUID uuid);
}
