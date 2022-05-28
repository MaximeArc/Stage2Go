package models;

public class Commentaire {
    private int id;
    private String contenu;
    private int idEntreprise;
    private int idStagiaire;

    public int getId() {
        return id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getContenu(){
        return contenu;
    }

    public void setContenu(String contenu){
        this.contenu = contenu;
    }

    public int getIdEntreprise(){
        return idEntreprise;
    }

    public int getIdStagiaire(){
        return idStagiaire;
    }

    public void setIdEntreprise(int idEntreprise){
        this.idEntreprise = idEntreprise;
    }

    public void setIdStagiaire(int idStagiaire){
        this.idStagiaire = idStagiaire;
    }

    public Commentaire(){

    }
}


