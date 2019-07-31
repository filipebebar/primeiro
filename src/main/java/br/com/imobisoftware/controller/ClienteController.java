package br.com.imobisoftware.controller;

import br.com.imobisoftware.dao.ClienteDAO;
import br.com.imobisoftware.dao.PessoaDAO;
import br.com.imobisoftware.domain.Cliente;
import br.com.imobisoftware.domain.Pessoa;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
* Project Name: ImobiSoftware
* User: Filipe Barbosa
* Date: 30/07/2019
*/


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {
    private Cliente cliente;

    private List<Cliente> clientes;
    private List<Pessoa> pessoas;



    @PostConstruct
    public void listar() {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            clientes = clienteDAO.listar("dataCadastro");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar os clientes");
            erro.printStackTrace();
        }
    }

    public void novo() {
        try {
            cliente = new Cliente();

            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoas = pessoaDAO.listar("nome");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo cliente");
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.merge(cliente);

            cliente = new Cliente();

            clientes = clienteDAO.listar("dataCadastro");

            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoas = pessoaDAO.listar("nome");

            Messages.addGlobalInfo("Cliente salvo com sucesso");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar o cliente");
            erro.printStackTrace();
        }
    }




    //getters and setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
