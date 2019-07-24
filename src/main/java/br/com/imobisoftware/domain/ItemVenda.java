package br.com.imobisoftware.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * Project Name: Drogaria_treinando
 * User: Filipe Barbosa
 * Date: 19/07/2019
 */
@Entity
@SuppressWarnings("Serial")
public class ItemVenda extends GenericDomain {

    @Column(length = 6, nullable = false)
    private Long quantidade;

    @Column(length = 6, nullable = false)
    private BigDecimal precoParcial;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Funcionario funcionario;

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoParcial() {
        return precoParcial;
    }

    public void setPrecoParcial(BigDecimal precoParcial) {
        this.precoParcial = precoParcial;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
