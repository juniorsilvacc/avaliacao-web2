package com.unifip.agenda.repository;

import java.util.Map;

import com.unifip.agenda.model.Conta;

public interface IContaRepository {

  public Map<Long, Conta> listarTodos();

  public Map<Long, Conta> listarID(Long id);

  public void criar(Conta contato);

  public Map<Long, Conta> atualizar(Long id, Conta conta);

  public Map<Long, Conta> deletar(Long id, Conta conta);

}
