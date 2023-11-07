package com.devinhouse.miniprojetoM2S06.model;

import com.devinhouse.miniprojetoM2S06.Enums.Prioridade;
import com.devinhouse.miniprojetoM2S06.Enums.Status;
import jakarta.persistence.*;

@Entity(name = "tarefas")
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Status status;
    private Prioridade prioridade;
    private String nomeResponsavel;

    public Tarefa(){

    }
    public Tarefa(TarefaDTO tarefaDTO){
        this.descricao = tarefaDTO.descricao();
        this.status = tarefaDTO.status();
        this.prioridade = tarefaDTO.prioridade();
        this.nomeResponsavel = tarefaDTO.nomeResponsavel();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}
