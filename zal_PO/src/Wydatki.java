import java.time.LocalDate;
public class Wydatki extends Transakcje {
    private String kategoria;

    public Wydatki(int id, int idKonta, LocalDate data, float kwota, String kategoria) {
        super(id, idKonta, data, kwota);
        this.kategoria = kategoria;
    }

    public String getKategoria() {
        return kategoria;
    }
}
