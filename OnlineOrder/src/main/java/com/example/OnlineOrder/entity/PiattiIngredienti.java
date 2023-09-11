package com.example.OnlineOrder.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Piatti_ingredienti")
public class PiattiIngredienti {
    @Id
    @Column(name = "prodotti_ingredienti_id")
    private Integer prodottiIngredientiId;
    @ManyToOne
    @JoinColumn(name="piatto")
    private Piatti  piatto;
    @ManyToOne
    @JoinColumn(name="ingrediente")
    private Ingredienti ingrediente;

    @Column(name = "quantita")
    private Integer quantita;

    public Integer getProdottiIngredientiId() {
        return this.prodottiIngredientiId;
    }

    public void setProdottiIngredientiId(Integer prodottiIngredientiId) {
        this.prodottiIngredientiId = prodottiIngredientiId;
    }

    public Piatti getPiatto() {
        return this.piatto;
    }

    public void setPiatto(Piatti piatto) {
        this.piatto = piatto;
    }

    public Ingredienti getIngrediente() {
        return this.ingrediente;
    }

    public void setIngrediente(Ingredienti ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Integer getQuantita() {
        return this.quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }
}
