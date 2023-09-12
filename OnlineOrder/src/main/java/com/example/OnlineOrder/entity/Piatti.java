package com.example.OnlineOrder.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "piatti")
public class Piatti {
    @Id
    @Column(name = "piatto_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer piattoId;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "disponibilita")
    private Byte disponibilita;

    @OneToMany(mappedBy = "piatto")
    private List<PiattiIngredienti> ingredienti;

   public List<PiattiIngredienti>  getIngredienti() {return this.ingredienti;}
   public void addIngredient(Ingredienti ingrediente , Integer quantita) {
       PiattiIngredienti piattiIngrediente = new PiattiIngredienti() ;
       piattiIngrediente.setIngrediente(ingrediente);
       piattiIngrediente.setPiatto(this);
       piattiIngrediente.setQuantita(quantita);
       this.ingredienti.add(piattiIngrediente);}

    public Integer getPiattoId() {
        return this.piattoId;
    }

    public void setPiattoId(Integer piattoId) {
        this.piattoId = piattoId;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Byte getDisponibilita() {
        return this.disponibilita;
    }

    public void setDisponibilita(Byte disponibilita) {
        this.disponibilita = disponibilita;
    }
}
