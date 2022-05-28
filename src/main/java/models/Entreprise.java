package models;

public class Entreprise {

    private int id;
    private String nom;
    private String description;
    private String activites;
    private String techno;
    private int nb_employes;
    private String nom_contact;
    private String email_contact;
    private boolean teletravail;
    private String ville;
    private Adresse adresse;


    public Entreprise(String nom,
                      String description,
                      String activites,
                      String techno,
                      int nb_employes,
                      String nom_contact,
                      String email_contact,
                      boolean teletravail) {

        this.nom = nom;
        this.description = description;
        this.activites = activites;
        this.techno = techno;
        this.nb_employes = nb_employes;
        this.nom_contact = nom_contact;
        this.email_contact = email_contact;
        this.teletravail = teletravail;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivites() {
        return activites;
    }
    public void setActivites(String activites) {
        this.activites = activites;
    }

    public String getTechno() {
        return techno;
    }
    public void setTechno(String techno) {
        this.techno = techno;
    }

    public int getNb_employes() {
        return nb_employes;
    }
    public void setNb_employes(int nb_employes) {
        this.nb_employes = nb_employes;
    }

    public String getNom_contact() {
        return nom_contact;
    }
    public void setNom_contact(String nom_contact) {
        this.nom_contact = nom_contact;
    }

    public String getEmail_contact() {
        return email_contact;
    }
    public void setEmail_contact(String email_contact) {
        this.email_contact = email_contact;
    }

    public boolean getTeletravail() {
        return teletravail;
    }
    public void setTeletravail(boolean teletravail) {
        this.teletravail = teletravail;
    }

    public String getVille() {
        return ville;
    }
    public void setVille(String nom) {
        this.ville = ville;
    }



    @Override
    public String toString() {
        return "Entreprise{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", nom_contact='" + nom_contact + '\'' +
                ", email_contact='" + email_contact + '\'' +
                '}';
    }

    public String getNomContact() {
        return getNom_contact();
    }

    public boolean isTeletravail() {
        return teletravail;
    }

    public Adresse getAdresse() { return adresse;}
    public void setAdresse(Adresse adresse) {this.adresse=adresse; }

}