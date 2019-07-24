package br.com.imobisoftware.controller;

import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import java.io.Serializable;

/**
* Project Name: ImobiSoftware
* User: Filipe Barbosa
* Date: 24/07/2019
*/
public final class GenericController<Entidade> implements Serializable {

    EntityManager em ;

    /*public void salvar() {
        try {
            validacao();
            EstadoDAO estadoDAO = new EstadoDAO();
            estadoDAO.merge(estado);
            limparTela();
            novo();
            Messages.addGlobalInfo("Estado salvo com Sucesso");
        } catch (RuntimeException ex) {
            Messages.addGlobalError("Ocorreu um erro ao salvar o estado!");
            ex.printStackTrace();
        }
    }

    public void novo() {
        estado = new Estado();
    }

    public void limparTela() {
        EstadoDAO estadoDAO = new EstadoDAO();
        estados = estadoDAO.listar();
    }

    public void excluir(ActionEvent evento) {
        try {
            estado = (Estado) evento.getComponent().getAttributes().get("selecionado");
            EstadoDAO estadoDAO = new EstadoDAO();
            estadoDAO.excluir(estado);
            limparTela();
            Messages.addGlobalInfo("Estado Excluído com sucesso");
        } catch (RuntimeException ex) {
            Messages.addGlobalError("Ocorreu um erro ao excluir o estado!");
            ex.printStackTrace();
        }
    }

    @PostConstruct
    public void listar() {
        try {
            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }

    public boolean validacao() {
        if (getEstado().getNome().isEmpty()) {
            Messages.addGlobalError("O campo nome esta vazio!");
        }
        if (getEstado().getSigla().isEmpty()) {
            Messages.addGlobalError("O campo sigla esta vazio");
        }
        return false;
    }

    public void editar(ActionEvent evento) {
        try {
            estado = (Estado) evento.getComponent().getAttributes().get("selecionado");
        }catch (RuntimeException ex){
            ex.printStackTrace();
        }
    }*/

}
