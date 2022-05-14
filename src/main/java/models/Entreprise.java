package models;

import javafx.beans.value.ObservableValue;

public class Entreprise {


        private int id;
        private String nom;
        private String nom_contact;
        private String email_contact;
        private String description;
        private String ville;
        private int nb_employes;
        private String techno;
        private String activites;
        private boolean teletravail;




    public Entreprise(String nom, String nom_contact, String email_contact, int nb_employes, String description, String techno, boolean teletravail, String activites, String ville) {

            this.nom = nom;
            this.nb_employes = nb_employes;
            this.nom_contact = nom_contact;
            this.email_contact = email_contact;
            this.teletravail = teletravail;
            this.techno = techno;
            this.activites = activites;
            this.description = description;
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

        public String getNomContact() {
            return nom_contact;
        }
        public void setNomContact(String nom_contact) {
            this.nom_contact = nom_contact;
        }

        public String getEmail_contact() {
            return email_contact;
        }
        public void setEmail_contact(String email_contact) {
            this.email_contact = email_contact;
        }

        public String getActivites() {
        return activites;
    }
        public void setActivites(String activites) {
        this.activites = activites;
    }

        public boolean isTeletravail() {
            return teletravail;
        }
        public void setTeletravail(boolean teletravail) {
            this.teletravail = teletravail;
        }

        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }

        public String getTechno() { return techno; }
        public void setTechno(String techno) { this.techno = techno;}

        public String getNom_contact() {return nom_contact;}
        public void setNom_contact(String nom_contact) {this.nom_contact = nom_contact;}

        public int getNb_employes() {return nb_employes;}
        public void setNb_employes(int nb_employes) {this.nb_employes = nb_employes;}

        public String getVille() {return ville;}
        public void setVille(String ville) {this.ville = ville;}


    @Override
        public String toString() {
            return "Entreprise{" +
                    "id=" + id +
                    ", nom='" + nom + '\'' +
                    ", nom_contact='" + nom_contact + '\'' +
                    ", email_contact='" + email_contact + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }


}

