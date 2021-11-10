package com.unifip.agenda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Conta {
    private Long id;
    private String descricao;
    private Long valor;
    private TipoStatus TipoStatus;
}
