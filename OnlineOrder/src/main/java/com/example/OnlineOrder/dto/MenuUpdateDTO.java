package com.example.OnlineOrder.dto;

import java.util.List;

public class MenuUpdateDTO {

    private  int id;
    private  String menuName;
    private  boolean abilitato;

    private List<PiattoMenuDTO> piatti;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuUpdateDTO() {

    }




    public String getMenuName() {
        return menuName;
    }

    public boolean isAbilitato() {
        return abilitato;
    }

    public List<PiattoMenuDTO> getPiatti() {
        return piatti;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setAbilitato(boolean abilitato) {
        this.abilitato = abilitato;
    }

    public void setPiatti(List<PiattoMenuDTO> piatti) {
        this.piatti = piatti;
    }



}
