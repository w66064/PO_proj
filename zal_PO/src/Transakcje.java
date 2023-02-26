import java.time.LocalDate;
public class Transakcje {
    private int id;
    private int idKonta;
    private LocalDate data;
    private float kwota;

    public Transakcje(int id, int idKonta, LocalDate data, float kwota) {
        this.id = id;
        this.idKonta = idKonta;
        this.data = data;
        this.kwota = kwota;
    }

    public int getId() {
        return id;
    }

    public int getIdKonta() {
        return idKonta;
    }

    public LocalDate getData() {
        return data;
    }

    public float getKwota() {
        return kwota;
    }
}
