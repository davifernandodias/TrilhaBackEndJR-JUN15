package com.trilha.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trilha.backend.models.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    
}
