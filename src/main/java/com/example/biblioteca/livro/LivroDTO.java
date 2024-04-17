package com.example.biblioteca.livro;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LivroDTO {

    private UUID uuid;
    private String titulo;
    private Integer autorId;
    private String isbn;
    private String editora;
    private int ano;

}
