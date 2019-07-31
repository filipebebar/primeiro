package br.com.imobisoftware.controller;

import br.com.imobisoftware.dao.FabricanteDAO;
import br.com.imobisoftware.domain.Fabricante;
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
* Date: 24/07/2019
*/

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteController implements Serializable {

    private Fabricante fabricante;
    private List<Fabricante> fabricantes;


    public void salvar() {
        try {
            validacao();
            FabricanteDAO fabricanteDAO = new FabricanteDAO();
            fabricanteDAO.merge(fabricante);
            limparTela();
            novo();
            Messages.addGlobalInfo("Fabricante salvo com Sucesso");
        } catch (RuntimeException ex) {
            Messages.addGlobalError("Ocorreu um erro ao salvar o fabricante!");
            ex.printStackTrace();
        }
    }

    public void novo() {
        fabricante = new Fabricante();
    }

    public void limparTela() {
        FabricanteDAO fabricanteDAO = new FabricanteDAO();
        fabricantes = fabricanteDAO.listar("nome");
    }

    public void excluir(ActionEvent evento) {
        try {
            fabricante = (Fabricante) evento.getComponent().getAttributes().get("selecionado");
            FabricanteDAO fabricanteDAO = new FabricanteDAO();
            fabricanteDAO.excluir(fabricante);
            limparTela();
            Messages.addGlobalInfo("Fabricante Excluído com sucesso");
        } catch (RuntimeException ex) {
            Messages.addGlobalError("Ocorreu um erro ao excluir o fabricante!");
            ex.printStackTrace();
        }
    }

    @PostConstruct
    public void listar() {
        try {
            FabricanteDAO fabricanteDAO = new FabricanteDAO();
            fabricantes = fabricanteDAO.listar("nome");
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }

    public boolean validacao() {
        if (getFabricante().getNome().isEmpty()) {
            Messages.addGlobalError("O campo nome esta vazio!");
        }
        return false;
    }

    public void editar(ActionEvent evento) {
        try {
            fabricante = (Fabricante) evento.getComponent().getAttributes().get("selecionado");
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }


    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }
}
