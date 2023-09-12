package dto;

import java.util.List;

public class MenuCreateDTO {

    private  int mneId;
    private  String menuName;
    private  boolean abilitato;

    private List<PiattoMenuDTO> piatti;


    public MenuCreateDTO() {

    }

    public int getMneId() {
        return mneId;
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

    public void setMneId(int mneId) {
        this.mneId = mneId;
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
