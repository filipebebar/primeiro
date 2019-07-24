package br.com.imobisoftware.controller;


import br.com.imobisoftware.dao.EstadoDAO;
import br.com.imobisoftware.domain.Estado;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;

/**
 * Project Name: Drogaria_treinando
 * User: Filipe Barbosa
 * Date: 22/07/2019
 */

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoController implements Serializable {

    private Estado estado;
    private List<Estado> estados;

    public void salvar() {
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
    }

    //geter and seters
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
}
