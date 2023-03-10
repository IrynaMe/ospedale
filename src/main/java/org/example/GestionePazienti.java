package org.example;

import org.example.Paziente;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionePazienti {
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

    //stampa tutti pazienti che sono state registrate nel ospedale
    public void stampaPazientiOspedale() {
        System.out.println("Pazienti che sono stati registrati nel ospedale: ");
        for (Paziente paziente : pazientiOspedale) {
            System.out.println(paziente);
        }
    }

    //assegno paziente da dottore
    public boolean assegnaPaziente(int idPaziente, int idDottore) {
    boolean pazienteTrovato=false;
    boolean dottoreTrovato=false;
    boolean assegnato=pazienteTrovato&&dottoreTrovato;
        for (Paziente paziente : pazientiOspedale) {
            if (paziente.getId() == idPaziente) {
                pazienteTrovato=true;
                for (Dottore dottore : dottoriOspedale) {
                    if (dottore.getIdDottore() == idDottore) {
                        dottoreTrovato=true;
                        dottore.getPazienti().add(paziente);
                    }
                }
            }
        }
        if (pazienteTrovato==false){
            System.out.println("Paziente con id: "+idPaziente+" NON trovato");
        }
        if (dottoreTrovato==false){
            System.out.println("Dottore con id: "+idDottore+" NON trovato");
        }
        return assegnato;
    }
    //cancella paziente dal dottore (paziente viene dimesso)
    public boolean cancellaPaziente(int idPaziente) {
        boolean trovato=false;
        for (Dottore dottore : dottoriOspedale) {
            for (Paziente paziente : dottore.getPazienti()) {
                if (paziente.getId() == idPaziente) {
                    dottore.getPazienti().remove(paziente);
                    paziente.setDimissioni(LocalDate.now());
                    trovato=true;
                    break;
                }
            }
        }
        if (trovato==false){
            System.out.println("Paziente con id: "+idPaziente+" NON trovato");
        }
        return trovato;
    }


    //assegno paziente ad altro dottore
    public void cambiaDottore(int idPaziente, int idDottoreNew) {
            boolean cancellato=cancellaPaziente(idPaziente);
            boolean assegnato=assegnaPaziente(idPaziente, idDottoreNew);
            if (cancellato&&assegnato){
                System.out.println("Paziente con id: "+idPaziente+" e stato assegnato a dottore con id: "+idDottoreNew);
            }

    }

    //stampa listaPazienti del dottore
    public void stampaPazientiPerDottore(int idDottore) {

        for (Dottore dottore : dottoriOspedale) {
            if (dottore.getIdDottore() == idDottore) {
                System.out.println("Il dottore "+dottore.getCognome()+" ha "+dottore.getPazienti().size() + " pazienti");
                System.out.println(dottore.getPazienti().toString().replace("), ", "),\n"));
            }
        }
    }

}//
