package praktikum3;

public class Liste {
    Zelle anfang;
    Zelle cursor;

    int laenge() {
        Zelle cur = anfang;
        int l = 0;

        while (cur != null) {
            l++;
            cur = cur.next;
        }

        return l;
    }

    // int hashFunktion(String x, int b) {
    //     return b - 1; // Hash-Funktion-Implementierung
    // }
    /*
       	x ist der Eingabestring (wird nicht genutzt).
	    b ist die Anzahl der Buckets.
	    Die Rückgabe b-1 bedeutet, dass alle Strings immer im letzten Bucket landen (Index 4 bei B = 5).
        Alle Strings werden immer auf denselben Bucket 4 abgebildet, weil die Hashfunktion aktuell nur b-1 zurückgibt.
     */

    int hashFunktion(String x, int b) {
        return Math.abs(x.hashCode()) % b;
    }
    /*
        Strings werden auf verschiedene Buckets verteilt, statt nur auf einen einzigen (bisher b-1).
	    Kollisionsreduktion: Die Hashwerte der Strings werden durch Modulo auf die Anzahl der Buckets abgebildet, 
        was Kollisionen minimiert.

     */









    // int hashFunktion(String x, int i, int b) {
    //     int h1 = hash1(x, b); // Primäre Hashfunktion
    //     int h2 = hash2(x, b); // Sekundäre Hashfunktion
    //     return (h1 + i * h2) % b; // Double Hashing: neue Position
    // }
    
    // // Primäre Hashfunktion
    // int hash1(String x, int b) {
    //     int sum = 0;
    //     byte[] bytes = x.getBytes(); // Konvertiere String in Byte-Array
    //     for (byte value : bytes) {
    //         sum += value; // Summiere die Byte-Werte
    //     }
    //     return sum % b; // Modulo für die primäre Hashposition
    // }
    
    // // Sekundäre Hashfunktion
    // int hash2(String x, int b) {
    //     int sum = 0;
    //     byte[] bytes = x.getBytes(); // Konvertiere String in Byte-Array
    //     for (byte value : bytes) {
    //         sum += value; // Summiere die Byte-Werte
    //     }
    //     return (sum % (b - 1)) + 1; // Sicherstellen, dass h2 niemals 0 ist
    // }

    boolean istGueltigePosition(int p) {
        return (p >= 1) && (p <= laenge());
    }

    void setzeCursor(int p) {
        cursor = null;

        if (istGueltigePosition(p)) {
            Zelle cur = anfang;
            for (int i = 1; i < p; i++) {
                cur = cur.next;
            }
            cursor = cur;
        }
    }

    void einsetzenAnfang(String e) {
        Zelle z = new Zelle(e, anfang);
        anfang = z;
    }

    void loesche(int p) {
        if (istGueltigePosition(p)) {
            if (p == 1) { // Lösche erste Zelle
                anfang = anfang.next;
            } else {
                setzeCursor(p - 1);
                cursor.next = cursor.next.next;
            }
        }
    }

    void loescheElem(String e) {
        for (int i = 1; i <= laenge(); i++) {
            if (inhalt(i).equals(e)) {
                loesche(i);
            }
        }
    }

    String inhalt(int p) {
        setzeCursor(p);
        return cursor.inhalt;
    }
}
