package net.codejava.proiect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "locatie")
public class Locatie implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nume_statiune", nullable = false, length = 40)
    private String numeStatiune;

    @Column(name = "nume_poza", nullable = false, length = 40)
    private String numePoza;

    @Column(name = "nume_oras", nullable = false, length = 40)
    private String numeOras;

    @Column(nullable = false, length = 40)
    private String tip;

    @Column(name = "bani_pe_zi", nullable = false)
    private Integer baniPeZi;

    @Column(name = "nr_maxim_persoane", nullable = false)
    private Integer nrMaximPersoane;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeStatiune() {
        return numeStatiune;
    }

    public void setNumeStatiune(String numeStatiune) {
        this.numeStatiune = numeStatiune;
    }

    public String getNumePoza() {
        return numePoza;
    }

    public void setNumePoza(String numePoza) {
        this.numePoza = numePoza;
    }

    public String getNumeOras() {
        return numeOras;
    }

    public void setNumeOras(String numeOras) {
        this.numeOras = numeOras;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getBaniPeZi() {
        return baniPeZi;
    }

    public void setBaniPeZi(Integer baniPeZi) {
        this.baniPeZi = baniPeZi;
    }

    public Integer getNrMaximPersoane() {
        return nrMaximPersoane;
    }

    public void setNrMaximPersoane(Integer nrMaximPersoane) {
        this.nrMaximPersoane = nrMaximPersoane;
    }

    @Override
    public int compareTo(Object o) {
        if(this.baniPeZi < ((Locatie) o).baniPeZi)
            return -1;
        if(this.baniPeZi > ((Locatie) o).baniPeZi)
            return 1;
        return 0;
    }
}
