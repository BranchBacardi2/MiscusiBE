package com.example.OnlineOrder.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Ordine")
public class Ordine {
    @Id
    @Column(name = "ordine_id")
    private Integer ordineId;

    @Column(name = "data_ordine")
    private LocalDateTime dataOrdine;

    @Column(name = "indirizzo_consegna")
    private String indirizzoConsegna;
    @ManyToOne
    @JoinColumn(name="stato_ordine_id")
    private StatoOrdine stato;
    @ManyToOne
    @JoinColumn(name= "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name ="cuoco")
    private Staff cuoco;
    @ManyToOne
    @JoinColumn(name ="fattorino")
    private Staff fattorino;

    @OneToMany(mappedBy = "ordine")
    private List<PiattiOrdinati> piatti;

    public List<PiattiOrdinati> getPiattiOrdinati() {
        return this.piatti;
    }

    public void addPiatto(PiattiOrdinati piatto) {
        piatto.setOrdine(this);
        this.piatti.add(piatto);
    }

    public Integer getOrdineId() {
        return this.ordineId;
    }

    public void setOrdineId(Integer ordineId) {
        this.ordineId = ordineId;
    }

    public LocalDateTime getDataOrdine() {
        return this.dataOrdine;
    }

    public void setDataOrdine(LocalDateTime dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public String getIndirizzoConsegna() {
        return this.indirizzoConsegna;
    }

    public void setIndirizzoConsegna(String indirizzoConsegna) {
        this.indirizzoConsegna = indirizzoConsegna;
    }

    public StatoOrdine getStato() {
        return this.stato;
    }

    public void setStato(StatoOrdine stato) {
        this.stato = stato;
    }

    public Cliente getCilente() {
        return this.cliente;
    }

    public void setCilente(Cliente cilente) {
        this.cliente = cilente;
    }

    public Staff getCuoco() {
        return this.cuoco;
    }

    public void setCuoco(Staff cuoco) {
        this.cuoco = cuoco;
    }

    public Staff getFattorino() {
        return this.fattorino;
    }

    public void setFattorino(Staff fattorino) {
        this.fattorino = fattorino;
    }
}
