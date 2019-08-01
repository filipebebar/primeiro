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
public class Cliente extends GenericDomain {

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Column(nullable = false)
    private Boolean liberado;

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getLiberado() {
        return liberado;
    }

    public void setLiberado(Boolean liberado) {
        this.liberado = liberado;
    }
}
