package br.com.imobisoftware.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
* Project Name: ImobiSoftware
* User: Filipe Barbosa
* Date: 25/07/2019
*/

@Entity
@SuppressWarnings("Serial")
public class ImovelVenda extends GenericDomain{

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal valorDeVenda;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Imovel imovel;

    @ManyToOne
    @JoinColumn
    private Cliente cliente;



    //getters and setters
    public BigDecimal getValorDeVenda() {
        return valorDeVenda;
    }

    public void setValorDeVenda(BigDecimal valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
