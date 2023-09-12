package com.example.OnlineOrder.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "ingredienti")
public class Ingredienti {
    @Id
    @Column(name = "ingrediente_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ingredienteId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "unita_misura")
    private String unitaMisura;

    @Column(name = "disponibilita_magazzino")
    private Float disponibilitaMagazzino;

    @Column(name = "soglia_minima")
    private Integer sogliaMinima;

    @OneToMany(mappedBy = "ingrediente")
    private List<PiattiIngredienti> piatti;

    public  List<PiattiIngredienti> getIngredienti(){
        return this.piatti;
    }
    public Integer getIngredienteId() {
        return this.ingredienteId;
    }

    public void setIngredienteId(Integer ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnitaMisura() {
        return this.unitaMisura;
    }

    public void setUnitaMisura(String unitaMisura) {
        this.unitaMisura = unitaMisura;
    }

    public Float getDisponibilitaMagazzino() {
        return this.disponibilitaMagazzino;
    }

    public void setDisponibilitaMagazzino(Float disponibilitaMagazzino) {
        this.disponibilitaMagazzino = disponibilitaMagazzino;
    }

    public Integer getSogliaMinima() {
        return this.sogliaMinima;
    }

    public void setSogliaMinima(Integer sogliaMinima) {
        this.sogliaMinima = sogliaMinima;
    }
}
