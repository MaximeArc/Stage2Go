package dao;

import models.Entreprise;
import models.Utilisateur;


import java.sql.*;
import java.util.ArrayList;

public class UtilisateurDAO extends DAO<Utilisateur> {


    private static final String TABLE = "UTILISATEUR";
    private static final String CLE_PRIMAIRE = "id";

    private static final String NOM = "nom";
    private static final String PRENOM = "prenom";
    private static final String EMAIL = "email";
    private static final String MOT_DE_PASSE = "mdp";
    private static final String EST_ADMIN = "admin";
    private static final String LIEU_STAGE="lieu_stage";
    private static final String ANNEE ="annee";


    private static UtilisateurDAO instance = null;

    public static UtilisateurDAO getInstance() {
        if (instance == null) {
            instance = new UtilisateurDAO();
        }
        return instance;
    }

    private UtilisateurDAO() {
        super();
    }


    @Override
    public boolean create(Utilisateur obj) {
        boolean success = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + NOM + "," + PRENOM + "," + EMAIL + "," +
                    ","  + MOT_DE_PASSE + "," + EST_ADMIN +  ") " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            // on pose un String en paramètre 1 -1er '?'- et ce String est le nom de l'avion
            // pst.setInt(1, obj.getPromo());
            pst.setString(2, obj.getNom());
            pst.setString(3, obj.getPrenom());
            //pst.setDate(4, obj.getDate_naissance());
            pst.setString(5, obj.getEmail());
            //pst.setString(6, obj.getNum_tel());
            //pst.setBoolean(7, obj.isAdmis_stage());
            //pst.setString(8, obj.getSexe());
            pst.setString(9, obj.getMot_de_passe());
            pst.setBoolean(10, obj.isEst_admin());
            //pst.setString(11, obj.getRole());
            // on exécute la mise à jour
            pst.executeUpdate();
            //Récupérer la clé qui a été générée et la pousser dans l'objet initial
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
    public boolean delete(Utilisateur obj) {
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
    public boolean update(Utilisateur obj) {
        boolean success = true;
        int id = obj.getId();
        try {
            String requete = "UPDATE " + TABLE + " SET "  + " = ?, " + NOM + " = ?, " + PRENOM + " = ? , "  + EMAIL + " = ?, "  + MOT_DE_PASSE + " = ?, " + EST_ADMIN + " = ? WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);
            // pst.setInt(1, obj.getPromo());
            pst.setString(2, obj.getNom());
            pst.setString(3, obj.getPrenom());
            // pst.setDate(4, obj.getDate_naissance());
            pst.setString(5, obj.getEmail());
            // pst.setString(6, obj.getNum_tel());
            // pst.setBoolean(7, obj.isAdmis_stage());
            // pst.setString(8, obj.getSexe());
            pst.setString(9, obj.getMot_de_passe());
            pst.setBoolean(10, obj.isEst_admin());
            // pst.setString(11, obj.getRole());
            pst.setInt(12, id);
            pst.executeUpdate();
            donnees.put(id, obj);
        } catch (SQLException e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public Utilisateur read(int id) {
        Utilisateur utilisateur = null;
        if (donnees.containsKey(id)) {
            utilisateur = donnees.get(id);
        } else {
            System.out.println("Recherche dans la BD");
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + CLE_PRIMAIRE + " = " + id;
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                String nom = rs.getString(NOM);
                String prenom = rs.getString(PRENOM);
                String email = rs.getString(EMAIL);
                String mot_de_passe = rs.getString(MOT_DE_PASSE);
                boolean est_admin = rs.getBoolean(EST_ADMIN);
                Integer annee = rs.getInt(ANNEE);
                int lieu_stage=rs.getInt(LIEU_STAGE);
                utilisateur = new Utilisateur(id, nom, prenom, email, mot_de_passe, est_admin, annee, lieu_stage);
                donnees.put(id, utilisateur);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return utilisateur;
    }


    public ArrayList<Utilisateur> readAll() {

        Utilisateur utilisateur = null;
        ArrayList<Utilisateur> listeUtilisateur =null;
        try {
            String requete = "SELECT * FROM " + TABLE +
                            " JOIN ENTREPRISE E ON UTILISATEUR.lieu_stage= E.id WHERE admin=0";
            ResultSet rs = Connexion.executeQuery(requete);
            listeUtilisateur = new ArrayList<Utilisateur>();
            boolean hasNext = rs.next();
            while (hasNext) {
                utilisateur = getUtilisateur(rs);
                listeUtilisateur.add(utilisateur);
                hasNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeUtilisateur;
    }

    private Utilisateur getUtilisateur(ResultSet rs) throws SQLException {
        Utilisateur utilisateur;
        String nom = rs.getString(NOM);
        String prenom = rs.getString(PRENOM);
        String email = rs.getString(EMAIL);
        Integer lieu_stage = rs.getInt(LIEU_STAGE);
        int annee = rs.getInt(ANNEE);
        utilisateur = new Utilisateur(nom, prenom, email, lieu_stage, annee);
        return utilisateur;
    }

    public static Utilisateur getUtilisateurByMail(String mail){
        Utilisateur utilisateur = null;
            System.out.println("Recherche dans la BD");
            try {
                String requete = "SELECT * FROM " + TABLE + " WHERE " + EMAIL + "='" + mail + "'";
                ResultSet rs = Connexion.executeQuery(requete);
                rs.next();
                System.out.println(rs);

                String nom = rs.getString(NOM);
                String prenom = rs.getString(PRENOM);
                String email = rs.getString(EMAIL);
                String mot_de_passe = rs.getString(MOT_DE_PASSE);
                boolean est_admin = rs.getBoolean(EST_ADMIN);
                Integer annee = rs.getInt(ANNEE);
                int lieu_stage=rs.getInt(LIEU_STAGE);
                Integer id = rs.getInt(CLE_PRIMAIRE);
                utilisateur = new Utilisateur(id, nom, prenom, email, mot_de_passe, est_admin, annee, lieu_stage);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        return utilisateur;
    }


}