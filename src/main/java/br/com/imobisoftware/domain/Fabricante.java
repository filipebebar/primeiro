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
public class Fabricante extends GenericDomain {

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 70, nullable = false)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
