package dao;

import java.sql.*;

public class Connexion {

    private static Connection connect = null;

    public static Connection getInstance() {
        if (connect == null) {
            String connectionUrl =
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;database=BDstage2;"
                            + "user=aurelia;"
                            + "password=sio;"
                            + "encrypt=true;"
                            + "trustServerCertificate=true;";
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                System.out.println("connecté");
                connect = DriverManager.getConnection(connectionUrl);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }

    private Connexion() {
        super();
    }

    public static ResultSet executeQuery(String requete) {
        Statement st = null;
        ResultSet rs = null;
        System.out.println("requete = " + requete);
        try {
            System.out.println("");
            st = getInstance().createStatement();
            rs = st.executeQuery(requete);
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("Echec de la tentative d'exécution de requete : " + requete + " [" + e.getMessage() + "]");
        }
        return rs;
    }

    public static void fermer() {
        try {
            getInstance().close();
            System.out.println("deconnexion ok");
        } catch (SQLException e) {
            connect = null;
            System.out.println("echec de la fermeture");
        }
    }
}