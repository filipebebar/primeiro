package br.com.imobisoftware.controller;

import br.com.imobisoftware.dao.ClienteBuscaDAO;
import br.com.imobisoftware.dao.EnderecoDAO;
import br.com.imobisoftware.domain.ClienteBusca;
import br.com.imobisoftware.domain.Endereco;
import br.com.imobisoftware.domain.Pessoa;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
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
public class ClienteBuscaController implements Serializable {
    
    private List<ClienteBusca> clientesBusca;
    private List<Endereco> enderecos;
    private ClienteBusca clienteBusca;
    private EventListener evento;
    private Pessoa pessoa;


    public void novo() {
        try {
            clienteBusca = new ClienteBusca();
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            enderecos = enderecoDAO.listar();
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova clienteBusca");
            erro.printStackTrace();
        }
    }

    @PostConstruct
    public void listar() {
        try {
            ClienteBuscaDAO cidadeDAO = new ClienteBuscaDAO();
            clientesBusca = cidadeDAO.listar();
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as cidades");
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {
            validacao();
            ClienteBuscaDAO cidadeDAO = new ClienteBuscaDAO();
            cidadeDAO.merge(clienteBusca);
            limparTela();
            novo();
            Messages.addGlobalInfo("ClienteBusca salva com Sucesso!");
        } catch (RuntimeException ex) {
            Messages.addGlobalError("Ocorreu um erro ao salvar a clienteBusca!");
            ex.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            clienteBusca = (ClienteBusca) evento.getComponent().getAttributes().get("selecionado");
            ClienteBuscaDAO cidadeDAO = new ClienteBuscaDAO();
            cidadeDAO.excluir(clienteBusca);
            limparTela();
            Messages.addGlobalInfo("ClienteBusca Excluída com sucesso");
        } catch (RuntimeException ex) {
            Messages.addGlobalError("Ocorreu um erro ao excluir a clienteBusca!");
            ex.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        try {
            clienteBusca = (ClienteBusca) evento.getComponent().getAttributes().get("selecionado");
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            enderecos = enderecoDAO.listar();
        }catch (RuntimeException ex){
            Messages.addGlobalError("Ocorreu um erro ao editar a clienteBusca!");
            ex.printStackTrace();
        }
    }

    public void limparTela() {
        ClienteBuscaDAO cidadeDAO = new ClienteBuscaDAO();
        clientesBusca = cidadeDAO.listar();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecos = enderecoDAO.listar();
    }

    public boolean validacao() {
        if (getClienteBusca().getPessoa().getNome().isEmpty()) {
            Messages.addGlobalError("O campo nome esta vazio!");
        }
        return false;
    }


    public List<ClienteBusca> getClientesBusca() {
        return clientesBusca;
    }

    public void setClientesBusca(List<ClienteBusca> clientesBusca) {
        this.clientesBusca = clientesBusca;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public ClienteBusca getClienteBusca() {
        return clienteBusca;
    }

    public void setClienteBusca(ClienteBusca clienteBusca) {
        this.clienteBusca = clienteBusca;
    }
}
