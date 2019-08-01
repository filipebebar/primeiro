package br.com.imobisoftware.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Project Name: Drogaria_treinando
 * User: Filipe Barbosa
 * Date: 19/07/2019
 */

@MappedSuperclass
@SuppressWarnings("Serial")
public class GenericPessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

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


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericDomain)) return false;
        GenericDomain that = (GenericDomain) o;
        return Objects.equals(getCodigo(), that.getCodigo());
    }
}
