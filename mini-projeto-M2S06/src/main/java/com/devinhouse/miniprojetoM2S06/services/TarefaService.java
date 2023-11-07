package com.devinhouse.miniprojetoM2S06.services;

import com.devinhouse.miniprojetoM2S06.Enums.Prioridade;
import com.devinhouse.miniprojetoM2S06.Enums.Status;
import com.devinhouse.miniprojetoM2S06.model.Tarefa;
import com.devinhouse.miniprojetoM2S06.model.TarefaDTO;
import com.devinhouse.miniprojetoM2S06.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    private void salvarTarefa(Tarefa tarefa){
        this.tarefaRepository.save(tarefa);
    }
    public Tarefa createTarefa(TarefaDTO tarefaDto) {
        Tarefa novaTarefa = new Tarefa(tarefaDto);
        this.salvarTarefa(novaTarefa);
        return novaTarefa;
    }

    public void excluirTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

    private List<TarefaDTO> mapearParaDTO(List<Tarefa> tarefas) {
        return tarefas.stream()
                .map(tarefa ->
                        new TarefaDTO(
                                tarefa.getDescricao(),
                                tarefa.getStatus(),
                                tarefa.getPrioridade(),
                                tarefa.getNomeResponsavel()))
                .collect(Collectors.toList());
    }
    public List<TarefaDTO> listarTodasTarefas() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return mapearParaDTO(tarefas);
    }

    public List<TarefaDTO> listarTarefasPorStatus(Status status) {
        List<Tarefa> tarefas = tarefaRepository.findByStatus(status);
        return mapearParaDTO(tarefas);
    }

    public List<TarefaDTO> listarTarefasPorPrioridade(Prioridade prioridade) {
        List<Tarefa> tarefas = tarefaRepository.findByPrioridade(prioridade);
        return mapearParaDTO(tarefas);
    }

    public List<TarefaDTO> listarTarefasPorNomeResponsavel(String nomeResponsavel) {
        List<Tarefa> tarefas = tarefaRepository.findByNomeResponsavel(nomeResponsavel);
        return mapearParaDTO(tarefas);
    }

    public TarefaDTO editarTarefa(Long tarefaId, TarefaDTO tarefaAtualizada) {

        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(tarefaId);

        if (tarefaExistente.isPresent()) {
            Tarefa tarefa = tarefaExistente.get();
            tarefa.setDescricao(tarefaAtualizada.descricao());
            tarefa.setPrioridade(tarefaAtualizada.prioridade());
            tarefa.setStatus(tarefaAtualizada.status());
            tarefa.setNomeResponsavel(tarefaAtualizada.nomeResponsavel());

            tarefa = tarefaRepository.save(tarefa);

            return new TarefaDTO(tarefa.getDescricao(), tarefa.getStatus(), tarefa.getPrioridade(), tarefa.getNomeResponsavel());
        } else {
            return null;
        }

    }


}
