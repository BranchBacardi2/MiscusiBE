package com.example.OnlineOrder.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MenuResponseDTO {

    private  int menuId;
    private  String menuName;
    private  boolean abilitato;

    private LocalDateTime dataCreazione;

    private List<PiattoMenuDTO> piatti ;


    public MenuResponseDTO() {

    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDateTime dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
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

    public  void addPiatto(PiattoMenuDTO piattoDTO) {
        if (this.piatti == null){
            this.piatti= new ArrayList<PiattoMenuDTO>();
        }
        this.piatti.add(piattoDTO);
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


