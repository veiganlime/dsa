package praktikum3;

import javax.swing.*;

public class HashAppOpen {

    public static void main(String[] args) {
        final int B = 10; // Größe der Hash-Tabelle

        String menue = "Eingabe\n";
        menue += " 1) Element einfuegen\n";
        menue += " 2) Element suchen\n";
        menue += " 3) Zelle loeschen\n";
        menue += " 7) Listen zufaellig fuellen\n";

        String[] hashTable = new String[B]; // Hash-Tabelle initialisieren

        while (true) {
            String menueeingabe = JOptionPane.showInputDialog(menue);
            if (menueeingabe == null) break;

            String dialogEingabe;

            // Option 1: Element einfügen
            if (menueeingabe.equals("1")) {
                dialogEingabe = JOptionPane.showInputDialog("Datenstring?");
                if (dialogEingabe != null) {
                    int h = hashTabelleHash(dialogEingabe, B); // Hash-Funktion verwenden
                    if (einfügen(hashTable, dialogEingabe, h, B)) {
                        JOptionPane.showMessageDialog(null, "Element eingefügt.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Tabelle ist voll. Element konnte nicht eingefügt werden.");
                    }
                }
            }

            // Option 2: Element suchen
            if (menueeingabe.equals("2")) {
                dialogEingabe = JOptionPane.showInputDialog("Welches Element soll gesucht werden?");
                if (dialogEingabe != null) {
                    int h = hashTabelleHash(dialogEingabe, B); // Hash-Funktion verwenden
                    int position = suchen(hashTable, dialogEingabe, h, B);
                    if (position != -1) {
                        JOptionPane.showMessageDialog(null, "Element gefunden an Position: " + position);
                    } else {
                        JOptionPane.showMessageDialog(null, "Element nicht gefunden.");
                    }
                }
            }

            // Option 3: Zelle löschen
            if (menueeingabe.equals("3")) {
                dialogEingabe = JOptionPane.showInputDialog("Welches Element soll gelöscht werden?");
                if (dialogEingabe != null) {
                    int h = hashTabelleHash(dialogEingabe, B); // Hash-Funktion verwenden
                    if (löschen(hashTable, dialogEingabe, h, B)) {
                        JOptionPane.showMessageDialog(null, "Element gelöscht.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Element nicht gefunden.");
                    }
                }
            }

            // Option 7: Zufällige Listen füllen
            if (menueeingabe.equals("7")) {
                dialogEingabe = JOptionPane.showInputDialog("Anzahl?");
                if (dialogEingabe != null) {
                    int zahl = Integer.parseInt(dialogEingabe);
                    for (int i = 0; i < zahl; i++) {
                        String zufall = generiereZufallsString();
                        int h = hashTabelleHash(zufall, B); // Hash-Funktion verwenden
                        einfügen(hashTable, zufall, h, B);
                    }
                    JOptionPane.showMessageDialog(null, "Zufällige Elemente wurden eingefügt.");
                }
            }
        }
    }

    public static int hashTabelleHash(String key, int size) {
        Liste temp = new Liste(); // Temporäre Liste erstellen
        return temp.hashFunktion(key, size);
    }

    // Element einfügen (mit linearem Sondieren)
    public static boolean einfügen(String[] hashTable, String key, int hash, int size) {
        for (int i = 0; i < size; i++) {
            int pos = (hash + i) % size; // Lineares Sondieren
            if (hashTable[pos] == null || hashTable[pos].equals("DELETED")) {
                hashTable[pos] = key;
                return true; // Erfolgreich eingefügt
            }
        }
        return false; // Tabelle ist voll
    }

    // Element suchen
    public static int suchen(String[] hashTable, String key, int hash, int size) {
        for (int i = 0; i < size; i++) {
            int pos = (hash + i) % size; // Lineares Sondieren
            if (hashTable[pos] == null) {
                return -1; // Element nicht gefunden
            }
            if (hashTable[pos].equals(key)) {
                return pos; // Element gefunden
            }
        }
        return -1; // Element nicht gefunden
    }

    // Element löschen
    public static boolean löschen(String[] hashTable, String key, int hash, int size) {
        for (int i = 0; i < size; i++) {
            int pos = (hash + i) % size; // Lineares Sondieren
            if (hashTable[pos] == null) {
                return false; // Element nicht gefunden
            }
            if (hashTable[pos].equals(key)) {
                hashTable[pos] = "DELETED"; // Als gelöscht markieren
                return true; // Erfolgreich gelöscht
            }
        }
        return false; // Element nicht gefunden
    }

    // Zufallsstring generieren
    public static String generiereZufallsString() {
        int laenge = (int) (Math.random() * 8 + 3); // Länge zwischen 3 und 10
        StringBuilder zufall = new StringBuilder();
        for (int i = 0; i < laenge; i++) {
            zufall.append((char) (Math.random() * 26 + 65)); // Zufällige Großbuchstaben
        }
        return zufall.toString();
    }
}