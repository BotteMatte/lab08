# Test-first

Use the *Test-Driven Development (TDD)* methodology to develop the following.

Osserva l'interfaccia DeathNote, comprendendo come dovrebbe funzionare.

Crea un'implementazione di DeathNote in cui ogni metodo lanci un'eccezione.

Scrivi un test per l'implementazione di DeathNote (il test fallirà ed è normale) testando i seguenti punti:
3.1. Il numero di regola 0 e le regole negative non esistono nelle regole di DeathNote.
- Verifica che le eccezioni siano lanciate correttamente, che il loro tipo sia quello previsto e che il messaggio associato non sia nullo, vuoto o composto solo da spazi.

3.2. Nessuna regola è vuota o nulla nelle regole di DeathNote.
- Per tutte le regole valide, verifica che nessuna sia null o composta solo da spazi.

3.3. L'umano il cui nome è scritto nel DeathNote alla fine morirà.
- Verifica che l'umano non sia già stato scritto nel quaderno.
- Scrivi il nome dell'umano nel quaderno.
- Verifica che l'umano sia stato scritto nel quaderno.
- Verifica che un altro umano non sia stato scritto nel quaderno.
- Verifica che la stringa vuota non sia stata scritta nel quaderno.

3.4. Solo se la causa della morte è scritta entro i 40 millisecondi successivi alla scrittura del nome della persona, questa avverrà.
- Verifica che scrivere una causa di morte prima di scrivere un nome lanci l'eccezione corretta.
- Scrivi il nome di un umano nel quaderno.
- Verifica che la causa della morte sia un attacco di cuore.
- Scrivi il nome di un altro umano nel quaderno.
- Imposta la causa della morte come "incidente di karting".
- Verifica che la causa della morte sia stata impostata correttamente (ritorna true e la causa è effettivamente "incidente di karting").
- Metti in pausa l'esecuzione per 100 millisecondi.
- Prova a cambiare la causa della morte.
- Verifica che la causa della morte non sia stata cambiata.

3.5. Solo se i dettagli della morte sono scritti entro i 6 secondi e 40 millisecondi successivi alla scrittura del nome, la morte avverrà.
- Verifica che scrivere i dettagli della morte prima di scrivere un nome lanci l'eccezione corretta.
- Scrivi il nome di un umano nel quaderno.
- Verifica che i dettagli della morte siano attualmente vuoti.
- Imposta i dettagli della morte come "ha corso troppo a lungo".
- Verifica che i dettagli della morte siano stati impostati correttamente (ritorna true e i dettagli sono effettivamente "ha corso troppo a lungo").
- Scrivi il nome di un altro umano nel quaderno.
- Metti in pausa l'esecuzione per 6100 millisecondi.
- Prova a cambiare i dettagli.
- Verifica che i dettagli non siano stati cambiati.

Chiedi una correzione dei test.

Verifica che tutti i test falliscano.

Modifica l'implementazione di DeathNote in modo che tutti i test vengano superati.

1. Observe the `DeathNote` interface, understand how it is supposed to work
2. Create an implementation of `DeathNote` in which each method throws an Exception
3. Write a test for the `DeathNote` implementation (the test will fail and that is okay) testing the following:
   1. Rule number 0 and negative rules do not exist in the DeathNote rules.
      * check that the exceptions are thrown correctly, that their type is the expected one, and that the message is not null, empty, or blank.
   2. No rule is empty or null in the DeathNote rules.
      * for all the valid rules, check that none is null or blank
   3. The human whose name is written in the DeathNote will eventually die.
      * verify that the human has not been written in the notebook yet
      * write the human in the notebook
      * verify that the human has been written in the notebook
      * verify that another human has not been written in the notebook
      * verify that the empty string has not been written in the notebook
   4. Only if the cause of death is written within the next 40 milliseconds of writing the person's name, it will happen.
      * check that writing a cause of death before writing a name throws the correct exception
      * write the name of a human in the notebook
      * verify that the cause of death is a heart attack
      * write the name of another human in the notebook
      * set the cause of death to "karting accident"
      * verify that the cause of death has been set correctly (returned true, and the cause is indeed "karting accident")
      * sleep for 100ms
      * try to change the cause of death 
      * verify that the cause of death has not been changed
   5. Only if the cause of death is written within the next 6 seconds and 40 milliseconds of writing the death's details, it will happen.
      * check that writing the death details before writing a name throws the correct exception
      * write the name of a human in the notebook
      * verify that the details of the death are currently empty
      * set the details of the death to "ran for too long"
      * verify that death details have been set correctly (returned true, and the details are indeed "ran for too long")
      * write the name of another human in the notebook
      * sleep for 6100ms
      * try to change the details
      * verify that the details have not been changed
4. Ask for a correction of the tests
5. Verify that all tests fail
6. Modify the implementation of the `DeathNote` in such a way that all tests work

**Important notes**:
* the current time measured as seconds since the Unix epoch is available as `System.currentTimeMillis()`.
* the execution of a program can be paused for a given number of milliseconds using `Thread.sleep(long millis)`.
