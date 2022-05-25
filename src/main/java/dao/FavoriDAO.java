package dao;

import models.Entreprise;
import models.Favori;
import models.Utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FavoriDAO extends DAO<Favori>{


    private static final String TABLE = "FAVORI";
    private static final String CLE_PRIMAIRE = "id";

    private static final String IDSTAGIAIRE = "id_utilisateur";
    private static final String IDENTREPRISE = "id_entreprise";


    private static FavoriDAO instance = null;

    public static FavoriDAO getInstance() {
        if (instance == null) {
            instance = new FavoriDAO();
        }
        return instance;
    }

    public FavoriDAO() {
        super();
    }

    @Override
    public boolean create(Favori obj) {
        return false;
    }

    @Override
    public boolean delete(Favori obj) {
        return false;
    }

    @Override
    public boolean update(Favori obj) {
        return false;
    }

    @Override
    public Favori read(int id) {
        return null;
    }

    public ArrayList<Favori> getFavoriByStagiaireId(int id){
        Favori favori = null;
        ArrayList<Favori> listeFavori =null;
        try {
            String requete = "SELECT * FROM " + TABLE + " JOIN ENTREPRISE ON " + TABLE + ".id_entreprise=ENTREPRISE.id WHERE " + IDSTAGIAIRE + "=" + id;
            ResultSet rs = Connexion.executeQuery(requete);
            listeFavori = new ArrayList<Favori>();
            boolean hasNext = rs.next();
            while (hasNext) {
                favori = getFavori(rs);
                listeFavori.add(favori);
                hasNext = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeFavori;
    }

    private Favori getFavori(ResultSet rs) throws SQLException {
        Favori favori;
        int id_stagiaire = rs.getInt(IDSTAGIAIRE);
        int id_entreprise = rs.getInt(IDENTREPRISE);
        String nom_entreprise = rs.getString("nom");

        favori = new Favori(id_stagiaire,id_entreprise, nom_entreprise);
        return favori;
    }
}
