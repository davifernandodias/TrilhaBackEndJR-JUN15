package com.trilha.backend.models;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique Identifier of the taks",example = "1")
    private Long id;
    @Column(name = "titulo")
    @Schema(description = "Name for identification of taks",example = "Task to clean a house")
    private String titulo;
    @Column(name = "descricao")
    @Schema(description = "Description of taks",example = "Clean this house very well")
    private String descricao;
    @Column(name = "status")
    @Schema(description = "Status of taks",example = "beggar")
    private String status;
    @Column(name = "prioridade")
    @Schema(description = "priority of taks",example = "max")
    private String prioridade;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

}
