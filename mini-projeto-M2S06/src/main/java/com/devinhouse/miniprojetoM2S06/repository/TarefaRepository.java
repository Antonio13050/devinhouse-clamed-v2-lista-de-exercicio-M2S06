package com.devinhouse.miniprojetoM2S06.repository;

import com.devinhouse.miniprojetoM2S06.Enums.Prioridade;
import com.devinhouse.miniprojetoM2S06.Enums.Status;
import com.devinhouse.miniprojetoM2S06.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository  extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByStatus(Status status);

    List<Tarefa> findByPrioridade(Prioridade prioridade);

    List<Tarefa> findByNomeResponsavel(String nomeResponsavel);

}
