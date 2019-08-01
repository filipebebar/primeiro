package br.com.imobisoftware.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Project Name: Drogaria_treinando
 * User: Filipe Barbosa
 * Date: 19/07/2019
 */


@Entity
@SuppressWarnings("Serial")
public class ClienteBusca extends GenericPessoa {


    @Column(nullable = true, length = 30)
    private String situacao;

    @Column(nullable = false, length = 20)
    private String tipo;

    @Column(nullable = true, length = 20)
    private String valorDaBusca;

    @Column(nullable = false, length = 500)
    private String descricaoDaBusca;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValorDaBusca() {
        return valorDaBusca;
    }

    public void setValorDaBusca(String valorDaBusca) {
        this.valorDaBusca = valorDaBusca;
    }

    public String getDescricaoDaBusca() {
        return descricaoDaBusca;
    }

    public void setDescricaoDaBusca(String descricaoDaBusca) {
        this.descricaoDaBusca = descricaoDaBusca;
    }
}
