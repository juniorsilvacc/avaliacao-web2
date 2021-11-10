package com.unifip.agenda.controller;

import java.util.List;

import com.unifip.agenda.model.Conta;
import com.unifip.agenda.model.TipoStatus;
import com.unifip.agenda.services.ContaServices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {
    private ContaServices contaServices = new ContaServices();

    // CRIAR CONTA
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void criar(@RequestBody Conta conta) {
        contaServices.criar(conta);
    }

    // PAGAR O VALOR
    @RequestMapping(value = "/pagar/{id}", method = RequestMethod.PUT)
    public List<Conta> pagar(@PathVariable Long id) {
        return contaServices.pagar(id);
    }

    // LISTAR TODAS AS CONTAS
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Conta> listarTodos() {
        return contaServices.listarTodos();
    }

    // LISTAR POR ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Conta listarID(@PathVariable Long id) {
        return contaServices.listarID(id);
    }

    // CANCELAR CONTA POR ID
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/cancelar/{id}", method = RequestMethod.DELETE)
    public List<Conta> deletar(@PathVariable Long id) {
        return contaServices.deletar(id);
    }

    // LISTAR POR STATUS
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public List<Conta> listarStatus(@RequestParam String status) {
        return contaServices.listarStatus(TipoStatus.valueOf(status));
    }
}
