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
public class Pessoa extends GenericDomain {

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 11, nullable = true)
    private String cpf;

    @Column(length = 10, nullable = true)
    private String rg;

    @Column(length = 10, nullable = false)
    private String telefone;

    @Column(length = 11, nullable = false)
    private String telefone_secundario;

    @Column(length = 20, nullable = true)
    private String email;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dataDeNascimento;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDeCadastro;

    @ManyToOne
    @JoinColumn
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getTelefone_secundario() {
        return telefone_secundario;
    }

    public void setTelefone_secundario(String telefone_secundario) {
        this.telefone_secundario = telefone_secundario;
    }

}
