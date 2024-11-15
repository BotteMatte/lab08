package it.unibo.deathnote;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImplementation;


import static java.lang.Thread.sleep;
import static it.unibo.deathnote.api.DeathNote.RULES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

//import java.text.RuleBasedCollator;


class TestDeathNote {


    private DeathNote deathNote;
    private static final String DANILO_PIANINI = "Danilo Pianini";
    private static final String MATTEO_BOTTEGHI = "Matteo Botteghi";
    private static final int INVALID_CAUSE_TIME = 100;
    private static final int INVALID_DETAILS_TIME = 6000 + INVALID_CAUSE_TIME;

    @BeforeEach
    void init(){
        deathNote = new DeathNoteImplementation();
    }

    @Test
    void testIllegalRule(){
            //test per lo 0
        try {
            deathNote.getRule(0);
            fail("expetd illegal IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());
            assertFalse(e.getMessage().isEmpty());
         }
            //test per regoal negativa
        try {
            deathNote.getRule(-1);
            fail("expetd illegal IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());
            assertFalse(e.getMessage().isEmpty());
        }
    }



    @Test
        void testRules(){
            for(int i = 0 ; i < RULES.size() ; i++){
                final var rule = RULES.get(i);
                assertNotNull(rule);
                assertFalse(rule.isBlank());
            }
        }


    @Test
    void testActualDeath(){
        assertFalse(deathNote.isNameWritten(DANILO_PIANINI));
        deathNote.writeName(DANILO_PIANINI);
        assertTrue(deathNote.isNameWritten(DANILO_PIANINI));
        assertFalse(deathNote.isNameWritten(MATTEO_BOTTEGHI));
        assertFalse(deathNote.isNameWritten(""));
    }
    
    @Test
    void testDeathCause() throws InterruptedException{
        // Verifica che scrivere una causa di morte prima di scrivere un nome lanci l'eccezione corretta
        try {
            deathNote.writeDeathCause("heart attack");
            fail("illelag state exception: la casua di morte è stata aggiutna prima del nome");
        } catch (IllegalStateException e) {
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());
        }

        //scrivi il nome di un umano sul quaderno
        deathNote.writeName(MATTEO_BOTTEGHI);
        assertEquals("heart attack", deathNote.getDeathCause(MATTEO_BOTTEGHI));

        //scrivi il noome di un lator umano
        deathNote.writeName(DANILO_PIANINI);
        assertTrue(deathNote.writeDeathCause("karting accident"));
        //ferma esecuzione per 100 ms
        sleep(INVALID_CAUSE_TIME);
        deathNote.writeDeathCause("heart attack");
        assertEquals("karting accident", deathNote.getDeathCause(DANILO_PIANINI));
    }

    @Test
    void testDeathDeatails() throws InterruptedException{
        try {
            deathNote.writeDetails("death at 14 pm for heart attack near a bus stop");
            fail("illegal state exception: dettagli della morte isneriti prima del nome");
        } catch (IllegalStateException e) {
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());
        }
    
        deathNote.writeName(DANILO_PIANINI);
        assertEquals("", deathNote.getDeathDetails(DANILO_PIANINI));
        
        deathNote.writeDetails("ha corso troppo a lungo");
        assertEquals("ha corso troppo a lungo", deathNote.getDeathDetails(DANILO_PIANINI));

        deathNote.writeName(MATTEO_BOTTEGHI);
        sleep(INVALID_DETAILS_TIME);
        deathNote.writeDetails("ha pippato troppo");
        assertEquals("ha corso troppo a lungo", deathNote.getDeathDetails(MATTEO_BOTTEGHI));

    }



}