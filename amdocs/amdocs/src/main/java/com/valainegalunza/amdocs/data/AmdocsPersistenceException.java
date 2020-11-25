package com.valainegalunza.amdocs.data;

/**
 *
 * @author valainegalunza
 */
public class AmdocsPersistenceException extends Exception {
    
    public AmdocsPersistenceException(String message) {
        super(message);
    }
   
    public AmdocsPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
