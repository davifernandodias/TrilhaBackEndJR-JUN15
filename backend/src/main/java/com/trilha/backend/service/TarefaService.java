package com.trilha.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trilha.backend.models.Tarefa;
import com.trilha.backend.repository.TarefaRepository;

@Service
public class TarefaService {
    
    @Autowired
    private TarefaRepository tarefaRepository;


    public Tarefa criarTarefa(Tarefa Tarefa){ 
        return tarefaRepository.save(Tarefa);
    }

    public Tarefa atualizar(Tarefa tarefa){
        Optional<Tarefa> newTarefa = tarefaRepository.findById(tarefa.getId());
        atualizarTarefa(newTarefa, tarefa);
        return tarefaRepository.save(newTarefa.get());
    }

    private void atualizarTarefa(Optional<Tarefa> newTarefa, Tarefa tarefa) {
        newTarefa.get().setTitulo(tarefa.getTitulo());
        newTarefa.get().setDescricao(tarefa.getDescricao());
        newTarefa.get().setStatus(tarefa.getStatus());
        newTarefa.get().setPrioridade(tarefa.getPrioridade());
    }

    public List<Tarefa> listaDeTodasTarefas(){
        return tarefaRepository.findAll();
    }
    public Tarefa listaDeTarefasPorId(Long id){
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.get();
    }
    public void deleteDeTarefaPorId(Long id){
        tarefaRepository.deleteById(id);
    }

}
