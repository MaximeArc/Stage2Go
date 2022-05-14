package models;

public class Commentaire {
    private int created_date;
    private String contenu;
    private int id_stagiaire;
    private int id_entreprise;

    public Commentaire(int created_date, String contenu, int id_stagiaire, int id_entreprise) {
        this.created_date = created_date;
        this.contenu = contenu;
        this.id_stagiaire = id_stagiaire;
        this.id_entreprise = id_entreprise;
    }

    public int getCreated_date() {
        return created_date;
    }
    public void setCreated_date(int created_date) {
        this.created_date = created_date;
    }

    public String getContenu() {
        return contenu;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getId_stagiaire() {
        return id_stagiaire;
    }
    public void setId_stagiaire(int id_stagiaire) {
        this.id_stagiaire = id_stagiaire;
    }

    public int getId_entreprise() {
        return id_entreprise;
    }
    public void setId_entreprise(int id_entreprise) {
        this.id_entreprise = id_entreprise;
    }

    @Override
    public String toString() {
        return "Commentaire {" +
                "created_date=" + created_date +
                ", contenu='" + contenu + '\'' +
                ", id_stagiaire=" + id_stagiaire +
                ", id_entreprise=" + id_entreprise +
                '}';
    }
}
