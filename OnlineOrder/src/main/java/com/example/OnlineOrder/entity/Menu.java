package com.example.OnlineOrder.entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_creazione")
    private LocalDateTime dataCreazione;

    @Column(name = "abilitato")
    private Boolean abilitato;


    @OneToMany(mappedBy = "menu")
    private List<PiattoMenu> piatti;

    public List<PiattoMenu> getPiatti() {
        return this.piatti;
    }

    public void addPiatto(PiattoMenu piatto){
        piatto.setMenu(this);
        this.piatti.add(piatto);
    }

    public Integer getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCreazione() {
        return this.dataCreazione;
    }


    public Boolean getAbilitato() {
        return abilitato;
    }

    public void setAbilitato(Boolean abilitato) {
        this.abilitato = abilitato;
    }


/*
    private  String ToStringpiatti(){
        String result= "[\' ";
        this.piatti.stream().map(piatto ->  "{ piatto ="+ piatto.getPiatto() + '\''+
                                                      "prezzo ="+ piatto.getPrezzo() + "} \'");
        result=result+" ]";
        return  result;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", nome='" + nome + '\'' +
                ", dataCreazione=" + dataCreazione +
                ", abilitato=" + abilitato +
                ", piatti=" + this.ToStringpiatti() +
                '}';
    }
    */

}
