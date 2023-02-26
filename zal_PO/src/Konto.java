public class Konto {
    private int id;
    private String nazwa;

    public Konto(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }
}
