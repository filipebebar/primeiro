package br.com.imobisoftware.controller;

import br.com.imobisoftware.dao.CidadeDAO;
import br.com.imobisoftware.dao.EstadoDAO;
import br.com.imobisoftware.domain.Cidade;
import br.com.imobisoftware.domain.Estado;
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
 * Date: 23/07/2019
 */

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeController implements Serializable {
    private List<Cidade> cidades;
    private List<Estado> estados;
    private Cidade cidade;

    public void novo() {
        try {
            cidade = new Cidade();
            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova cidade");
            erro.printStackTrace();
        }
    }

    @PostConstruct
    public void listar() {
        try {
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidades = cidadeDAO.listar();
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as cidades");
            erro.printStackTrace();
        }
    }

    public void salvar() {
        try {
            validacao();
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidadeDAO.merge(cidade);
            limparTela();
            novo();
            Messages.addGlobalInfo("Cidade salva com Sucesso!");
        } catch (RuntimeException ex) {
            Messages.addGlobalError("Ocorreu um erro ao salvar a cidade!");
            ex.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            cidade = (Cidade) evento.getComponent().getAttributes().get("selecionado");
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidadeDAO.excluir(cidade);
            limparTela();
            Messages.addGlobalInfo("Cidade Excluída com sucesso");
        } catch (RuntimeException ex) {
            Messages.addGlobalError("Ocorreu um erro ao excluir a cidade!");
            ex.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        try {
            cidade = (Cidade) evento.getComponent().getAttributes().get("selecionado");
            EstadoDAO estadoDAO = new EstadoDAO();
            estados = estadoDAO.listar();
        }catch (RuntimeException ex){
            Messages.addGlobalError("Ocorreu um erro ao editar a cidade!");
            ex.printStackTrace();
        }
    }

    public void limparTela() {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidades = cidadeDAO.listar();
        EstadoDAO estadoDAO = new EstadoDAO();
        estados = estadoDAO.listar();
    }

    public boolean validacao() {
        if (getCidade().getNome().isEmpty()) {
            Messages.addGlobalError("O campo nome esta vazio!");
        }
        return false;
    }




    //geters and seters

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
