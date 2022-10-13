import java.util.Random;
import java.util.Arrays;

public class Gara {

  private int partecipantiOnline = 0;
  private int lunghezzaPercorso = 50;
  private Veicolo[] partecipanti;

  public Gara(int numeroPartecipanti) {
      this.partecipanti = new Veicolo[numeroPartecipanti];
  }
//---
  public Gara(int numeroPartecipanti, int lunghezzaPercorso) {
    this(numeroPartecipanti);
    this.lunghezzaPercorso = lunghezzaPercorso;
  }

  public Gara add(Veicolo partecipante) {
      if(partecipantiOnline < this.partecipanti.length) {
        this.partecipanti[partecipantiOnline] = partecipante;
        this.partecipantiOnline++;
      } 
      return this;
  }

  private void generaPartecipantiBot() {
      for(int i = 0; i < this.partecipanti.length - 1; i++) {
        Veicolo newBot;
        do {
          newBot = this.generaPartecipanteBot();
        } while(this.search(newBot));
        this.add(newBot);
      }
  }

  private Veicolo generaPartecipanteBot() {
    Random r = new Random();
    Veicolo bot;
    int tipoParetecipante = r.nextInt(4-1)+1;
    int veicoloIndex;
    if(tipoParetecipante == 1) {
      //Auto
       veicoloIndex = r.nextInt(Database.partecipantiAuto.length - 1); 
       bot = Database.partecipantiAuto[veicoloIndex];
    } else if(tipoParetecipante == 2) {
      //moto
       veicoloIndex = r.nextInt((Database.partecipantiMoto.length - 1));
       bot = Database.partecipantiMoto[veicoloIndex];
    } else {
      //aereo
       veicoloIndex = r.nextInt((Database.partecipantiAereo.length - 1));
       bot = Database.partecipantiAereo[veicoloIndex];
    }

    return bot;
  }

  public boolean search(Veicolo partecipante) {
    boolean found = false;
    for (int i = 0; i < partecipantiOnline && !found; i++) {
      if(partecipanti[i].equals(partecipante)) {
        found = true;
      }
    }
    return found;
  }

  public void startRace() {
    System.out.println(Colors.ANSI_YELLOW + " Gooo !!!" + Colors.ANSI_RESET);
    for (int i = 0; i < partecipantiOnline; i++) {
      this.partecipanti[i].generaVelocita();
    }
  }

  public void finishRace() {
    this.ordinaClassifica();
    System.out.println(" Race finished : \n\n Classifica: ");
    for (int i = 0; i < partecipantiOnline; i++) {
      System.out.println( Colors.ANSI_YELLOW + "- - - - - - - -" + Colors.ANSI_RESET);
      System.out.println( i+1 + " Classificato ");
      System.out.print(this.partecipanti[i]);
      System.out.println("Tempo di arrivo: " + calcolaTempoDiArrivo(this.partecipanti[i]));
    }
    System.out.println( Colors.ANSI_YELLOW + "- - - - - - - - -" + Colors.ANSI_RESET);
  }

  public double calcolaTempoDiArrivo(Veicolo veicolo) {
    double tempo = this.lunghezzaPercorso / veicolo.getSpeed();
    tempo = tempo / 3600;
    return Math.floor(tempo * 100) / 100;
  }

  public void print() {
    for(int i = 0; i < partecipantiOnline; i++) {
      System.out.println(Colors.ANSI_YELLOW + "- - - - - - -" + Colors.ANSI_RESET);
      System.out.println(this.partecipanti[i]);
    }
  }

  public void ordinaClassifica() {
    Arrays.sort(this.partecipanti);
  }
}