package gestionale;

import java.util.GregorianCalendar;

public class Volo implements java.io.Serializable{
  private static int next_code = 0;
  private String codice;
  private String partenza;
  private String destinazione;
  private GregorianCalendar data;
  private String ora_partenza;
  private String ora_arrivo;
  private int posti_disponibili;
  private int costo;

  public Volo(String partenza, String destinazione, GregorianCalendar data, String ora_partenza, String ora_arrivo, int posti_disponibili, int costo) {
    this.partenza = partenza;
    this.destinazione = destinazione;
    this.data = data;
    this.ora_partenza = ora_partenza;
    this.ora_arrivo = ora_arrivo;
    this.posti_disponibili = posti_disponibili;
    this.costo = costo;
    setCodice();
  }

  // Setters
  private void setCodice() {
    this.codice = String.valueOf(partenza.charAt(0))  + String.valueOf(destinazione.charAt(0)) + String.valueOf(next_code);
    next_code++;
  }

  public void setPartenza(String partenza) {
    this.partenza = partenza;
  }

  public void setDestinazione(String destinazione) {
    this.destinazione = destinazione;
  }

  public void setData(GregorianCalendar data) {
    this.data = data;
  }

  public void setOraPartenza(String ora_partenza) {
    this.ora_partenza = ora_partenza;
  }

  public void setOraArrivo(String ora_arrivo) {
    this.ora_arrivo = ora_arrivo;
  }

  public void setPostiDisponibili(int posti_disponibili) {
    this.posti_disponibili = posti_disponibili;
  }

  public void setCosto(int costo) {
    this.costo = costo;
  }

  // Getters
  public String getCodice() {
    return codice;
  }

  public String getPartenza() {
    return partenza;
  }

  public String getDestinazione() {
    return destinazione;
  }

  public GregorianCalendar getData() {
    return data;
  }

  public String getOraPartenza() {
    return ora_partenza;
  }

  public String getOraArrivo() {
    return ora_arrivo;
  }

  public int getPostiDisponibili() {
    return posti_disponibili;
  }

  public int getCosto() {
    return costo;
  }

  public void durataVolo() {
    int ora_partenza = Integer.parseInt(this.ora_partenza.substring(0, 2));
    int minuti_partenza = Integer.parseInt(this.ora_partenza.substring(3, 5));
    int ora_arrivo = Integer.parseInt(this.ora_arrivo.substring(0, 2));
    int minuti_arrivo = Integer.parseInt(this.ora_arrivo.substring(3, 5));
    int durata_ore = ora_arrivo - ora_partenza;
    if (durata_ore < 0) {
      durata_ore += 24;
    }
    int durata_minuti = minuti_arrivo - minuti_partenza;
    if (durata_minuti < 0) {
      durata_ore--;
      durata_minuti += 60;
    }
    System.out.println("Durata volo: " + durata_ore + ":" + durata_minuti);
  }

}
