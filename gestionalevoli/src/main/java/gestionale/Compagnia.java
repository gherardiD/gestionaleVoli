package gestionale;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;

public class Compagnia {
  private HashMap<String, Volo> voli;
  private HashMap<String, Cliente> clienti;
  LinkedList<Prenotazione> prenotazioni;

  public Compagnia() {
    voli = new HashMap<String, Volo>();
    clienti = new HashMap<String, Cliente>();
    prenotazioni = new LinkedList<Prenotazione>();
  }

  //clients methods222
  public String registrazione(String nome, String cognome, String nazione, String citta_nascita, GregorianCalendar data_nascita) {
    Cliente new_cliente = new Cliente(nome, cognome, nazione, citta_nascita, data_nascita);
    String codice = new_cliente.getCodice();
    clienti.put(codice, new_cliente);
    return codice;
  }

  public void eliminaCliente(String codice) {
    clienti.remove(codice);
    System.out.println("Cliente eliminato");
    System.out.println(clienti.size());
  }

  public Cliente setClienteDati(String codice, String nome, String cognome, String nazione, String citta_nascita, GregorianCalendar data_nascita) {
    Cliente cliente = clienti.get(codice);
    cliente.setNome(nome);
    cliente.setCognome(cognome);
    cliente.setNazione(nazione);
    cliente.setCittaNascita(citta_nascita);
    cliente.setDataNascita(data_nascita);
    return cliente;
  }

  public Cliente getCliente(String codice) {
    return clienti.get(codice);
  }

  public Cliente getCliente(String nome, String cognome) {
    for (Cliente cliente : clienti.values()) {
      if (cliente.getNome().equals(nome) && cliente.getCognome().equals(cognome)) {
        return cliente;
      }
    }
    return null;
  }

  //flights methods
  public String aggiungiVolo(String partenza, String destinazione, GregorianCalendar data, String ora_partenza, String ora_arrivo, int posti_disponibili, int costo) {
    Volo new_volo = new Volo(partenza, destinazione, data, ora_partenza, ora_arrivo, posti_disponibili, costo);
    String codice = new_volo.getCodice();
    voli.put(codice, new_volo);
    return codice;
  }

  public void eliminaVolo(String codice) {
    voli.remove(codice);
    System.out.println("Volo eliminato");
    System.out.println(voli.size());
  }

  public Volo setVoloDati(String codice, String partenza, String destinazione, GregorianCalendar data, String ora_partenza, String ora_arrivo, int posti_disponibili, int costo){
    Volo volo = voli.get(codice);
    volo.setPartenza(partenza);
    volo.setDestinazione(destinazione);
    volo.setData(data);
    volo.setOraPartenza(ora_partenza);
    volo.setOraArrivo(ora_arrivo);
    volo.setPostiDisponibili(posti_disponibili);
    volo.setCosto(costo);
    return volo;
  }

  public Volo getVolo(String codice) {
    return voli.get(codice);
  }

  public Volo getVolo(GregorianCalendar data, String partenza, String arrivo, String ora_partenza){
    for (Volo volo : voli.values()) {
      if (volo.getData().equals(data) && volo.getPartenza().equals(partenza) && volo.getDestinazione().equals(arrivo) && volo.getOraPartenza().equals(ora_partenza)) {
        return volo;
      }
    }
    System.out.println("Volo non trovato");
    return null;
  }

  //booking methods
  public String prenota(String codice_cliente, String codice_volo, int numero_bagagli, int peso_bagaglio) {
    Cliente cliente = clienti.get(codice_cliente);
    if (cliente == null) {
      System.out.println("Cliente non trovato");
      return null;
    }
    Volo volo = voli.get(codice_volo);
    Prenotazione prenotazione = new Prenotazione(cliente, volo, numero_bagagli, peso_bagaglio);
    prenotazioni.add(prenotazione);
    return prenotazione.getCodice();
  }

  private Prenotazione getPrenotazione(String codice_volo, String codice_cliente) {
    for (Prenotazione prenotazione : prenotazioni) {
      if (prenotazione.getCliente().getCodice().equals(codice_cliente) && prenotazione.getVolo().getCodice().equals(codice_volo)) {
        return prenotazione;
      }
    }
    return null;
  }

  public void eliminaPrenotazione(String codice_volo, String codice_cliente){
    Prenotazione prenotazione = getPrenotazione(codice_volo, codice_cliente);
    if (prenotazione == null) {
      System.out.println("Prenotazione non trovata");
      return;
    }
    prenotazioni.remove(prenotazione);
  }

  public Prenotazione modificaPrenotazioneDati(String codice_volo, String codice_cliente, int numero_bagagli, int peso_bagaglio){
    Prenotazione prenotazione = getPrenotazione(codice_volo, codice_cliente);
    if (prenotazione == null) {
      System.out.println("Prenotazione non trovata");
      return null;
    }
    prenotazione.setNumeroBagagli(numero_bagagli);
    prenotazione.setPesoBagaglio(peso_bagaglio);
    System.out.println("Prenotazione modificata");
    return prenotazione;
  }

  public LinkedList<Prenotazione> getPrenotazioniCliente(String codice_cliente) {
    LinkedList<Prenotazione> prenotazioni_cliente = new LinkedList<Prenotazione>();
    for (Prenotazione prenotazione : prenotazioni) {
      if (prenotazione.getCliente().getCodice().equals(codice_cliente)) {
        prenotazioni_cliente.add(prenotazione);
      }
    }
    System.out.println("Prenotazioni trovate: " + prenotazioni_cliente.size());
    return prenotazioni_cliente;
  }

  public LinkedList<Prenotazione> getPrenotazioniVolo(String codice_volo) {
    LinkedList<Prenotazione> prenotazioni_volo = new LinkedList<Prenotazione>();
    for (Prenotazione prenotazione : prenotazioni) {
      if (prenotazione.getVolo().getCodice().equals(codice_volo)) {
        prenotazioni_volo.add(prenotazione);
      }
    }
    System.out.println("Prenotazioni trovate: " + prenotazioni_volo.size());
    return prenotazioni_volo;
  }
}
