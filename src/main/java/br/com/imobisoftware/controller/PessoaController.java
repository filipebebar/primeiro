package br.com.imobisoftware.controller;

import br.com.imobisoftware.dao.PessoaDAO;
import br.com.imobisoftware.domain.Endereco;
import br.com.imobisoftware.domain.Pessoa;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * Project Name: ImobiSoftware
 * User: Filipe Barbosa
 * Date: 29/07/2019
 */

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaController implements Serializable {

    private Pessoa pessoa;
    private List<Pessoa> pessoas;

    private Endereco endereco;
    private List<Endereco> enderecos;


    @PostConstruct
    public void listar() {
        try {
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoas = pessoaDAO.listar("dataDeCadastro");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar as pessoas");
            erro.printStackTrace();
        }
    }

    public void novo() {
        try {
            pessoa = new Pessoa();
            endereco = new Endereco();
            enderecos = new ArrayList<>();
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova pessoa");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {

    }

    public void salvar() {
        try {
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoaDAO.merge(pessoa);
            pessoas = pessoaDAO.listar("nome");
            pessoa = new Pessoa();
            enderecos = new ArrayList<>();
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar a pessoa");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {

    }


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
