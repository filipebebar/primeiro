package br.com.imobisoftware.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Project Name: Drogaria_treinando
 * User: Filipe Barbosa
 * Date: 19/07/2019
 */

@Entity
@SuppressWarnings("Serial")
public class Funcionario extends GenericDomain {

    @Column(length = 15, nullable = false)
    private String carteiraDeTrabalho;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDeAdmissao;

    @OneToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    public String getCarteiraDeTrabalho() {
        return carteiraDeTrabalho;
    }

    public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
        this.carteiraDeTrabalho = carteiraDeTrabalho;
    }

    public Date getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(Date dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
