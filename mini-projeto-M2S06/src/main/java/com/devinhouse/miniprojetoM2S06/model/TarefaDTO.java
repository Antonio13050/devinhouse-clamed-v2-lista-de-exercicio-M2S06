package com.devinhouse.miniprojetoM2S06.model;

import com.devinhouse.miniprojetoM2S06.Enums.Prioridade;
import com.devinhouse.miniprojetoM2S06.Enums.Status;

public record TarefaDTO(String descricao, Status status, Prioridade prioridade,String nomeResponsavel) {
}
