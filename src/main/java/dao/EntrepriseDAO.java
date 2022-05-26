package dao;

import models.Adresse;
import models.Commentaire;
import models.Entreprise;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class EntrepriseDAO extends DAO<Entreprise> {

    private static final String TABLE = "ENTREPRISE";
    private static final String CLE_PRIMAIRE = "id";
    private static final String NOM = "nom";
    private static final String DESCRIPTION = "description";
    private static final String ACTIVITES = "activites";
    private static final String TECHNO = "techno";
    private static final String NB_EMPLOYES = "nb_employes";
    private static final String NOM_CONTACT = "nom_contact";
    private static final String EMAIL_CONTACT = "email_contact";
    private static final String TELETRAVAIL = "teletravail";
    private static final String VILLE = "ville";
    private static final String ID_ADRESSE = "id_adresse";

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
                String activites = rs.getString(ACTIVITES);
                String techno = rs.getString(TECHNO);
                int nb_employes = rs.getInt(NB_EMPLOYES);
                String nom_contact = rs.getString(NOM_CONTACT);
                String email_contact = rs.getString(EMAIL_CONTACT);
                boolean teletravail = rs.getBoolean(String.valueOf(TELETRAVAIL));
                String ville = rs.getString(VILLE);
                int id_adresse = rs.getInt(ID_ADRESSE);


                entreprise = new Entreprise(nom, description, activites, techno,nb_employes, nom_contact, email_contact, teletravail, ville, id_adresse );
                donnees.put(id, entreprise);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return entreprise;
    }

    public ArrayList<Entreprise> readAll() {
        Entreprise entreprise = null;
        ArrayList<Entreprise> listeEntreprise =null;
        try {
            String requete = "SELECT * FROM " + TABLE;
            ResultSet rs = Connexion.executeQuery(requete);
            listeEntreprise = new ArrayList<Entreprise>();
            boolean hasNext = rs.next();
            while (hasNext) {
                entreprise = getEntreprise(rs);
                listeEntreprise.add(entreprise);
                hasNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeEntreprise;
    }

    private Entreprise getEntreprise(ResultSet rs) throws SQLException {
        Entreprise entreprise;
        String nom = rs.getString(NOM);
        String nom_contact = rs.getString(NOM_CONTACT);
        String email_contact = rs.getString(EMAIL_CONTACT);
        Integer nb_employes = rs.getInt(NB_EMPLOYES);
        String description = rs.getString(DESCRIPTION);
        String activites = rs.getString(ACTIVITES);
        boolean teletravail = rs.getBoolean(String.valueOf(TELETRAVAIL));
        String techno = rs.getString(TECHNO);
        String ville = rs.getString(VILLE);
        int id_adresse = rs.getInt(ID_ADRESSE);
        entreprise = new Entreprise(nom, description, activites, techno, nb_employes, nom_contact, email_contact,teletravail,ville, id_adresse);
        return entreprise;
    }
    public String getCommentsByEntrepriseId (int id) {
        String comment = null;
        try {
            String requete = "SELECT COMMENTAIRE.contenu FROM " + TABLE + " JOIN COMMENTAIRE ON COMMENTAIRE.id_entreprise=" + TABLE + ".id WHERE ENTREPRISE." + CLE_PRIMAIRE + " = " + id;
            ResultSet rs = Connexion.executeQuery(requete);
            rs.next();
            comment = rs.getString("contenu");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }

    public Adresse getAdress(int id) {
        Adresse adress = new Adresse();
        try {
            String requete = "SELECT * FROM " + TABLE + " JOIN ADRESSE ON ADRESSE.id=" + TABLE + ".id_adresse WHERE ENTREPRISE." + CLE_PRIMAIRE + " = " + id;
            ResultSet rs = Connexion.executeQuery(requete);
            rs.next();

            adress.setAdresse(rs.getString("adresse"));
            adress.setNumero(rs.getInt("numero"));
            adress.setCode_postal(rs.getInt("code_postal"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adress;
    }

    public ArrayList<Commentaire> getComments(int idEntreprise) {
        Commentaire comment = null;
        ArrayList<Commentaire> listComments =null;
        try {
            String requete = "SELECT * FROM " + TABLE + " JOIN COMMENTAIRE ON COMMENTAIRE.id_entreprise= " + TABLE +".id WHERE " + TABLE + ".id=" + idEntreprise;
            ResultSet rs = Connexion.executeQuery(requete);
            listComments = new ArrayList<Commentaire>();
            boolean hasNext = rs.next();
            while (hasNext) {
                comment = getComment(rs);
                listComments.add(comment);
                hasNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listComments;
    }

    private Commentaire getComment(ResultSet rs) throws SQLException {
        Commentaire comment;
        String contenu = rs.getString("contenu");

        comment = new Commentaire();
        comment.setContenu(contenu);
        return comment;
    }

}