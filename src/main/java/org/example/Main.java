package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionePazienti gestionePazienti = new GestionePazienti();
        System.out.println("---------- Registro dottori e pazienti ---------");
        gestionePazienti.registraDottori();
        gestionePazienti.registraPazienti();


        //menu
        Scanner scanner=new Scanner(System.in);

        boolean flag=false;
        do{
            System.out.println("Cosa vuoi fare?");
            System.out.println("1 -> stampa pazienti di ospedale");
            System.out.println("2 -> assegna paziente a dottore");
            System.out.println("3 -> stampa pazienti per id del dottore");
            System.out.println("4 -> cambia dottore del paziente");
            System.out.println("5 -> cancella paziente");
            System.out.println("0 -> Esci");
            System.out.println("Inserisci la scelta:");
            String scelta=scanner.next();
            switch (scelta){
                case "1":
                    gestionePazienti.stampaPazientiOspedale();
                    break;
                case "2":
                    System.out.println("inserisci id del paziente: ");
                    int idP=Integer.parseInt(scanner.next());
                    System.out.println("inserisci id del nuovo dottore: 1 o 2 ");
                    int idD=Integer.parseInt(scanner.next());
                    gestionePazienti.assegnaPaziente(idP,idD);
                    break;
                case "3":
                    System.out.println("inserisci id del dottore: 1 o 2");
                    int id=Integer.parseInt(scanner.next());
                    gestionePazienti.stampaPazientiPerDottore(id);
                    break;
                case "4":
                    System.out.println("inserisci id del paziente");
                    int idPaziente=Integer.parseInt(scanner.next());
                    System.out.println("inserisci id del nuovo dottore: 1 o 2 ");
                    int idDottoreNew=Integer.parseInt(scanner.next());
                    gestionePazienti.cambiaDottore(idPaziente,idDottoreNew);
                    break;
                case "5":
                    System.out.println("inserisci id del paziente");
                    int idPaz=Integer.parseInt(scanner.next());
                    gestionePazienti.cancellaPaziente(idPaz);
                    break;
                case "0":
                    System.exit(0);
                    System.out.println("Programma in chiusura");
                    break;
                default:
                    System.out.println("scelta errata, prova di nuovo:");
            }
        }while(!flag);

    }
}//