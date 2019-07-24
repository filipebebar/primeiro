package br.com.imobisoftware.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Project Name: Drogaria_treinando
 * User: Filipe Barbosa
 * Date: 22/07/2019
 */


@SuppressWarnings("serial")
@Entity
public class Venda extends GenericDomain {
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal precoTotal;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Funcionario funcionario;

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}