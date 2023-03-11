package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionePazienti gestionePazienti = new GestionePazienti();
        System.out.println("-- Registro by default 2 dottori e 3 pazienti con diversi dati facoltativi --");
        gestionePazienti.registraDottori();
        gestionePazienti.registraPazienti();


        //menu
        Scanner scanner = new Scanner(System.in);

        boolean flag = false;
        do {
            System.out.println("Cosa vuoi fare?");
            System.out.println("1 -> registra nuovo paziente");
            System.out.println("2 -> aggiorna dati del paziente");
            System.out.println("3 -> stampa pazienti di ospedale");
            System.out.println("4 -> assegna paziente a dottore");
            System.out.println("5 -> stampa pazienti per id del dottore");
            System.out.println("6 -> cambia dottore del paziente");
            System.out.println("7 -> cancella paziente");
            System.out.println("0 -> Esci");
            System.out.println("Inserisci la scelta:");
            String scelta = scanner.next();
            switch (scelta) {
                case "1":
                    gestionePazienti.registraNuovoPaziente();
                    break;
                case "2":
                    gestionePazienti.aggiornaDatiPaziente();
                    break;
                case "3":
                    gestionePazienti.stampaPazientiOspedale();
                    break;
                case "4":
                    gestionePazienti.assegnaPaziente();
                    break;
                case "5":
                    gestionePazienti.stampaPazientiPerDottore();
                    break;
                case "6":
                    gestionePazienti.cambiaDottore();
                    break;
                case "7":
                    System.out.println("inserisci id del paziente");
                    int idPaziente = Integer.parseInt(scanner.next());
                    gestionePazienti.cancellaPaziente(idPaziente);
                    break;
                case "0":
                    System.exit(0);
                    System.out.println("Programma in chiusura");
                    break;
                default:
                    System.out.println("scelta errata, prova di nuovo:");
            }
        } while (!flag);

    }
}//