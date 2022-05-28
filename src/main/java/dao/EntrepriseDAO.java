package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.AccessibleRole;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.Adresse;
import models.Commentaire;
import models.Entreprise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EntrepriseDAO extends DAO<Entreprise> {

    private static final String TABLE = "ENTREPRISE";
    private static final String CLE_PRIMAIRE = "id";
    private static final String NOM = "nom";
    private static final String NOM_CONTACT = "nom_contact";
    private static final String EMAIL_CONTACT = "email_contact";
    private static final String NB_EMPLOYES = "nb_employes";
    private static final String DESCRIPTION = "description";
    private static final String TECHNO = "techno";
    private static final String TELETRAVAIL = "teletravail";
    private static final String ACTIVITES = "activites";
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
        boolean success = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + NOM + "," + NOM_CONTACT + "," + EMAIL_CONTACT + ","
                    + NB_EMPLOYES + "," + DESCRIPTION + "," + TECHNO + "," + TELETRAVAIL + "," + ACTIVITES + "," + ID_ADRESSE + ")" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getNom());
            pst.setString(2, obj.getNomContact());
            pst.setString(3, obj.getEmail_contact());
            pst.setInt(4, obj.getNb_employes());
            pst.setString(5, obj.getDescription());
            pst.setString(6, obj.getTechno());
            pst.setBoolean(7, obj.isTeletravail());
            pst.setString(8, obj.getActivites());
            pst.setInt(9, obj.getAdresse().getId());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }
            donnees.put(obj.getId(), obj);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean delete(Entreprise obj) {
        boolean success = true;
        try {
            int id = obj.getId();
            String requete = "DELETE FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            donnees.remove(id);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean update(Entreprise obj) {
        boolean success = true;
        int id = obj.getId();
        try {
            String requete = "UPDATE " + TABLE + " SET " + NOM + " = ?, " + DESCRIPTION + " = ? , " + ACTIVITES + " = ?, " + TECHNO + " = ?, " + NB_EMPLOYES + " = ?, " + NOM_CONTACT + " = ?, " + EMAIL_CONTACT + " =?, " + TELETRAVAIL + " =? WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);

            pst.setString(1, obj.getNom());
            pst.setString(2, obj.getDescription());
            pst.setString(3, obj.getActivites());
            pst.setString(4, obj.getTechno());
            pst.setInt(5, obj.getNb_employes());
            pst.setString(6, obj.getNomContact());
            pst.setString(7, obj.getEmail_contact());
            pst.setBoolean(8, obj.isTeletravail());


            pst.setInt(9, id);
            pst.executeUpdate();
            donnees.put(id, obj);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public Entreprise read(int id) {
        Entreprise entreprise = null;
        if (donnees.containsKey(id)) {
            entreprise = donnees.get(id);
        } else {
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();

                String nom = rs.getString(NOM);
                String nom_contact = rs.getString(NOM_CONTACT);
                String email_contact = rs.getString(EMAIL_CONTACT);
                int nb_employes = rs.getInt(NB_EMPLOYES);
                String description = rs.getString(DESCRIPTION);
                String techno = rs.getString(TECHNO);
                boolean teletravail = rs.getBoolean(TELETRAVAIL);
                String activites = rs.getString(ACTIVITES);
                int id_adresse = rs.getInt(ID_ADRESSE);
                Adresse adresse = AdresseDAO.getInstance().read(id_adresse);

                entreprise = new Entreprise(nom, nom_contact, email_contact, nb_employes, description, techno, teletravail, activites, adresse);
                entreprise.setId(id);
                donnees.put(id, entreprise);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return entreprise;
    }


    public ArrayList<Entreprise> readAll() {
        Entreprise entreprise = null;
        ArrayList<Entreprise> listeEntreprise = null;
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
        int id = rs.getInt(CLE_PRIMAIRE);
        String nom = rs.getString(NOM);
        String nom_contact = rs.getString(NOM_CONTACT);
        String email_contact = rs.getString(EMAIL_CONTACT);
        Integer nb_employes = rs.getInt(NB_EMPLOYES);
        String description = rs.getString(DESCRIPTION);
        String activites = rs.getString(ACTIVITES);
        boolean teletravail = rs.getBoolean(TELETRAVAIL);
        Integer adresseId = rs.getInt(ID_ADRESSE);
        Adresse adresse = AdresseDAO.getInstance().read(adresseId);
        String techno = rs.getString(TECHNO);
        entreprise = new Entreprise(nom, nom_contact, email_contact, nb_employes, description, techno, teletravail, activites, adresse);
        entreprise.setId(id);
        return entreprise;
    }

}