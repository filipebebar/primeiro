package br.com.imobisoftware.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Project Name: Drogaria_treinando
 * User: Filipe Barbosa
 * Date: 20/07/2019
 */

@Entity
@SuppressWarnings("Serial")
public class Usuario extends GenericPessoa {

    @Column(nullable = false, length = 32)
    private String senha;

    @Column(nullable = false)
    private Character tipo;

    @Column(nullable = false)
    private Boolean ativo;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
