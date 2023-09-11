package com.example.OnlineOrder.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @Column(name = "cliente_id")
    private Integer clienteId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "indirizzo_spedizione")
    private String indirizzoSpedizione;

    @Column(name = "mail")
    private String mail;


    @OneToMany(mappedBy = "cliente")
    private List<Ordine> ordini;

    public List<Ordine> getOrdini(){ return this.ordini;}

    public void addOrder(Ordine ordine){
        ordine.setCilente(this);
        this.ordini.add(ordine);
    }

    public Integer getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
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

    public String getIndirizzoSpedizione() {
        return this.indirizzoSpedizione;
    }

    public void setIndirizzoSpedizione(String indirizzoSpedizione) {
        this.indirizzoSpedizione = indirizzoSpedizione;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
