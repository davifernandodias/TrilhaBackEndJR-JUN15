package com.trilha.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trilha.backend.models.Tarefa;
import com.trilha.backend.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> salvarTarefas(@RequestBody Tarefa tarefa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criarTarefa(tarefa));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTarefa(@PathVariable Long id, Tarefa tarefa) {
        tarefaService.deleteDeTarefaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tarefa> consultarTarefasPorId(@PathVariable Long id) {
        tarefaService.listaDeTarefasPorId(id);
        return ResponseEntity.ok().body(tarefaService.listaDeTarefasPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> consultarTodasTarefas(){
        return ResponseEntity.ok().body(tarefaService.listaDeTodasTarefas());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tarefa> atualizarTarefaPorId(@PathVariable Long id,@RequestBody Tarefa tarefa){
        tarefa.setId(id);
        return ResponseEntity.ok().body(tarefaService.atualizar(tarefa));
    }

}
