package praktikum3;

import javax.swing.*;


public class HashApp {
    public static void main(String args[]) {
        final int B = 5;

        String menue = "Eingabe\n";
            menue += " 1) Element einfuegen\n"; 
            menue += " 2) Element suchen\n";
            menue += " 3) Zelle loeschen\n";
            menue += " 4) Laenge der Liste von Bucket k\n"; 
            menue += " 5) Liste von Bucket k ansehen\n";
            menue += " 6) Laenge der Listen von allen Buckets\n";
            menue += " 7) Listen zufaellig fuellen\n";

        String ausgabe = "";
        Liste hashTabelle[];
        hashTabelle = new Liste[B];

        for (int i = 0; i < B; i++) {
            hashTabelle[i] = new Liste();
        }

        while (true) {
            String menueeingabe = JOptionPane.showInputDialog(menue);
            if (menueeingabe == null) break;

            String dialogEingabe;

            // Option 1: Element einfügen
            if (menueeingabe.equals("1")) {
                dialogEingabe = JOptionPane.showInputDialog("Datenstring?");
                int h = hashTabelle[0].hashFunktion(dialogEingabe, B); // Welcher Bucket?

                boolean existsInHashtable = false;
                for (int j = 1; j <= hashTabelle[h].laenge(); j++) {
                    if (hashTabelle[h].inhalt(j).equals(dialogEingabe)) {
                        ausgabe = "Element in Bucket " + h + " gefunden, daher nicht eingefuegt";
                        existsInHashtable = true;
                        break;
                    }
                }

                if (!existsInHashtable) {
                    hashTabelle[h].einsetzenAnfang(dialogEingabe);
                    ausgabe = "Eingabe eingefuegt in bucket " + h;
                }

                JOptionPane.showMessageDialog(null, ausgabe);
            }

            // Option 2: Element suchen
            if (menueeingabe.equals("2")) {
                dialogEingabe = JOptionPane.showInputDialog("Welches Element soll gesucht werden?");
                ausgabe = elementSuchen(dialogEingabe, hashTabelle, B);
                JOptionPane.showMessageDialog(null, ausgabe);
            }

            // Option 3: Zelle löschen
            if (menueeingabe.equals("3")) {
                dialogEingabe = JOptionPane.showInputDialog("Welches Element soll geloescht werden?");
                ausgabe = elementLoeschen(dialogEingabe, hashTabelle, B);
                JOptionPane.showMessageDialog(null, ausgabe);
            }

            // Option 4: Länge der Liste von Bucket k anzeigen
            if (menueeingabe.equals("4")) {
                dialogEingabe = JOptionPane.showInputDialog("Von welchem Bucket soll die Laenge angezeigt werden?");
                ausgabe = "";

                int k = Integer.parseInt(dialogEingabe);
                int l = hashTabelle[k].laenge();
                ausgabe = "Liste hat Laenge " + l;

                JOptionPane.showMessageDialog(null, ausgabe);
            }

            // Option 5: Bucket k ansehen
            if (menueeingabe.equals("5")) {
                dialogEingabe = JOptionPane.showInputDialog("Welcher Bucket soll ausgegeben werden?");
                int bucketIndex = Integer.parseInt(dialogEingabe);
                ausgabe = listeAusgeben(bucketIndex, hashTabelle);
                JOptionPane.showMessageDialog(null, ausgabe);
            }

            // Option 6: Länge aller Körbe anzeigen
            if (menueeingabe.equals("6")) {
                ausgabe = listenLaengen(hashTabelle);
                JOptionPane.showMessageDialog(null, ausgabe);
            }

            // Option 7: Listen zufällig füllen
            if (menueeingabe.equals("7")) {
                dialogEingabe = JOptionPane.showInputDialog("Anzahl?");
                ausgabe = "";

                int zahl = Integer.parseInt(dialogEingabe);
                for (int j = 1; j <= zahl; j++) {
                    String s = "";
                    int laenge = (int) ((Math.random() * 8) + 3);
                    for (int k = 1; k <= laenge; k++) {
                        char zufall = (char) ((Math.random() * 26) + 65);
                        s += zufall;
                    }
                    int h = hashTabelle[0].hashFunktion(s, B); // Welcher Bucket?
                    hashTabelle[h].einsetzenAnfang(s);
                }
                ausgabe = "Zufaellige Listen wurden erfolgreich gefuellt.";
                JOptionPane.showMessageDialog(null, ausgabe);
            }
        }
    }

    public static String elementSuchen(String element, Liste[] hashTabelle, int B) {
        int h = hashTabelle[0].hashFunktion(element, B); // Bucket berechnen
        for (int i = 1; i <= hashTabelle[h].laenge(); i++) {
            if (hashTabelle[h].inhalt(i).equals(element)) {
                return "Element gefunden im Bucket: " + h;
            }
        }
        return "Element nicht gefunden.";
    }

    public static String elementLoeschen(String element, Liste[] hashTabelle, int B) {
        int h = hashTabelle[0].hashFunktion(element, B); // Bucket berechnen
        for (int i = 1; i <= hashTabelle[h].laenge(); i++) {
            if (hashTabelle[h].inhalt(i).equals(element)) {
                hashTabelle[h].loescheElem(element); // Element löschen
                return "Element gelöscht aus Bucket: " + h;
            }
        }
        return "Element nicht gefunden.";
    }

    public static String listeAusgeben(int bucketIndex, Liste[] hashTabelle) {
        if (bucketIndex < 0 || bucketIndex >= hashTabelle.length) {
            return "Ungültiger Bucket-Index.";
        }
        StringBuilder ausgabe = new StringBuilder("Inhalt von Bucket " + bucketIndex + ": ");
        for (int i = 1; i <= hashTabelle[bucketIndex].laenge(); i++) {
            ausgabe.append(hashTabelle[bucketIndex].inhalt(i)).append(", ");
        }
        return ausgabe.toString();
    }

    public static String listenLaengen(Liste[] hashTabelle) {
        StringBuilder ausgabe = new StringBuilder("Längen aller Buckets:\n");
        for (int i = 0; i < hashTabelle.length; i++) {
            ausgabe.append("Bucket ").append(i).append(": ").append(hashTabelle[i].laenge()).append("\n");
        }
        return ausgabe.toString();
    }
}


