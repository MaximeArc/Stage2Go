package models;

public class Entreprise {

        private int id;
        private String nom;
        private String description;
        private String activite;
        private String techno;
        private int nb_employes;
        private String logo;
        private String nom_contact;
        private String email_contact;
        private boolean teletravail;


        public Entreprise(int id,
                          String nom,
                          String description,
                          String activite,
                          String techno,
                          int nb_employes,
                          String logo,
                          String nom_contact,
                          String email_contact,
                          boolean teletravail ) {
            this.id = id;
            this.nom = nom;
            this.description = description;
            this.activite = activite;
            this.techno = techno;
            this.nb_employes = nb_employes;
            this.logo = logo;
            this.nom_contact = nom_contact;
            this.email_contact = email_contact;
            this.teletravail = teletravail;
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

        public String getActivite() {
            return activite;
        }
        public void setActivite(String activite) {
            this.activite = activite;
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

        public String getLogo() {
            return logo;
        }
        public void setLogo(String logo) {
            this.logo = logo;
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



        @Override
        public String toString() {
            return "Entreprise{" +
                    "id=" + id +
                    ", nom='" + nom + '\'' +
                    ", description='" + description + '\'' +
                    ", activite='" + activite + '\'' +
                    ", techno='" + techno + '\'' +
                    ", nb_employes='" + nb_employes + '\'' +
                    ", logo='" + logo + '\'' +
                    ", nom_contact='" + nom_contact + '\'' +
                    ", email_contact='" + email_contact + '\'' +
                    ", teletravail='" + teletravail + '\'' +
                    '}';
        }

    }

