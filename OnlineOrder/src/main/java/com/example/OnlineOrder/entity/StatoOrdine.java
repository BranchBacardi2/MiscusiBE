package com.example.OnlineOrder.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Stato_ordine")
public class StatoOrdine {
    @Id
    @Column(name = "stato_ordine_id")
    private Integer statoOrdineId;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToMany(mappedBy = "stato")
    private List<Ordine> ordini;

    public List<Ordine> getOrdini() {
        return this.ordini;
    }

    public Integer getStatoOrdineId() {
        return this.statoOrdineId;
    }

    public void setStatoOrdineId(Integer statoOrdineId) {
        this.statoOrdineId = statoOrdineId;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
