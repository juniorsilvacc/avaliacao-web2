package com.unifip.agenda.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.unifip.agenda.model.Conta;
import com.unifip.agenda.model.TipoStatus;
import com.unifip.agenda.repository.ContaRepository;

public class ContaServices {
    private ContaRepository contaRepository = new ContaRepository();

    public List<Conta> listarTodos() {
        Map<Long, Conta> listarDB = contaRepository.listarTodos();
        return listarDB.values().stream().collect(Collectors.toList());
    }

    public Conta listarID(Long id) {
        Map<Long, Conta> listarDB = contaRepository.listarTodos();
        return listarDB.get(id);
    }

    public void criar(Conta conta) {
        conta.setTipoStatus(TipoStatus.PENDENTE);
        contaRepository.criar(conta);
    }

    public List<Conta> pagar(Long id) {
        Conta conta = listarID(id);
        if (conta != null) {
            conta.setTipoStatus(TipoStatus.PAGO);
            contaRepository.atualizar(id, conta);
        } else {
            throw new IllegalArgumentException("Id não encontrado");
        }
        return listarTodos();
    }

    public List<Conta> deletar(Long id) {
        Conta conta = listarID(id);
        if (conta != null) {
            conta.setTipoStatus(TipoStatus.CANCELADO);
            contaRepository.atualizar(id, conta);
        } else {
            throw new IllegalArgumentException("Id não encontrado");
        }
        return listarTodos();
    }

    public List<Conta> listarStatus(TipoStatus status) {
        return listarTodos().stream().filter(conta -> status.equals(conta.getTipoStatus()))
                .collect(Collectors.toList());
    }
}
