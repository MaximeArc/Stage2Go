package stage2go;

public class Adresse {

    private int id;
    private int numero;
    private String adresse;
    private String ville;
    private int code_postal;
    private int id_entreprise;

    public Adresse(int id, int numero, String adresse, String ville, int code_postal)
                    {
        this.id = id;
        this.numero = numero;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }


    public int getCode_postal() {
        return code_postal;
    }
    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }


    public int getId_entreprise() {
        return id_entreprise;
    }
    public void setId_entreprise(int id_entreprise) {
        this.id_entreprise = id_entreprise;
    }


    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", code_postal=" + code_postal + '\'' +
                ", id_entreprise=" + id_entreprise +
                '}';
    }
}

