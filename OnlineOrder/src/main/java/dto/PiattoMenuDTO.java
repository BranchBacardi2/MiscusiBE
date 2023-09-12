package dto;

public class PiattoMenuDTO {
    private  int id_piatto ;
    private  int prezzo;


    public PiattoMenuDTO() {
    }

    public int getId_piatto() {
        return id_piatto;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setId_piatto(int id_piatto) {
        this.id_piatto = id_piatto;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
}
