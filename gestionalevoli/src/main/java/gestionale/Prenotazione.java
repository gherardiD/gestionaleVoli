package gestionale;

//import java.util.HashMap;

public class Prenotazione implements java.io.Serializable{
  private static int next_code = 0;
  private String codice;
  //private HashMap<Cliente, Volo> prenotazioni;
  private int numero_bagagli;
  private Cliente cliente;
  private Volo volo;
  private int peso_bagaglio;

  
  public Prenotazione(Cliente cliente, Volo volo, int numero_bagagli, int peso_bagaglio) {
    this.cliente = cliente;
    this.volo = volo;
    this.numero_bagagli = numero_bagagli;
    this.peso_bagaglio = peso_bagaglio;
    codice=String.valueOf(next_code);
  }

  // Setters
  public void setNumeroBagagli(int numero_bagagli) {
    this.numero_bagagli = numero_bagagli;
  }

  public void setPesoBagaglio(int peso_bagaglio) {
    this.peso_bagaglio = peso_bagaglio;
  }

  // Getters
  public String getCodice() {
    return codice;
  }

  public int getNumeroBagagli() {
    return numero_bagagli;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Volo getVolo() {
    return volo;
  }

  public int getPesoBagaglio() {
    return peso_bagaglio;
  }
}
