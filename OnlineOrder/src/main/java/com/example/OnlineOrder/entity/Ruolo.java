package com.example.OnlineOrder.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "ruolo")
public class Ruolo {
    @Id
    @Column(name = "ruolo_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ruoloId;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToMany(mappedBy = "ruolo")
    private List<Staff> dipendenti;

    public List<Staff> getDipendenti(){
        return this.dipendenti;
    }

    public Integer getRuoloId() {
        return this.ruoloId;
    }

    public void setRuoloId(Integer ruoloId) {
        this.ruoloId = ruoloId;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
