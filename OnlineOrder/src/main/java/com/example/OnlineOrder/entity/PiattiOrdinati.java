package com.example.OnlineOrder.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Piatti_ordinati")
public class PiattiOrdinati {
    @Id
    @Column(name = "piatti_ordinati_id")
    private Integer piattiOrdinatiId;

    @Column(name = "quantita")
    private Integer quantita;
    @ManyToOne
    @JoinColumn(name= "piatto_nel_menu")
    private PiattoMenu piattoNelMenu;
    @ManyToOne
    @JoinColumn(name= "ordine_id")
    private Ordine ordine;

    public Integer getPiattiOrdinatiId() {
        return this.piattiOrdinatiId;
    }

    public void setPiattiOrdinatiId(Integer piattiOrdinatiId) {
        this.piattiOrdinatiId = piattiOrdinatiId;
    }

    public Integer getQuantita() {
        return this.quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public PiattoMenu getPiattoNelMenu() {
        return this.piattoNelMenu;
    }

    public void setPiattoNelMenu(PiattoMenu piattoNelMenu) {
        this.piattoNelMenu = piattoNelMenu;
    }

    public Ordine getOrdine() {
        return this.ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }
}
