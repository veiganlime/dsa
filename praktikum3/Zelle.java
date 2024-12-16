package praktikum3;

public class Zelle {
    String inhalt; // Inhalt der Zelle (String)
    Zelle next;    // Referenz auf die nächste Zelle

    // Konstruktoren
    Zelle(String el) {
        inhalt = el;
        next = null;
    }

    Zelle(String el, Zelle z) {
        inhalt = el;
        next = z;
    }
}
