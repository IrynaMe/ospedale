package org.example;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@ToString(includeFieldNames = true)
public @Data class Dottore {
    private int idDottore;
    private static int count = 0;
    private String cognome, nome;

    //pazienti assegnati al dottore
    private ArrayList<Paziente> pazienti = new ArrayList<>();

    public Dottore(String cognome, String nome) {
        this.idDottore = ++count;
        this.cognome = cognome;
        this.nome = nome;
    }
}
