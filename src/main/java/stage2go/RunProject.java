package stage2go;

import dao.Connexion;
import dao.EntrepriseDAO;
import dao.UtilisateurDAO;

public class RunProject {


    public static void main(String[] args) {
        /* Utilisateur */

        //Utilisateur test = new Utilisateur(4, 2020, "BOLLORE", "Clément", null, "farinel.sacha@gmail.com",
                //"0688972850", true, "masculin", "root", false, "étudiant");
        System.out.println(UtilisateurDAO.getInstance().read(1));
        //System.out.println(UtilisateurDAO.getInstance().read(1));
        //System.out.println(UtilisateurDAO.getInstance().update(test));
        //System.out.println(UtilisateurDAO.getInstance().delete(test));

        /* Entreprise */

        System.out.println(EntrepriseDAO.getInstance().read(1));

        /* Adresse */

        //Adresse testAdresse = new Adresse(0, 7, "place", "Marianne", "Plescop", 56890, "Morbihan",
               // "France", 1, 1);
        //System.out.println(AdresseDAO.getInstance().create(testAdresse));
        //System.out.println(AdresseDAO.getInstance().update(testAdresse));
        //System.out.println(AdresseDAO.getInstance().read(2));
        //System.out.println(AdresseDAO.getInstance().delete(testAdresse));




        Connexion.fermer();
    }

}
