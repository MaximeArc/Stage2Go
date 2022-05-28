package dao;

import javafx.collections.ObservableList;
import models.Adresse;
import models.Commentaire;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentaireDAO extends DAO<Commentaire> {


    private static final String TABLE = "COMMENTAIRE";
    private static final String CLE_PRIMAIRE = "id";
    private static final String CONTENU = "contenu";
    private static final String ID_ENTREPRISE = "id_entreprise";
    private static final String ID_UTILISATEUR = "id_utilisateur";



    @Override
    public boolean create(Commentaire obj) {
        return false;
    }

    @Override
    public boolean delete(Commentaire obj) {
        return false;
    }

    @Override
    public boolean update(Commentaire obj) {
        return false;
    }

    @Override
    public Commentaire read(int id) {
        return null;
    }

    public static ArrayList<Commentaire> getComments(int idEntreprise) {
        Commentaire comment = null;
        ArrayList<Commentaire> listComments =null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE id_entreprise=" + idEntreprise;
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

    private static Commentaire getComment(ResultSet rs) throws SQLException {
        Commentaire comment;
        String contenu = rs.getString("contenu");

        comment = new Commentaire();
        comment.setContenu(contenu);
        return comment;
    }


    public static Commentaire getCommentByUtilisateur(int id) {
        Commentaire comment = null;
        try {
            String requete = "SELECT * FROM " + TABLE + " WHERE " + ID_UTILISATEUR + " = " + id;
            ResultSet rs = Connexion.executeQuery(requete);
            rs.next();
            comment = new Commentaire();
            comment.setContenu(rs.getString("contenu"));
            comment.setIdEntreprise(rs.getInt("id_entreprise"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }
}