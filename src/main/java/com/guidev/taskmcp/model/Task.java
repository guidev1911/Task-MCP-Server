package com.guidev.taskmcp.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Long id;
    private String nome;
    private String descricao;
    private boolean concluida;
}