package dao;

import models.Adresse;

import java.sql.*;


public class AdresseDAO extends DAO<Adresse> {

    private static final String TABLE = "ADRESSE";
    private static final String CLE_PRIMAIRE = "id";

    private static final String NUMERO = "numero";
    private static final String ADRESSE = "adresse";
    private static final String VILLE = "ville";
    private static final String CODE_POSTAL = "code_postal";
    //private static final String ID_UTILISATEUR = "id_utilisateur";
    //private static final String ID_ENTREPRISE = "id_entreprise";

    private static AdresseDAO instance = null;

    public static AdresseDAO getInstance() {
        if (instance == null) {
            instance = new AdresseDAO();
        }
        return instance;
    }

    private AdresseDAO() {
        super();
    }

    @Override
    public boolean create(Adresse obj) {
        boolean succes = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + NUMERO + "," + ADRESSE + "," + VILLE + "," + CODE_POSTAL + ") " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, obj.getNumero());
            pst.setString(2, obj.getAdresse());
            pst.setString(3, obj.getVille());
            pst.setInt(4, obj.getCode_postal());

            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                obj.setId(rs.getInt(1));
            }
            donnees.put(obj.getId(), obj);
        } catch (SQLException e) {
            succes = false;
            e.printStackTrace();
        }
        return succes;
    }

    @Override
    public boolean delete(Adresse obj) {
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
    public boolean update(Adresse obj) {
        boolean success = true;
        int id = obj.getId();
        try {
            String requete = "UPDATE " + TABLE + " SET " + NUMERO +  " = ?, " + ADRESSE + " = ? , " + VILLE + " = ?, " + CODE_POSTAL + " = ? " +
                    "WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            pst.setInt(1, obj.getNumero());
            pst.setString(2, obj.getAdresse());
            pst.setString(3, obj.getVille());
            pst.setInt(4, obj.getCode_postal());

            pst.setInt(5, id);
            pst.executeUpdate();
            donnees.put(id, obj);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public Adresse read(int id) {
        Adresse adresse = null;
        if (donnees.containsKey(id)) {
            adresse = donnees.get(id);
        } else {
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                int numero = rs.getInt(NUMERO);
                String adresses = rs.getString(ADRESSE);
                String ville = rs.getString(VILLE);
                int code_postal = rs.getInt(CODE_POSTAL);

                adresse = new Adresse(id, numero, adresses, ville, code_postal);
                donnees.put(id, adresse);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adresse;
    }

}