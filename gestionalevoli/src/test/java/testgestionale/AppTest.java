package testgestionale;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.GregorianCalendar;


import gestionale.*;

public class AppTest {
  
  @Test
  public void testgestionale() {
    assertTrue(true);
  }

  @Test
  public void testCliente() {
    Cliente cliente = new Cliente("Mario", "Rossi", "Italia", "Roma", new GregorianCalendar(1990, 1, 1));
    assertEquals("Mario", cliente.getNome());
    assertEquals("Rossi", cliente.getCognome());
    assertEquals("Italia", cliente.getNazione());
    assertEquals("Roma", cliente.getCittaNascita());
    assertEquals(new GregorianCalendar(1990, 1, 1), cliente.getDataNascita());
    assertEquals("Rossi Mario, Italia, Roma, 1/1/1990", cliente.toString());
  }

  @Test
  public void testVolo() {
    Volo volo = new Volo("Roma", "Milano", new GregorianCalendar(2021, 1, 1), "10:00", "11:00", 100, 100);
    assertEquals("Roma", volo.getPartenza());
    assertEquals("Milano", volo.getDestinazione());
    assertEquals(new GregorianCalendar(2021, 1, 1), volo.getData());
    assertEquals("10:00", volo.getOraPartenza());
    assertEquals("11:00", volo.getOraArrivo());
    assertEquals(100, volo.getPostiDisponibili());
    assertEquals(100, volo.getCosto());
  }

  @Test
  public void testPrenotazione() {
    Cliente cliente = new Cliente("Mario", "Rossi", "Italia", "Roma", new GregorianCalendar(1990, 1, 1));
    Volo volo = new Volo("Roma", "Milano", new GregorianCalendar(2021, 1, 1), "10:00", "11:00", 100, 100);
    Prenotazione prenotazione = new Prenotazione(cliente, volo, 2, 20);
    assertEquals(cliente, prenotazione.getCliente());
    assertEquals(volo, prenotazione.getVolo());
    assertEquals(2, prenotazione.getNumeroBagagli());
    assertEquals(20, prenotazione.getPesoBagaglio());
  }

  @Test
  public void testCompagnia() {
    //clients
    Compagnia compagnia = new Compagnia();
    String cod_client = compagnia.registrazione("Mario", "Rossi", "Italia", "Roma", new GregorianCalendar(1990, 1, 1));
    assertEquals(1, compagnia.getNumeroClienti());
    assertEquals("Rossi Mario, Italia, Roma, 1/1/1990", compagnia.getCliente(cod_client).toString());
    assertEquals(cod_client, compagnia.getCliente(cod_client).getCodice());
    assertEquals(cod_client, compagnia.getCliente("Mario", "Rossi").getCodice());
    

    //flights
    String cod_flight = compagnia.aggiungiVolo("Roma", "Milano", new GregorianCalendar(2021, 1, 1), "10:00", "11:00", 100, 100);
    assertEquals(1, compagnia.getNumeroVoli());
    compagnia.setVoloDati(cod_flight, "Roma", "Milano", new GregorianCalendar(2021, 1, 1), "12:00", "13:00", 100, 100);
    assertEquals("12:00", compagnia.getVolo(cod_flight).getOraPartenza());
    assertEquals(cod_flight, compagnia.getVolo(new GregorianCalendar(2021, 1, 1), "Roma", "Milano", "12:00").getCodice());
    

    //booking
    String cod_booking = compagnia.prenota(cod_client, cod_flight, 2, 20);
    assertEquals(1, compagnia.getNumeroPrenotazioni());
    assertEquals(3, compagnia.setPrenotazioneDati(cod_client, cod_flight, 3, 30).getNumeroBagagli());

    //check
    assertEquals(1, compagnia.getPrenotazioniCliente(cod_client).size());
    String cod_client_2 = compagnia.registrazione("Daniele", "Gherardi", "Italia", "Roma", new GregorianCalendar(1990, 1, 1));
    compagnia.prenota(cod_client_2, cod_flight, 2, 20);
    assertEquals(2, compagnia.getPrenotazioniVolo(cod_flight).size());


    //delete-all
    compagnia.eliminaCliente(cod_client);
    assertEquals(1, compagnia.getNumeroClienti());

    compagnia.eliminaVolo(cod_flight);
    assertEquals(0, compagnia.getNumeroVoli());

    compagnia.eliminaPrenotazione(cod_booking);
    assertEquals(1, compagnia.getNumeroPrenotazioni());
  }


}
