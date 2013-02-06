package org.kieda.util.error;

/**
 * kind of like an assertion or an @requires statement
 * @author kieda
 */
public class InvalidInputException extends Exception{
    public InvalidInputException(){}
    public InvalidInputException(String mess){super(mess);}
}
