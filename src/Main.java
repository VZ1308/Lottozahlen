import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lottozahlen = new int[6];  // Array zum Speichern der Lottozahlen
        int i = 0;  // Zähler für die Eingabe der Lottozahlen

        System.out.println("Willkommen bei der Lotto-Tip Eingabe.");

        while (i < 6) {  // Schleife für die Eingabe von 6 Zahlen
            System.out.println("Bitte geben Sie die " + (i + 1) + ". Zahl ein (zwischen 1 und 45):");

            try {
                int zahl = scanner.nextInt();

                if (zahl < 1 || zahl > 45) {
                    System.out.println("Die Zahl muss zwischen 1 und 45 liegen. Bitte versuchen Sie es erneut.");
                } else if (!isUnique(lottozahlen, zahl, i)) {  // Überprüfung, ob die Zahl einzigartig ist
                    System.out.println("Die Zahl wurde bereits eingegeben. Bitte geben Sie eine andere Zahl ein.");
                } else {
                    lottozahlen[i] = zahl;  // Zahl im Array speichern
                    i++;  // Zähler erhöhen
                }
            } catch (Exception e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine ganze Zahl ein.");
                scanner.next();  // Scanner zurücksetzen, um die ungültige Eingabe zu ignorieren
            }
        }

        // Ausgabe der eingegebenen Lottozahlen
        System.out.println("Ihre eingegebenen Lottozahlen sind:");
        for (int zahl : lottozahlen) {
            System.out.print(zahl + " ");
        }
        System.out.println();

        scanner.close();
    }

    // Methode zur Überprüfung, ob die Zahl einzigartig ist
    public static boolean isUnique(int[] array, int number, int count) {
        for (int i = 0; i < count; i++) {
            if (array[i] == number) {
                return false;  // Wenn die Zahl im Array vorhanden ist, ist sie nicht einzigartig
            }
        }
        return true;  // Wenn die Zahl nicht gefunden wurde, ist sie einzigartig
    }
}
