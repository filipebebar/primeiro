package br.com.imobisoftware.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
* Project Name: ImobiSoftware
* User: Filipe Barbosa
* Date: 25/07/2019
*/

@Entity
@SuppressWarnings("Serial")
public class Proprietario extends GenericDomain{

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn
    private ImovelLocacao imovelLocacao;

    @ManyToOne
    @JoinColumn
    private  ImovelVenda imovelVenda;





    //getters and setters
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ImovelLocacao getImovelLocacao() {
        return imovelLocacao;
    }

    public void setImovelLocacao(ImovelLocacao imovelLocacao) {
        this.imovelLocacao = imovelLocacao;
    }

    public ImovelVenda getImovelVenda() {
        return imovelVenda;
    }

    public void setImovelVenda(ImovelVenda imovelVenda) {
        this.imovelVenda = imovelVenda;
    }
}
