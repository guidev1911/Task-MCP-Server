package com.guidev.taskmcp.tool;

import com.guidev.taskmcp.dto.CreateTaskRequest;
import com.guidev.taskmcp.model.Task;
import com.guidev.taskmcp.service.TaskService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskTool {

    private final TaskService service;

    public TaskTool(TaskService service){
        this.service = service;
    }

    @Tool(description = "Cria uma nova tarefa")
    public Task criarTarefa(
            @ToolParam(description = "Dados da nova tarefa")
            CreateTaskRequest request){

        return service.criar(request.nome(), request.descricao());
    }

    @Tool(description = "Lista todas as tarefas")
    public List<Task> listarTarefas(){

        return service.listar();
    }

    @Tool(description = "Conclui uma tarefa")
    public Task concluirTarefa(
            @ToolParam(description = "ID da tarefa")
            Long id){

        return service.concluir(id);
    }

    @Tool(description = "Remove uma tarefa")
    public String removerTarefa(
            @ToolParam(description = "ID da tarefa")
            Long id){

        service.deletar(id);

        return "Tarefa removida.";
    }

}