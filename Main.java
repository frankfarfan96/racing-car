public class Main {

    public static void main(String[] args) {
      Gara gara = new Gara(10);

      gara.generaPartecipantiBot();
      
      Veicolo user = InterazioneUtente.getVeicoloUtente();

      gara.add(user);

      gara.startRace();

      System.out.println("\n\n\n");

      gara.ordinaClassifica();
      gara.print();
    }
}