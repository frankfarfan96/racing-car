public class Aereo extends Veicolo {

  private static final int velocitaMin = 100;
  private static final int velocitaMax = 180;

  public Aereo(String nome, String modello) {
     super(nome, modello, "Aereo");
  }

  @Override
  public int getVelocitaMin() {
    return velocitaMin;
  }

  @Override
  public int getVelocitaMax() {
    return velocitaMax;
  }
}