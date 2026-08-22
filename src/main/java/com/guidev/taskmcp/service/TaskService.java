package com.guidev.taskmcp.service;

import com.guidev.taskmcp.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final List<Task> tarefas = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong();

    public Task criar(String nome, String descricao){

        Task tarefa = Task.builder()
                .id(sequence.incrementAndGet())
                .nome(nome)
                .descricao(descricao)
                .concluida(false)
                .build();

        tarefas.add(tarefa);

        return tarefa;
    }

    public List<Task> listar(){
        return tarefas;
    }

    public Optional<Task> buscar(Long id){
        return tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public Task concluir(Long id){

        Task tarefa = buscar(id)
                .orElseThrow();

        tarefa.setConcluida(true);

        return tarefa;
    }

    public void deletar(Long id){
        tarefas.removeIf(t -> t.getId().equals(id));
    }

}