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
    private static final String TECHNO ="techno";
    private static final String TELETRAVAIL ="teletravail";
    private static final String ACTIVITES = "activites";
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
        boolean success = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + NOM + "," + NOM_CONTACT + "," + EMAIL_CONTACT + ","
                    + NB_EMPLOYES + "," + DESCRIPTION + "," + TECHNO + "," + TELETRAVAIL + "," + ACTIVITES + ","
                    + VILLE + ")" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getNom());
            pst.setString(2, obj.getNomContact());
            pst.setString(3, obj.getEmail_contact());
            pst.setInt(4, obj.getNb_employes());
            pst.setString(5, obj.getDescription());
            pst.setString(6, obj.getTechno());
            pst.setBoolean(7, obj.isTeletravail());
            pst.setString(8, obj.getActivites());
            pst.setString(9, obj.getVille());
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
        return false;
    }

    @Override
    public boolean update(Entreprise obj) {
        boolean success = true;
        int id = obj.getId();
        try {
            String requete = "UPDATE " + TABLE + " SET "  + " = ?, " + NOM + " = ?, " + DESCRIPTION + " = ? , "  + ACTIVITES + " = ?, "  + TECHNO + " = ?, " + NB_EMPLOYES + " = ?, " + NOM_CONTACT + " = ?, " + EMAIL_CONTACT + " =?, " + TELETRAVAIL + " =?, WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);

            pst.setString(2, obj.getNom());
            pst.setString(3, obj.getDescription());
            pst.setString(4, obj.getActivites());
            pst.setString(5, obj.getTechno());
            pst.setInt(6, obj.getNb_employes());
            pst.setString(7,obj.getNomContact());
            pst.setString(8,obj.getEmail_contact());
            pst.setBoolean(9,obj.isTeletravail());


            pst.setInt(10, id);
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
                String ville = rs.getString(VILLE);
                int id_adresse = rs.getInt(ID_ADRESSE);

                entreprise = new Entreprise(nom, nom_contact, email_contact, nb_employes, description, techno, teletravail, activites, ville, id_adresse);
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
        int id = rs.getInt(CLE_PRIMAIRE);
        String nom = rs.getString(NOM);
        String nom_contact = rs.getString(NOM_CONTACT);
        String email_contact = rs.getString(EMAIL_CONTACT);
        Integer nb_employes = rs.getInt(NB_EMPLOYES);
        String description = rs.getString(DESCRIPTION);
        String activites = rs.getString(ACTIVITES);
        boolean teletravail = rs.getBoolean(TELETRAVAIL);
        Integer adresse = rs.getInt(ID_ADRESSE);
        String techno = rs.getString(TECHNO);
        String ville = rs.getString(VILLE);
        entreprise = new Entreprise(nom, nom_contact, email_contact, nb_employes, description, techno, teletravail, activites, ville, adresse);
        entreprise.setId(id);
        return entreprise;
    }
  /*  public ObservableList<Entreprise> data = FXCollections.observableArrayList();

    public ObservableList<Entreprise> readAll() {
        try {
            String requete = "SELECT * FROM " + TABLE;
            PreparedStatement stat = Connexion.getInstance().prepareStatement(requete);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
            data.add(new Entreprise(rs.getString("nom"),rs.getString("nom_contact"),rs.getString("email_contact"),rs.getInt("nb_employes"),rs.getString("description"),rs.getString("techno"),rs.getBoolean("teletravail")));
            }
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }*/

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