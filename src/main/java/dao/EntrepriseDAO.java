package dao;

import models.Entreprise;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EntrepriseDAO extends DAO<Entreprise> {

    private static final String TABLE = "ENTREPRISE";
    private static final String CLE_PRIMAIRE = "id";
    private static final String NOM = "nom";
    private static final String DESCRIPTION = "description";
    private static final String ACTIVITE = "activite";
    private static final String TECHNO = "techno";
    private static final int NB_EMPLOYES = Integer.parseInt("nb_employes");
    private static final String LOGO = "logo";
    private static final String NOM_CONTACT = "nom_contact";
    private static final String EMAIL_CONTACT = "email_contact";
    private static final boolean TELETRAVAIL = Boolean.parseBoolean("teletravail");

    private static EntrepriseDAO instance = null;

    public static EntrepriseDAO getInstance() {
        if (instance == null) {
            instance = new EntrepriseDAO();
        }
        return instance;
    }

    public EntrepriseDAO() {
        super();
    }

    @Override
    public boolean create(Entreprise obj) {
        return false;
    }

    @Override
    public boolean delete(Entreprise obj) {
        return false;
    }

    @Override
    public boolean update(Entreprise obj) {
        return false;
    }

    @Override
    public Entreprise read(int id) {
        Entreprise entreprise = null;
        if (donnees.containsKey(id)) {
            System.out.println("récupéré");
            entreprise = donnees.get(id);
        } else {
            System.out.println("Recherche dans la BD");
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                String nom = rs.getString(NOM);
                String description = rs.getString(DESCRIPTION);
                String activite = rs.getString(ACTIVITE);
                String techno = rs.getString(TECHNO);
                int nb_employes = rs.getInt(NB_EMPLOYES);
                String logo = rs.getString(LOGO);
                String nom_contact = rs.getString(NOM_CONTACT);
                String email_contact = rs.getString(EMAIL_CONTACT);
                boolean teletravail = rs.getBoolean(String.valueOf(TELETRAVAIL));


                entreprise = new Entreprise(id, nom, description, activite, techno, nb_employes, logo, nom_contact, email_contact, teletravail);
                donnees.put(id, entreprise);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return entreprise;
    }
}