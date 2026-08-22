package com.guidev.taskmcp.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTaskRequest(

        @NotBlank
        String nome,

        String descricao
) {}