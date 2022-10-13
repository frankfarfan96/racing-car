import java.util.Scanner;

public class InterazioneUtente {
  public static Scanner sc = new Scanner(System.in);

  public static Veicolo getVeicoloUtente() {
    int option, indiceVeicolo;
    String utenteName;
    Veicolo utente = null;
    printMenu();

    do {
      System.out.print(" ~~> ");
      option = sc.nextInt();
      switch(option) {
        case 1:
          do {
            printModelliVeicolo(Database.partecipantiAuto);
            indiceVeicolo = sc.nextInt();
            if(indiceVeicolo < 0 || indiceVeicolo >= Database.partecipantiAuto.length) {
              System.out.println(" Seleziona un indice valido per il veicolo");
            }
          } while(indiceVeicolo < 0 || indiceVeicolo >= Database.partecipantiAuto.length);
          
          utente = Database.partecipantiAuto[indiceVeicolo];
          utenteName = getUtenteName();
          utente.setName(utenteName);
          break;

        case 2:
          do {
            printModelliVeicolo(Database.partecipantiMoto);
            indiceVeicolo  = sc.nextInt();
            if(indiceVeicolo < 0 || indiceVeicolo >= Database.partecipantiMoto.length) {
              System.out.println(" Seleziona un indice valido per il veicolo");
            }
          } while(indiceVeicolo < 0 || indiceVeicolo >= Database.partecipantiMoto.length);

          utente = Database.partecipantiMoto[indiceVeicolo];
          utenteName = getUtenteName();
          utente.setName(utenteName);
          break;

        case 3:
          do {
            printModelliVeicolo(Database.partecipantiAereo);
            indiceVeicolo = sc.nextInt();
            if(indiceVeicolo < 0 || indiceVeicolo >= Database.partecipantiAereo.length) {
              System.out.println(" Seleziona un indice valido per il veicolo");
            }
          } while(indiceVeicolo < 0  || indiceVeicolo >= Database.partecipantiMoto.length);

          utente = Database.partecipantiAereo[indiceVeicolo];
          utenteName = getUtenteName();
          utente.setName(utenteName);
          break;

        default:
          printError(" Seleziona un'opzione valida (1-3)!!");
      }

    } while(option < 1 || option > 3);

    
    return utente;
  }

  public static void printModelliVeicolo(Veicolo[] modelli) {
    for(int i = 0; i < modelli.length; i++) {
      System.out.println(i + ")" + modelli[i].getModello());
    }
  }

  public static String getUtenteName() {
    //NEXT INT NON CATTURA IL TASTO INVIO QND SI USA LA SEGVUENTE LINEA, ERRORE DELLA LIBREIRA
    sc.nextLine(); // LO METTO QUI COSì NON SI RIPETE, come dare un Enter (a capo) in sospeso
    System.out.print(" SCRIVI IL TUO NOME:");
    return sc.nextLine();  
  }

  public static void printMenu() {
    String menu = """
      - - - - - - - Real Racing x3 - - - - - - -

      Seleziona un tipo di veicolo per partecipare:

      1) Auto
      2) Moto
      3) Aereo

      - - - - - - - - - - - - - - - - - - - - - - 
    """;
    System.out.print(menu);
  }

  public static void printError(String error) {
    System.out.println(Colors.ANSI_RED + error + Colors.ANSI_RESET);
  }
}