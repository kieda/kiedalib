/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kieda.util.k_error;

import org.kieda.util.k_error.K_Error;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author kieda
 */
public class Err {
    public static final ExitMessageError<String> BASIC_EXITABLE_ERROR = new ExitMessageError<String>() {
        @Override
        public String getExitMessage() {
            return exit_message;
        }

        @Override
        public void exit() {
            System.exit(0);
        }
        String exit_message;
        @Override
        public void _throw(String message) {
            this.exit_message = message;
            System.err.println(exit_message);
            exit();
        }
    };
    
    private Err(){}
    
    public static void _assert(boolean b, String mess){
        if(!b)
            raise(mess);
    }
    public static void raise(String s){
        System.err.println(s);
        System.exit(0);
    }
    
    public static <Q> void _assert(boolean b, K_Error<Q> error, Q info){
        if(!b)
            error._throw(info);
    }
    public static <Q> void raise(K_Error<Q> error, Q info){
        error._throw(info);
    }
}