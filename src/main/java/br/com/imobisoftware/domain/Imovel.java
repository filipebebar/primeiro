package br.com.imobisoftware.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Project Name: ImobiSoftware
 * User: Filipe Barbosa
 * Date: 24/07/2019
 */

@SuppressWarnings("Serial")
@Entity
public class Imovel extends GenericDomain {

    @Column(length = 15, nullable = false)
    private String codigoDeMatricula;

    @Column(length = 6, nullable = false)
    private String tamanhoTerreno;

    @Column(length = 10, nullable = false)
    private String tipo;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDeCadastro;

    @Column(length = 10, nullable = false)
    private String situacao;

    @OneToOne
    @JoinColumn(nullable = false)
    private Endereco endereco;


    //getters and setters
    public String getCodigoDeMatricula() {
        return codigoDeMatricula;
    }

    public void setCodigoDeMatricula(String codigoDeMatricula) {
        this.codigoDeMatricula = codigoDeMatricula;
    }

    public String getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    public void setTamanhoTerreno(String tamanhoTerreno) {
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
