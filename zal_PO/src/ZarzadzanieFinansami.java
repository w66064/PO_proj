import java.sql.*;
import java.time.LocalDate;
import java.sql.ResultSet;

public class ZarzadzanieFinansami {
    private DatabaseConnection databaseConnection;

    public ZarzadzanieFinansami(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void dodajWydatek(int idKonta, float kwota, String kategoria) throws SQLException {
        LocalDate data = LocalDate.now();
        String query = "INSERT INTO wydatki (id_konta, data, kwota, kategoria) VALUES (" + idKonta + ", '" + data + "', " + kwota + ", '" + kategoria + "')";
        databaseConnection.executeUpdate(query);
        System.out.println("Dodano nowy wydatek!");
    }

    public void usunWydatek(int id) throws SQLException {
        String query = "DELETE FROM wydatki WHERE id=" + id;
        int rowsAffected = databaseConnection.executeUpdate(query);
        if (rowsAffected == 0) {
            System.out.println("Nie znaleziono wydatku o podanym id!");
        } else {
            System.out.println("Usunięto wydatek!");
        }
    }

    public void dodajPrzychod(int idKonta, float kwota, String zrodlo) throws SQLException {
        LocalDate data = LocalDate.now();
        String query = "INSERT INTO przychody (id_konta, data, kwota, zrodlo) VALUES (" + idKonta + ", '" + data + "', " + kwota + ", '" + zrodlo + "')";
        databaseConnection.executeUpdate(query);
        System.out.println("Dodano nowy przychód!");
    }

    public void usunPrzychod(int id) throws SQLException {
        String query = "DELETE FROM przychody WHERE id=" + id;
        int rowsAffected = databaseConnection.executeUpdate(query);
        if (rowsAffected == 0) {
            System.out.println("Nie znaleziono przychodu o podanym id!");
        } else {
            System.out.println("Usunięto przychód!");
        }
    }

    public void wyswietlWszystkiePrzychody() throws SQLException {
        String queryPrzychody = "SELECT * FROM przychody";
        ResultSet resultSetPrzychody = databaseConnection.executeQuery(queryPrzychody);
        System.out.println("Wszystkie przychody:");
        while (resultSetPrzychody.next()) {
            System.out.println(
                    resultSetPrzychody.getInt("id") + " "
                    + resultSetPrzychody.getInt("id_konta") + " "
                    + resultSetPrzychody.getDate("data") + " "
                    + resultSetPrzychody.getFloat("kwota") + " "
                    + resultSetPrzychody.getString("zrodlo"));
        }
    }

    public void wyswietlWszystkieWydatki() throws SQLException {
        String queryWydatki = "SELECT * FROM wydatki";
        ResultSet resultSetWydatki = databaseConnection.executeQuery(queryWydatki);
        System.out.println("Wszystkie wydatki:");
        while (resultSetWydatki.next()) {
            System.out.println(
                    resultSetWydatki.getInt("id") + " "
                            + resultSetWydatki.getInt("id_konta") + " "
                            + resultSetWydatki.getDate("data") + " "
                            + resultSetWydatki.getFloat("kwota") + " "
                            + resultSetWydatki.getString("kategoria"));
        }
    }

//    public void wyswietlWszystkieTransakcje() throws SQLException {
//        String queryWydatki = "SELECT * FROM wydatki";
//        ResultSet resultSetWydatki = databaseConnection.executeQuery(queryWydatki);
//        System.out.println("Wszystkie wydatki:");
//        while (resultSetWydatki.next()) {
//            System.out.println(
//                    resultSetWydatki.getInt("id") + " "
//                    + resultSetWydatki.getInt("id_konta") + " "
//                    + resultSetWydatki.getDate("data") + " "
//                    + resultSetWydatki.getFloat("kwota") + " "
//                    + resultSetWydatki.getString("kategoria"));
//        }
//
//        String queryPrzychody = "SELECT * FROM przychody";
//        ResultSet resultSetPrzychody = databaseConnection.executeQuery(queryPrzychody);
//        System.out.println("Wszystkie przychody:");
//        while (resultSetPrzychody.next()) {
//            System.out.println(resultSetPrzychody.getInt("id") + " " + resultSetPrzychody.getInt("id_konta") + " " +
//                    resultSetPrzychody.getDate("data") + " " + resultSetPrzychody.getFloat("kwota") + " " +
//                    resultSetPrzychody.getString("zrodlo"));
//        }
//    }
}

