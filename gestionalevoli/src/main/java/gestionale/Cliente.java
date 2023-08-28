package gestionale;

import java.util.GregorianCalendar;

public class Cliente {
  private static int next_code = 0;
  private String nome;
  private String cognome;
  private String nazione;
  private String citta_nascita;
  private GregorianCalendar data_nascita;
  private String codice;
  
  public Cliente(String nome, String cognome, String nazione, String citta_nascita, GregorianCalendar data_nascita) {
    this.nome = nome;
    this.cognome = cognome;
    this.nazione = nazione;
    this.citta_nascita = citta_nascita;
    this.data_nascita = data_nascita;
    this.codice = String.valueOf(next_code);
    next_code++;
  }

  // Setters
  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public void setNazione(String nazione) {
    this.nazione = nazione;
  }

  public void setCittaNascita(String citta_nascita) {
    this.citta_nascita = citta_nascita;
  }

  public void setDataNascita(GregorianCalendar data_nascita) {
    this.data_nascita = data_nascita;
  }

  // Getters
  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public String getNazione() {
    return nazione;
  }

  public String getCittaNascita() {
    return citta_nascita;
  }

  public GregorianCalendar getDataNascita() {
    return data_nascita;
  }

  public String getCodice() {
    return codice;
  }
}
