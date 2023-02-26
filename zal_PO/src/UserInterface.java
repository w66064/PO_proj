import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {
    private ZarzadzanieFinansami zarzadzanieFinansami;
    private DatabaseConnection databaseConnection;
    public UserInterface(ZarzadzanieFinansami zarzadzanieFinansami) {
        this.zarzadzanieFinansami = zarzadzanieFinansami;

    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Dodaj wydatek");
            System.out.println("2. Dodaj przychod");
            System.out.println("3. Usun wydatek");
            System.out.println("4. Usun przychod");
            System.out.println("5. Wyswietl wszystkie transakcje");
            System.out.println("6. Wyswietl wszystkie wydatki");
            System.out.println("0. Zakoncz");

            int wybor = scanner.nextInt();
            scanner.nextLine();

            switch (wybor) {
                case 0:
                    System.out.println("Koniec programu.");
                    return;
                case 1:
                    System.out.print("Podaj id konta: ");
                    int idKonta = scanner.nextInt();
                    System.out.print("Podaj kwote: ");
                    float kwota = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Podaj kategorie: ");
                    String kategoria = scanner.nextLine();

                    try {
                        zarzadzanieFinansami.dodajWydatek(idKonta, kwota, kategoria);
                        System.out.println("Dodano wydatek.");
                    } catch (SQLException e) {
                        System.out.println("Nie udalo sie dodac wydatku.");
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    System.out.print("Podaj id konta: ");
                    idKonta = scanner.nextInt();
                    System.out.print("Podaj kwote: ");
                    kwota = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Podaj zrodlo: ");
                    String zrodlo = scanner.nextLine();

                    try {
                        zarzadzanieFinansami.dodajPrzychod(idKonta, kwota, zrodlo);
                        System.out.println("Dodano przychod.");
                    } catch (SQLException e) {
                        System.out.println("Nie udalo sie dodac przychodu.");
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    System.out.print("Podaj id wydatku do usuniecia: ");
                    int idWydatku = scanner.nextInt();

                    try {
                        zarzadzanieFinansami.usunWydatek(idWydatku);
                        System.out.println("Usunieto wydatek.");
                    } catch (SQLException e) {
                        System.out.println("Nie udalo sie usunac wydatku.");
                        e.printStackTrace();
                    }

                    break;
                case 4:
                    System.out.print("Podaj id przychodu do usuniecia: ");
                    int idPrzychodu = scanner.nextInt();

                    try {
                        zarzadzanieFinansami.usunPrzychod(idPrzychodu);
                        System.out.println("Usunieto przychod.");
                    } catch (SQLException e) {
                        System.out.println("Nie udalo sie usunac przychodu.");
                        e.printStackTrace();
                    }

                    break;
                case 5:
                    try {
                        zarzadzanieFinansami.wyswietlWszystkiePrzychody();
                    } catch (SQLException e) {
                        System.out.println("Nie udało się wyświetlić przychodow.");
                    }
                    break;
                case 6:
                    try {
                        zarzadzanieFinansami.wyswietlWszystkieWydatki();
                    } catch (SQLException e) {
                        System.out.println("Nie udało się wyświetlić wydatkow.");
                    }
                    break;
                default:
                    System.out.println("Nieznana opcja. Spróbuj ponownie.");
                    break;
            }


        }
    }
}

