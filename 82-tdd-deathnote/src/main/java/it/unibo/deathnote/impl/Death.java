package it.unibo.deathnote.impl;

public class Death {
    //creo la classe death nel quale mantego la causa della mrote ed i dettaglui di essa
    
    //campi
    private static final String DEFAULTCAUSE = "heart attack";
    private static final byte VALID_CAUSE_TIMEOUT = 40;
    private static final short VALID_DETAILS_TIMEOUT = 6000 + VALID_CAUSE_TIMEOUT;
    private static final String DEFAULDETAILS = "unknown";
            
    private final String cause;
    private final String details;
    private final long timeOfDeath;
        
    
    //costrutori
    public Death(final String cause, final String details){
            this.cause = cause;
            this.details = details;
            timeOfDeath = System.currentTimeMillis();
    }

    public Death(final String cause){
        this.cause = cause;
        this.details = DEFAULDETAILS;
        this.timeOfDeath = System.currentTimeMillis();
    }
    
    public Death() {
        this.cause = DEFAULTCAUSE;
        this.details = DEFAULDETAILS;
        this.timeOfDeath = System.currentTimeMillis();
    }

    //getter
    public String getCause() {
        return cause;
    }


    public String getDetails() {
        return details;
    }


    public long getTimeOfDeath() {
        return timeOfDeath;
    }

    


}
