package br.com.imobisoftware.controller;

import br.com.imobisoftware.dao.ClienteBuscaDAO;
import br.com.imobisoftware.domain.ClienteBusca;
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

    private ClienteBusca clienteBusca;
    private List<ClienteBusca> clienteBuscaList;

    public void novo() {
        try {
            clienteBusca = new ClienteBusca();
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo cliente");
            erro.printStackTrace();
        }

    }

    @PostConstruct
    public void listar() {
            clienteBusca = new ClienteBusca();
        try {
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar os clientes");
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {

            ClienteBuscaDAO clienteBuscaDAO = new ClienteBuscaDAO();
            clienteBuscaDAO.merge(clienteBusca);
            limparTela();
            novo();
            Messages.addGlobalError("Salvo com sucesso");
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
            Messages.addGlobalInfo("Cliente Excluído com sucesso");
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
        ClienteBuscaDAO clienteBuscaDAO = new ClienteBuscaDAO();
        clienteBuscaList = clienteBuscaDAO.listar("nome");
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

}
