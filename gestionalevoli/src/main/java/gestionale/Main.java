package gestionale;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Compagnia compagnia = new Compagnia();
        compagnia.load();
        //compagnia.deleteFile();
        /*
        //clients methods
        compagnia.registrazione("Mario", "Rossi", "Italia", "Roma", new GregorianCalendar(1990, 1, 1));
        compagnia.registrazione("Daniele", "Gherardi", "Italia", "Bergamo", new GregorianCalendar(2005, 4, 26));
        compagnia.eliminaCliente("0");
        compagnia.setClienteDati("1", "Andrea","Gherardi", "Italia", "Bergamo", new GregorianCalendar(1994, 1, 11));
        compagnia.registrazione("Daniele", "Gherardi", "Italia", "Bergamo", new GregorianCalendar(2005, 4, 26));
        System.out.print(compagnia.getCliente("Andrea", "Gherardi"));

        //flights methods
        compagnia.aggiungiVolo("Roma", "Milano", new GregorianCalendar(2021, 1, 1), "10:00", "11:00", 100, 100);
        compagnia.eliminaVolo("RM0");
        compagnia.aggiungiVolo("Milano", "Tenerife", new GregorianCalendar(2023, 9, 8), "06:00", "12:00", 200, 50);
        compagnia.setVoloDati("MT1", "Milano", "Tenerife", new GregorianCalendar(2023, 9, 8), "08:00", "14:00", 200, 50);
        compagnia.getVolo(new GregorianCalendar(2023, 9, 8) , "Milano", "Tenerife", "08:00");
        //booking methods

        compagnia.prenota("1", "MT1", 2, 20);
        compagnia.prenota("2", "MT1", 1, 5);
        compagnia.setPrenotazioneDati("1", "MT1", 1, 10);
        compagnia.getPrenotazioniCliente("1");
        compagnia.getPrenotazioniVolo("MT1");
        
        compagnia.save();
        */
        compagnia.print();
    }
}