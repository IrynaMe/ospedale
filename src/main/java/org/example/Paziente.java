package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
public @Data class Paziente {
    // dati obbligatori
    private int id = 0;
    private static int count = 0;

    private String cognome, nome, medicoBaseCode;
    private char sesso;
    private LocalDate dataRicovero;


    //Dati facoltativi
    private String citta, via, telefono, personaContattoNome, personaContattoTel, primaDiagnosi;
    private LocalDate dimissioni;

    public Paziente(String cognome, String nome, char sesso, LocalDate dataRicovero, String medicoBaseCode) {
        this.id = ++count;
        this.cognome = cognome;
        this.nome = nome;
        this.sesso = sesso;
        this.dataRicovero = dataRicovero;
        this.medicoBaseCode = medicoBaseCode;
    }

    public Paziente citta(String citta) {
        this.citta = citta;
        return this;//con return this ritorniamo l'oggetto corrente
    }

    public Paziente via(String via) {
        this.via = via;
        return this;//con return this ritorniamo l'oggetto corrente
    }

    public Paziente telefono(String telefono) {
        this.telefono = telefono;
        return this;//con return this ritorniamo l'oggetto corrente
    }

    public Paziente personaContattoNome(String personaContattoNome) {
        this.personaContattoNome = personaContattoNome;
        return this;//con return this ritorniamo l'oggetto corrente
    }

    public Paziente personaContattoTel(String personaContattoTel) {
        this.personaContattoTel = personaContattoTel;
        return this;//con return this ritorniamo l'oggetto corrente
    }

    public Paziente primaDiagnosi(String primaDiagnosi) {
        this.primaDiagnosi = primaDiagnosi;
        return this;//con return this ritorniamo l'oggetto corrente
    }

    //dimissioni
    public Paziente dimissioni(LocalDate dimissioni) {
        this.dimissioni = dimissioni;
        return this;//con return this ritorniamo l'oggetto corrente
    }


}//
