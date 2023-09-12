package com.example.OnlineOrder.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "piatto_menu")
public class PiattoMenu {
    @Id
    @Column(name = "piatto_menu_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer piattoMenuId;
    @ManyToOne
    @JoinColumn(name="piatto")
    private Piatti piatto;

    @ManyToOne
    @JoinColumn(name="menu")
    private Menu menu;

    @Column(name = "prezzo")
    private Float prezzo;

    public Integer getPiattoMenuId() {
        return this.piattoMenuId;
    }

    public void setPiattoMenuId(Integer piattoMenuId) {
        this.piattoMenuId = piattoMenuId;
    }

    public Piatti getPiatto() {
        return this.piatto;
    }

    public void setPiatto(Piatti piatto) {
        this.piatto = piatto;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Float getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(Float prezzo) {
        this.prezzo = prezzo;
    }
}
