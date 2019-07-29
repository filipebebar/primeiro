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
public class ClienteBusca extends GenericDomain {

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Column(nullable = false, length = 30)
    private String situacao;

    @Column(nullable = false, length = 20)
    private String tipo;

    @OneToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
