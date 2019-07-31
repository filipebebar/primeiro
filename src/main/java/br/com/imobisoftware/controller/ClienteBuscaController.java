package br.com.imobisoftware.controller;

import br.com.imobisoftware.dao.ClienteBuscaDAO;
import br.com.imobisoftware.dao.PessoaDAO;
import br.com.imobisoftware.domain.ClienteBusca;
import br.com.imobisoftware.domain.Pessoa;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;

/**
* Project Name: ImobiSoftware
* User: Filipe Barbosa
* Date: 29/07/2019
*/

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBuscaController implements Serializable {

    private Pessoa pessoa;
    private ClienteBusca clienteBusca;
    private PessoaController pessoaController;
    private List<ClienteBusca> clienteBuscaList;
    private List<Pessoa> pessoas;

    public void novo() {
        try {
            clienteBusca = new ClienteBusca();
            pessoa = new Pessoa();
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo cliente");
            erro.printStackTrace();
        }

    }

    @PostConstruct
    public void listar() {
        try {
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoas = pessoaDAO.listar("dataDeCadastro");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar os clientes");
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {
            PessoaDAO pessoaDAO = new PessoaDAO();
            ClienteBuscaDAO clienteBuscaDAO = new ClienteBuscaDAO();
            clienteBuscaDAO.merge(clienteBusca);
            pessoaDAO.merge(pessoa);
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar o cliente");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            clienteBusca = (ClienteBusca) evento.getComponent().getAttributes().get("selecionado");
            ClienteBuscaDAO clienteBuscaDAO = new ClienteBuscaDAO();
            clienteBuscaDAO.excluir(clienteBusca);
            limparTela();
            Messages.addGlobalInfo("Cidade Excluída com sucesso");
        } catch (RuntimeException ex) {
            Messages.addGlobalError("Ocorreu um erro ao excluir a cidade!");
            ex.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        try {
            clienteBusca = (ClienteBusca) evento.getComponent().getAttributes().get("selecionado");
        }catch (RuntimeException ex){
            Messages.addGlobalError("Ocorreu um erro ao editar a cidade!");
            ex.printStackTrace();
        }
    }

    public void limparTela() {

    }


    //getters and setters

    public ClienteBusca getClienteBusca() {
        return clienteBusca;
    }

    public void setClienteBusca(ClienteBusca clienteBusca) {
        this.clienteBusca = clienteBusca;
    }

    public List<ClienteBusca> getClienteBuscaList() {
        return clienteBuscaList;
    }

    public void setClienteBuscaList(List<ClienteBusca> clienteBuscaList) {
        this.clienteBuscaList = clienteBuscaList;
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
}
