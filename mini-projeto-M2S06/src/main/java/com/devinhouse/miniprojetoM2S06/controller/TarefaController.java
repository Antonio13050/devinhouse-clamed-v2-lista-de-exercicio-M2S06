package com.devinhouse.miniprojetoM2S06.controller;

import com.devinhouse.miniprojetoM2S06.Enums.Prioridade;
import com.devinhouse.miniprojetoM2S06.Enums.Status;
import com.devinhouse.miniprojetoM2S06.model.Tarefa;
import com.devinhouse.miniprojetoM2S06.model.TarefaDTO;
import com.devinhouse.miniprojetoM2S06.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> createTarefa(@RequestBody TarefaDTO tarefaDto){
        Tarefa novaTarefa = tarefaService.createTarefa(tarefaDto);
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable Long id){
        tarefaService.excluirTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<TarefaDTO> listarTarefas(){
        return tarefaService.listarTodasTarefas();
    }

    @GetMapping(params = "status")
    public List<TarefaDTO> listarTarefasPorStatus(@RequestParam("status") Status status) {
        return tarefaService.listarTarefasPorStatus(status);
    }

    @GetMapping(params = "prioridade")
    public List<TarefaDTO> listarTarefasPorStatus(@RequestParam("prioridade") Prioridade prioridade) {
        return tarefaService.listarTarefasPorPrioridade(prioridade);
    }

    @GetMapping(params = "responsavel")
    public List<TarefaDTO> listarTarefasPorNomeResponsavel(@RequestParam("responsavel") String responsavel) {
        return tarefaService.listarTarefasPorNomeResponsavel(responsavel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> editarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaAtualizada) {
        TarefaDTO tarefaEditada = tarefaService.editarTarefa(id, tarefaAtualizada);
        if (tarefaEditada != null) {
            return ResponseEntity.ok(tarefaEditada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
