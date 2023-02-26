import java.time.LocalDate;
public class Przychody extends Transakcje {
    private String zrodlo;

    public Przychody(int id, int idKonta, LocalDate data, float kwota, String zrodlo) {
        super(id, idKonta, data, kwota);
        this.zrodlo = zrodlo;
    }

    public String getZrodlo() {
        return zrodlo;
    }
}
