package com.example.OnlineOrder.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    @Column(name = "dipendente_id")
    private Integer dipendenteId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;
    @ManyToOne
    @JoinColumn(name = "ruolo")
    private Ruolo ruolo;

    @OneToMany(mappedBy = "cuoco")
    private List<Ordine> ordiniCuoco;

    @OneToMany(mappedBy = "fattorino")
    private List<Ordine> ordiniFattorino;

    public List<Ordine> getConsegne(){
        return  this.ordiniFattorino;
    }

    public  List<Ordine> getOrdiniCuoco(){
        return  this.ordiniCuoco;
    }

    public Integer getDipendenteId() {
        return this.dipendenteId;
    }

    public void setDipendenteId(Integer dipendenteId) {
        this.dipendenteId = dipendenteId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Ruolo getRuolo() {
        return this.ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
}
