package com.unifip.agenda.repository;

import java.util.HashMap;
import java.util.Map;

import com.unifip.agenda.model.Conta;

public class ContaRepository implements IContaRepository {
    private Map<Long, Conta> vehiclesDB = new HashMap<>();

    public Map<Long, Conta> listarTodos() {
        return vehiclesDB;
    }

    public Map<Long, Conta> listarID(Long id) {
        return vehiclesDB;
    }

    public void criar(Conta conta) {
        vehiclesDB.put(conta.getId(), conta);
    }

    public Map<Long, Conta> atualizar(Long id, Conta conta) {
        vehiclesDB.put(id, conta);
        return vehiclesDB;
    }

    public Map<Long, Conta> deletar(Long id, Conta conta) {
        vehiclesDB.remove(id, conta);
        return vehiclesDB;
    }
}
