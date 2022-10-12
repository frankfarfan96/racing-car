public class Auto extends Veicolo {

  private static final int velocitaMin = 80;
  private static final int velocitaMax = 140;

  public Auto(String nome, String modello) {
     super(nome, modello, "Auto");
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