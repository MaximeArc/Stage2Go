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
    private static final String LIEU_STAGE = "lieu_stage";
    private static final String ANNEE = "annee";

    // -------------------------------------------------------------------
    // --------- Patron de conception Singleton (en 3 étapes) ---------- //
    // -------------------------------------------------------------------

    // 1- Instance privée unique à null
    private static UtilisateurDAO instance = null;

    // 2- Méthode statique get pour récupérer cette instance unique
    public static UtilisateurDAO getInstance() {
        if (instance == null) {
            instance = new UtilisateurDAO();
        }
        return instance;
    }

    // 3- Constructeur passé en privé
    private UtilisateurDAO() {
        super();
    }


    @Override
    public boolean create(Utilisateur obj) {
        boolean success = true;
        try {
            String requete = "INSERT INTO " + TABLE + "(" + NOM + "," + PRENOM + "," + EMAIL +
                    ","  + MOT_DE_PASSE + "," + EST_ADMIN +"," + ANNEE + ")" +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, obj.getNom());
            pst.setString(2, obj.getPrenom());
            pst.setString(3, obj.getEmail());
            pst.setString(4, obj.getMot_de_passe());
            pst.setBoolean(5, obj.getEst_admin());
            pst.setInt(6, obj.getAnnee());
            pst.executeUpdate();

            // Récupérer la clé qui a été générée et la pousser dans l'objet initial
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
            String requete = "UPDATE " + TABLE + " SET " + NOM + " = ?, " + PRENOM + " = ? , "  + EMAIL + " = ?, "  + MOT_DE_PASSE + " = ?, " + EST_ADMIN + " = ? WHERE " + CLE_PRIMAIRE + " = ?";
            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete);

            pst.setString(1, obj.getNom());
            pst.setString(2, obj.getPrenom());

            pst.setString(3, obj.getEmail());

            pst.setString(4, obj.getMot_de_passe());
            pst.setBoolean(5, obj.getEst_admin());

            pst.setInt(6, id);
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
                int idLieuStage = rs.getInt(LIEU_STAGE);
                Entreprise ent=EntrepriseDAO.getInstance().read(idLieuStage);
                utilisateur = new Utilisateur(id, nom, prenom, email, mot_de_passe, est_admin, ent, annee);
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
                    "  WHERE admin=0";
            ResultSet rs = Connexion.executeQuery(requete);
            listeUtilisateur = new ArrayList<Utilisateur>();
            System.out.println(rs);
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


    private static Utilisateur getUtilisateur(ResultSet rs) throws SQLException {
        Utilisateur utilisateur;

        int id = rs.getInt(CLE_PRIMAIRE);
        String nom = rs.getString(NOM);
        String prenom = rs.getString(PRENOM);
        String email = rs.getString(EMAIL);
        String mot_de_passe= rs.getString(MOT_DE_PASSE);
        boolean est_admin = rs.getBoolean(EST_ADMIN);
        int idLieuStage = rs.getInt(LIEU_STAGE);
        Entreprise ent=EntrepriseDAO.getInstance().read(idLieuStage);
        int annee = rs.getInt(ANNEE);

        utilisateur = new Utilisateur(id,nom, prenom, email, mot_de_passe, est_admin, ent, annee);

        return utilisateur;
    }

    public static Utilisateur getUtilisateurByMail(String mail){
        Utilisateur utilisateur = null;

        try {
            String request = "SELECT * FROM " + TABLE + " WHERE " + EMAIL + "='" + mail + "'";
            //TODO preparedStmt
            ResultSet rs = Connexion.executeQuery(request);
            rs.next();
            System.out.println(rs);

            int id = rs.getInt(CLE_PRIMAIRE);
            String nom = rs.getString(NOM);
            String prenom = rs.getString(PRENOM);
            String email = rs.getString(EMAIL);
            String mot_de_passe = rs.getString(MOT_DE_PASSE);
            boolean est_admin = rs.getBoolean(EST_ADMIN);
            int idLieuStage = rs.getInt(LIEU_STAGE);
            Entreprise ent=EntrepriseDAO.getInstance().read(idLieuStage);
            int annee = rs.getInt(ANNEE);


            utilisateur = new Utilisateur(id, nom, prenom, email, mot_de_passe, est_admin, ent, annee);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return utilisateur;
    }

    public String getLieuStageByUtilisateurId (int id) {
        String nom_stage = null;
        try {
            String requete = "SELECT ENTREPRISE.nom FROM " + TABLE + " JOIN ENTREPRISE ON ENTREPRISE.id=" + TABLE + ".lieu_stage WHERE UTILISATEUR." + CLE_PRIMAIRE + " = " + id;
            ResultSet rs = Connexion.executeQuery(requete);
            rs.next();
            nom_stage = rs.getString("nom");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nom_stage;
    }



    public String getCommentByUtilisateurId (int id) {
        String comment = null;
        try {
            String requete = "SELECT COMMENTAIRE.contenu FROM " + TABLE + " JOIN COMMENTAIRE ON COMMENTAIRE.id_utilisateur=" + TABLE + ".id WHERE UTILISATEUR." + CLE_PRIMAIRE + " = " + id;
            ResultSet rs = Connexion.executeQuery(requete);
            rs.next();
            comment = rs.getString("contenu");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }


}