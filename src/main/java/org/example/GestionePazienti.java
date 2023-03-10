package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionePazienti {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Paziente> pazientiOspedale = new ArrayList<>();
    ArrayList<Dottore> dottoriOspedale = new ArrayList<>();

    //creo dottori
    public void registraDottori() {
        Dottore dottore1 = new Dottore("Smith", "Ben");
        Dottore dottore2 = new Dottore("Doe", "John");
        dottoriOspedale.add(dottore1);
        dottoriOspedale.add(dottore2);
    }

    //creo pazienti
    public void registraPazienti() {
        Paziente paziente1 = new Paziente("Rossi", "Julia", 'F', LocalDate.of(2023, 1, 10), "AA01");

        //opzionali
        paziente1.citta("Roma")
                .via("Via Roma, 32")
                .telefono("111111")
                .personaContattoNome("Anna")
                .personaContattoTel("222222")
                .primaDiagnosi("covid")
                .dimissioni(LocalDate.of(2023, 1, 25));


        Paziente paziente2 = new Paziente("Verdi", "Federico", 'M', LocalDate.of(2023, 2, 1), "CD23");

        //opzionali
        paziente2.telefono("333333")
                .personaContattoNome("Lina")
                .personaContattoTel("333333")
                .primaDiagnosi("polmonite")
                .dimissioni(LocalDate.of(2023, 2, 14));

        Paziente paziente3 = new Paziente("Bianchi", "Alex", 'M', LocalDate.of(2023, 3, 1), "AB03");

        //opzionali
        paziente1.citta("roma")
                .via("Via Italia, 21")
                .telefono("444444")
                .primaDiagnosi("bronchite");

        pazientiOspedale.add(paziente1);
        pazientiOspedale.add(paziente2);
        pazientiOspedale.add(paziente3);
    }

    public void stampaDottori() {

        for (Dottore dottore : dottoriOspedale) {
            int i = 0;
            System.out.println(++i + dottore.toString());
        }
    }

    public void registraNuovoPaziente() {
        System.out.println("Stai per registrare un nuovo Paziente");
        System.out.println("inserisci il cognome");
        String cognome = scanner.next();
        System.out.println("inserisci il nome");
        String nome = scanner.next();
        System.out.println("inserisci il sesso: M/F");
        char sesso = scanner.next().charAt(0);
        System.out.println("inserisci la data di ricovero: YYYY-MM-DD");
        String[] ymd = scanner.next().split("-");
        System.out.println("inserisci il codice di medico base");
        String codiceMedicoBase = scanner.next();
        LocalDate dataRicovero = LocalDate.of(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]), Integer.parseInt(ymd[2]));
        Paziente paziente = new Paziente(cognome, nome, sesso, dataRicovero, codiceMedicoBase);
        pazientiOspedale.add(paziente);

    }

    public void aggiornaDatiPaziente() {
        stampaPazientiOspedale();
        System.out.println("Stai per aggiornare i dati del paziente");
        System.out.println("inserisci id del paziente");
        int id = Integer.parseInt(scanner.next());
        Paziente pazienteCercato = null;
        boolean trovato = false;
        for (Paziente paziente : pazientiOspedale) {
            if (paziente.getId() == id) {
                pazienteCercato = paziente;
                trovato = true;
                break;
            }
        }

        boolean flag = false;
        do {
            System.out.println("quale dato vuoi inserire/aggiornare?");
            System.out.println("1 -> inserisci la città");
            System.out.println("2 -> inserisci la via");
            System.out.println("3 -> inserisci il telefono");
            System.out.println("4 -> inserisci il nome della persona di contatto");
            System.out.println("5 -> inserisci il telefono della persona di contatto");
            System.out.println("6 -> inserisci il primaDiagnosi");
            System.out.println("0 -> Menu");
            String scelta = scanner.next();

            switch (scelta) {
                case "1":
                    System.out.println("inserisci la città");
                    pazienteCercato.citta(scanner.next());
                    break;
                case "2":
                    System.out.println("inserisci la via");
                    pazienteCercato.via(scanner.next());
                    break;
                case "3":
                    System.out.println("inserisci il telefono");
                    pazienteCercato.telefono(scanner.next());
                    break;
                case "4":
                    System.out.println("inserisci il nome della persona di contatto");
                    pazienteCercato.personaContattoNome(scanner.next());
                    break;
                case "5":
                    System.out.println("inserisci il telefono della persona di contatto");
                    pazienteCercato.personaContattoTel(scanner.next());
                    break;
                case "6":
                    System.out.println("inserisci il prima Diagnosi");
                    pazienteCercato.primaDiagnosi(scanner.next());
                    break;
                case "0":
                flag=true;
                    break;
                default:
                    System.out.println("La scelta errata, prova di nuovo");
            }
        } while (!flag);
        if (trovato == false) {
            System.out.println("Paziente NON trovato");
        }

    }

    //stampa tutti pazienti che sono state registrate nel ospedale
    public void stampaPazientiOspedale() {
        System.out.println("Pazienti che sono stati registrati nel ospedale: ");
        for (Paziente paziente : pazientiOspedale) {
            System.out.println(paziente);
        }
    }

    //assegno paziente da dottore
    public boolean assegnaPaziente() {
        stampaPazientiOspedale();
        boolean pazienteTrovato = false;
        boolean dottoreTrovato = false;
        boolean assegnato = pazienteTrovato && dottoreTrovato;

        System.out.println("inserisci id del paziente per assegnarlo a un dottore: ");
        int idP = Integer.parseInt(scanner.next());
        System.out.println();
        stampaDottori();
        System.out.println("inserisci id del nuovo dottore: 1 o 2 ");
        int idD = Integer.parseInt(scanner.next());
        for (Paziente paziente : pazientiOspedale) {
            if (paziente.getId() == idP) {
                pazienteTrovato = true;
                for (Dottore dottore : dottoriOspedale) {
                    if (dottore.getIdDottore() == idD) {
                        dottoreTrovato = true;
                        dottore.getPazienti().add(paziente);
                    }
                }
            }
        }
        if (pazienteTrovato == false) {
            System.out.println("Paziente con id: " + idP + " NON trovato");
        }
        if (dottoreTrovato == false) {
            System.out.println("Dottore con id: " + idD + " NON trovato");
        }
        return assegnato;
    }

    //cancella paziente dal dottore (paziente viene dimesso)
    public boolean cancellaPaziente(int idPaziente) {

        boolean trovato = false;
        for (Dottore dottore : dottoriOspedale) {
            for (Paziente paziente : dottore.getPazienti()) {
                if (paziente.getId() == idPaziente) {
                    dottore.getPazienti().remove(paziente);
                    paziente.setDimissioni(LocalDate.now());
                    trovato = true;
                    break;
                }
            }
        }
        if (trovato == false) {
            System.out.println("Paziente con id: " + idPaziente + " NON trovato");
        }
        return trovato;
    }


    //assegno paziente ad altro dottore
    public void cambiaDottore() {
        System.out.println("inserisci id del paziente per assegnarlo a un dottore: ");
        int idP = Integer.parseInt(scanner.next());
        boolean cancellato = cancellaPaziente(idP);
        boolean assegnato = assegnaPaziente();
        if (cancellato && assegnato) {
            System.out.println("Paziente è stato assegnato a dottore");
        }

    }

    //stampa listaPazienti del dottore
    public void stampaPazientiPerDottore() {

        System.out.println("inserisci id del dottore: 1 o 2");
        int idDottore = Integer.parseInt(scanner.next());
        for (Dottore dottore : dottoriOspedale) {
            if (dottore.getIdDottore() == idDottore) {
                System.out.println("Il dottore " + dottore.getCognome() + " ha " + dottore.getPazienti().size() + " pazienti");
                System.out.println(dottore.getPazienti().toString().replace("), ", "),\n"));
            }
        }
    }

}//
