package com.example.biblioteca.livro;

import javax.persistence.*;

import com.example.biblioteca.autor.Autor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "UUID", nullable = false)
    private UUID uuid;
    private String titulo;
    @ManyToOne
    private Autor autor;
    private String isbn;
    private String editora;
    private int ano;

}
