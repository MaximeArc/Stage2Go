package dao;

import models.Entreprise;
import models.Favori;
import models.Utilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

        boolean success = true;
        try {
            String requete = "INSERT INTO " + TABLE + " (" + IDSTAGIAIRE + "," + IDENTREPRISE +  ")" + "VALUES (?, ?)";

            PreparedStatement pst = Connexion.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, obj.getStagiaire().getId());
            pst.setInt(2, obj.getEntreprise().getId());

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
    public boolean delete(Favori obj) {
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
            String requete = "SELECT * FROM " + TABLE + " WHERE " + IDSTAGIAIRE + "=" + id;
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
        int id = rs.getInt(CLE_PRIMAIRE);
        Utilisateur stagiaire = UtilisateurDAO.getInstance().read(id_stagiaire);
        Entreprise entreprise = EntrepriseDAO.getInstance().read(id_entreprise);

        favori = new Favori(stagiaire,entreprise);
        favori.setId(id);
        return favori;
    }
}
