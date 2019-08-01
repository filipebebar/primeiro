package br.com.imobisoftware.domain;

import javax.persistence.*;

/**
* Project Name: ImobiSoftware
* User: Filipe Barbosa
* Date: 25/07/2019
*/

@Entity
@SuppressWarnings("Serial")
public class Fiador extends GenericDomain{

    @JoinColumn
    @OneToOne
    private Conjugue conjugue;

    @JoinColumn
    @ManyToOne
    private Imovel imovel;

    @Column(length = 15, nullable = false)
    private String matriculaDoImovel;






    //getters and setters
    public Conjugue getConjugue() {
        return conjugue;
    }

    public void setConjugue(Conjugue conjugue) {
        this.conjugue = conjugue;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public String getMatriculaDoImovel() {
        return matriculaDoImovel;
    }

    public void setMatriculaDoImovel(String matriculaDoImovel) {
        this.matriculaDoImovel = matriculaDoImovel;
    }
}
