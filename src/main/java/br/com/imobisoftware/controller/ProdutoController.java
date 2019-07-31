package br.com.imobisoftware.controller;

import br.com.imobisoftware.dao.FabricanteDAO;
import br.com.imobisoftware.dao.ProdutoDAO;
import br.com.imobisoftware.domain.Fabricante;
import br.com.imobisoftware.domain.Produto;
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
public class ProdutoController implements Serializable {
    private List<Produto> produtos;
    private List<Fabricante> fabricantes;
    private Produto produto;

    public void novo(){
        try{
            produto = new Produto();
            FabricanteDAO fabricanteDAO = new FabricanteDAO();
            fabricantes = fabricanteDAO.listar("nome");
        }catch(RuntimeException ex){
            ex.printStackTrace();
        }
    }

    @PostConstruct
    public void listar(){
        try{
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtos = produtoDAO.listar("nome");
        }catch (RuntimeException ex){
            ex.printStackTrace();
        }
    }

    public void salvar(){
        try{
            validacao();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.merge(produto);
            limparTela();
            novo();
            Messages.addGlobalInfo("Produto salvo com sucesso!");
        }catch (RuntimeException ex){
            ex.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento){
        try{
            produto = (Produto) evento.getComponent().getAttributes().get("selecionado");
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.excluir(produto);
            limparTela();
        }catch (RuntimeException ex){
            ex.printStackTrace();
        }
    }

    public void editar(ActionEvent evento){
        try{
            produto = (Produto) evento.getComponent().getAttributes().get("selecionado");
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtos = produtoDAO.listar("nome");
        }catch (RuntimeException ex){
            ex.printStackTrace();
        }
    }




    public void limparTela() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.listar("nome");
        FabricanteDAO fabricanteDAO = new FabricanteDAO();
        fabricantes = fabricanteDAO.listar("nome");
    }

    public boolean validacao() {
        if (getProduto().getNome().isEmpty()) {
            Messages.addGlobalError("O campo nome esta vazio!");
        }
        return false;
    }


    //getters and setters
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
