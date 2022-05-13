package models;

public class Entreprise {


        private int id;
        private String nom;
        private String email;
        private String num_tel;
        private String nom_contact;
        private String email_contact;
        private String num_contact;
        private String description;
        private String techno;
        private boolean teletravail;



        public Entreprise(String nom, String nom_contact, String email_contact, int nb_salarie, String description, String techno, boolean teletravail) {

            this.nom = nom;
            this.email = email;
            this.nom_contact = nom_contact;
            this.email_contact = email_contact;
            this.teletravail = teletravail;
            this.techno = techno;
            this.description = description;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNum_tel() {
            return num_tel;
        }

        public void setNum_tel(String num_tel) {
            this.num_tel = num_tel;
        }

        public String getnom_contact() {
            return nom_contact;
        }

        public void setnom_contact(String nom_contact) {
            this.nom_contact = nom_contact;
        }

        public String getEmail_contact() {
            return email_contact;
        }

        public void setEmail_contact(String email_contact) {
            this.email_contact = email_contact;
        }

        public String getNum_contact() {
            return num_contact;
        }

        public void setNum_contact(String num_contact) {
            this.num_contact = num_contact;
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

        @Override
        public String toString() {
            return "Entreprise{" +
                    "id=" + id +
                    ", nom='" + nom + '\'' +
                    ", email='" + email + '\'' +
                    ", num_tel='" + num_tel + '\'' +
                    ", nom_contact='" + nom_contact + '\'' +
                    ", email_contact='" + email_contact + '\'' +
                    ", num_contact='" + num_contact + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }

    }

