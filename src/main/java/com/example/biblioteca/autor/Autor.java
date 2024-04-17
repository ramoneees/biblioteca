package com.example.biblioteca.autor;

import com.example.biblioteca.livro.Livro;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "UUID", nullable = false)
    private UUID uuid;
    private String nome;

}
