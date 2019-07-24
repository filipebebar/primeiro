package br.com.imobisoftware.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Project Name: Drogaria_treinando
 * User: Filipe Barbosa
 * Date: 19/07/2019
 */

@SuppressWarnings("Serial")
@Entity
public class Estado extends GenericDomain {

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 2, nullable = false)
    private String sigla;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
