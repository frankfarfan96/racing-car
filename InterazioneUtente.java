public class InterazioneUtente {
  public static Scanner sc = new Scanner(System.in);

  public static Veicolo getVeicoloUtente() {
    int option, indiceVicolo;
    Veicolo utente = null;
    printMenu();


    do {


    Sytem.out.print(" ~~> ");
    option = sc.nextInt();
    switch(option) {
      case 1:
        do {
        printModelliVeicolo(Database.partecipantiAuto);
        indiceVicolo = sc.nextInt();
        if(indiceVicolo < 0 || indiceVicolo >= Database.partecipantiAuto.length) {
          System.out.println("Error")
        }
        } while(indiceVicolo < 0 || indiceVicolo >= Database.partecipantiAuto.length)
         utente = Database.partecipantiAuto[option];
        utenteName = getUtenteName();
        utente.setName(utenteName);
        break;

      case 2:
        printModelliVeicolo(Database.partecipantiMoto);
        if(option >= 0 && option < Database.partecipantiMoto.length) {
        utente = Database.partecipantiMoto[option];
        utenteName = getUtenteName();
        utente.setName(utenteName);
        }
        break;

      case 3:
        printModelliVeicolo(Database.partecipantiAereo);
        if(option >= 0 && option < Database.partecipantiAereo.length) {
        utente = Database.partecipantiAereo[option];
        utenteName = getUtenteName();
        utente.setName(utenteName);
        }
        break;

      default:
        System.out.println(" Seleziona un'opzione valida (1-3)!!")
    }

    } while(option < 1 && option > 3)

    
    return utente;
  }

  public static void printModelliVeicolo(Veicolo[] modelli) {
    for(int i = 0; i < modelli.length; i++) {
      System.out.print(i + ")" + veicolo.getModello());
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
    System.out.println(Colors.)
  }
}