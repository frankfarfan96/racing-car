public class Moto extends Veicolo {

  private static final int velocitaMin = 70;
  private static final int velocitaMax = 160;

  public Moto(String nome, String modello) {
     super(nome, modello, "Moto");
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