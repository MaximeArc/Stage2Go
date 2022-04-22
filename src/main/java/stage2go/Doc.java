package stage2go;

public class Doc {
    private int id;
    private String type;
    private String chemin;

    public Doc(int id, String type, String chemin) {
        this.id = id;
        this.type = type;
        this.chemin = chemin;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getChemin() { return chemin; }
    public void setChemin(String chemin) { this.chemin = chemin; }

    @Override
    public String toString() {
        return "Doc{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", chemin='" + chemin + '\'' +
                '}';
    }
}
