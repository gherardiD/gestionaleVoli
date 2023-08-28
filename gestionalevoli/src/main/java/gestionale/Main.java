package gestionale;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Compagnia compagnia = new Compagnia();
        //clients methods
        compagnia.registrazione("Mario", "Rossi", "Italia", "Roma", new GregorianCalendar(1990, 1, 1));
        compagnia.registrazione("Daniele", "Gherardi", "Italia", "Bergamo", new GregorianCalendar(2005, 4, 26));
        compagnia.eliminaCliente("0");
        compagnia.setClienteDati("1", "Andrea","Gherardi", "Italia", "Bergamo", new GregorianCalendar(1994, 1, 11));
        System.out.print(compagnia.getCliente("Andrea", "Gherardi"));
        //flights methods
        compagnia.aggiungiVolo("Roma", "Milano", new GregorianCalendar(2021, 1, 1), "10:00", "11:00", 100, 100);
    }
}