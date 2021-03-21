package net.codejava.proiect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "calatorii")
public class Calatorii {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_user", nullable = false)
    private Long idUser;


    @Column(name = "id_locatie", nullable = false)
    private Long idLocatie;


    @Column(name = "nr_calatorii", nullable = false)
    private Long nrCalatorii;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdLocatie() {
        return idLocatie;
    }

    public void setIdLocatie(Long idLocatie) {
        this.idLocatie = idLocatie;
    }

    public Long getNrCalatorii() {
        return nrCalatorii;
    }

    public void setNrCalatorii(Long nrCalatorii) {
        this.nrCalatorii = nrCalatorii;
    }
}
