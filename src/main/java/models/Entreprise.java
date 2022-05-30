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
        private int id_entreprise;
        private int nb_employesVannes;



        public Entreprise(String nom,
                          String description,
                          String activites,
                          String techno,
                          int nb_employes,
                          String nom_contact,
                          String email_contact,
                          boolean teletravail,
                          String ville,
                          int nb_employesVannes) {

            this.nom = nom;
            this.description = description;
            this.activites = activites;
            this.techno = techno;
            this.nb_employes = nb_employes;
            this.nom_contact = nom_contact;
            this.email_contact = email_contact;
            this.teletravail = teletravail;
            this.ville = ville;
            this.nb_employesVannes = nb_employesVannes;

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

        public String getNomContact() {
            return nom_contact;
        }
        public void setNomContact(String nom_contact) {
            this.nom_contact = nom_contact;
        }

        public String getEmailContact() {
            return email_contact;
        }
        public void setEmailContact(String email_contact) {
            this.email_contact = email_contact;
        }

        public boolean isTeletravail() {
            return teletravail;
        }
        public void setTeletravail(boolean teletravail) {
            this.teletravail = teletravail;
        }

        public String getVille() { return ville; }
        public void setVille(String nom) { this.ville = ville; }

        public int getNbEmployesVannes() { return nb_employesVannes; }
        public void setNbEmployesVannes(int nb_employesVannes) { this.nb_employesVannes = nb_employesVannes; }



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

    }

