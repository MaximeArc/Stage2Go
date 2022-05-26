package dao;

import models.Adresse;
import models.Commentaire;

public class CommentaireDAO extends DAO<Commentaire> {


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


}