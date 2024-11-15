package it.unibo.deathnote.impl;

import it.unibo.deathnote.api.DeathNote;

import java.util.*;

public class DeathNoteImplementation implements DeathNote {

    private static final long VALID_CAUSE_TIMEOUT = 40;
    // creo i campi di death note
    private final Map<String, Death> deaths;
    private String lastWrittenName;
    private long lastTime_forLastName;

    // creo un nuovo death note
    // costturuttore
    public DeathNoteImplementation() {
        deaths = new LinkedHashMap<String, Death>();
    }

    @Override
    public String getRule(int ruleNumber) {
        if (ruleNumber <= 0 || ruleNumber > RULES.size()) {
            throw new IllegalArgumentException(
                    "Error:illegal argumetn exception: hai inserito una regola minore o uguale a 0 o una regola inesistente");
        } else {
            return RULES.get(ruleNumber);
        }
    }

    // inserisce un nome nella lista
    @Override
    public void writeName(String name) {
        lastTime_forLastName = System.currentTimeMillis();
        lastWrittenName = name;
        deaths.put(name, new Death());
    }

    @Override
    public boolean writeDeathCause(String cause) {
        if (lastWrittenName == null) {
            throw new IllegalStateException(
                    "Error: nessun nome scritto precedentemete al quale assegnare la causa della morte");
        }

        // recupero il record
        Death record = deaths.get(lastWrittenName);
        // Se non esiste un record, significa che non è stato scritto un nome
        if (record == null) {
            return false;
        }

        // Controllo se la causa di morte è stata scritta entro 40 millisecondi
        // dall'inserimento del nome
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastTime_forLastName; // Calcola il tempo trascorso
        if (timeElapsed <= 40) {
            // Se la causa di morte viene scritta entro 40 millisecondi, aggiorna la causa
            Death updatedRecord = new Death(cause);
            deaths.put(lastWrittenName, updatedRecord); // Aggiorna il record con la nuova causa
            return true;
        } else {
            // Se è passato più di 40 millisecondi, non cambia la causa di morte
            return false; // La causa rimane quella di default
        }
    }

    @Override
    public boolean writeDetails(String details) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeDetails'");
    }

    @Override
    public String getDeathCause(String name) {
        Death death_data = deaths.get(name);
        if (death_data != null) {
            return death_data.getCause();
        } else {
            throw new IllegalArgumentException("errore: erroe negli argometni passati per la causa di morte");
        }
    }

    @Override
    public String getDeathDetails(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeathDetails'");
    }

    @Override
    public boolean isNameWritten(String name) {
        return deaths.containsKey(name);
    }

}