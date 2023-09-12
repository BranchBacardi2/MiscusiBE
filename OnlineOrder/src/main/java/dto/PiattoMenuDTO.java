package dto;

public class PiattoMenuDTO {
    private  int id_piatto ;

    private String nomePiatto;
    private  int prezzo;


    public String getNomePiatto() {
        return nomePiatto;
    }

    public void setNomePiatto(String nomePiatto) {
        this.nomePiatto = nomePiatto;
    }

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
