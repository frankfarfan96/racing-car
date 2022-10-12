import java.util.Random;  

public abstract class Veicolo implements Comparable {
  //Non metto qui le variabili Statiche perchè:
  //Dovrei darli un valore altrimenti dopo non potrei sovvrascriverci e qnd uso i get.

  protected String modello;
  protected String nome;

  protected double speed; 
  protected String tipo;

  public Veicolo(String nome, String modello, String tipo) {
      this.nome = nome;
      this.modello = modello;
      this.tipo = tipo;
  }

  public void generaVelocita() {
      Random r = new Random();
      // this.speed = Math.floor((Math.random() * (this.getVelocitaMax() - this.getVelocitaMin())) + this.getVelocitaMin()*100) / 100;
      this.speed = r.nextDouble() * (this.getVelocitaMax() - this.getVelocitaMin()) + this.getVelocitaMin();
      this.speed = Math.floor(this.speed * 1000) / 1000;
  }

  @Override
  public String toString() {
      return "NOME: " + (this.nome.contains("BOT") ? (Colors.ANSI_RED + this.nome) : (Colors.ANSI_GREEN + this.nome)) + "\n" +
             Colors.ANSI_RESET +
             "TIPO MEZZO: " + this.tipo + "\n" +
             "MODELLO: " + this.modello + "\n" +
              "VELOCITA: " + this.speed + "km/h \n";
  }

  @Override
  public boolean equals(Object o) {
    Veicolo v = (Veicolo) o;
    boolean equals = (this.nome == v.getName() && this.modello == v.getModello());
    return equals;
  }

  // Ordina per velocità decrescente: I primi nell'array sono i più veloci
  @Override
  public int compareTo(Object o) {
      Veicolo v = null;
      if (o instanceof Veicolo) {
        v = (Veicolo) o;
      }
      return (int)Math.ceil(v.getSpeed() - this.speed);
  }

  public String getName() {
    return this.nome;
  }
  public void setName(String nome) {
    this.nome = nome;
  }
  public String getModello() {
    return this.modello;
  }
  public double getSpeed() {
    return this.speed;
  } 

  //I FIGLI DEVONO IMPLEMENTARE QUESTI 2 METODI (Come implementasse un'interfaccia)
  public abstract int getVelocitaMin();
  public abstract int getVelocitaMax();
}