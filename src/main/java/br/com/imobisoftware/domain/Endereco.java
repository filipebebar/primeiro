package br.com.imobisoftware.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Project Name: Drogaria_treinando
 * User: Filipe Barbosa
 * Date: 19/07/2019
 */

@Entity
@SuppressWarnings("Serial")
public class Endereco extends GenericDomain {


    @Column(length = 50, nullable = false)
    private String nomeRua;

    @Column(length = 5, nullable = false)
    private String numero;

    @Column(length = 30, nullable = false)
    private String bairro;

    @Column(length = 10, nullable = false)
    private String cep;

    @Column(length = 30, nullable = false)
    private String complemento;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cidade cidade;

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
