/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kieda.util.k_error;

/**
 *
 * @author kieda
 */
public interface ExitMessageError<String> extends ExitableError<String>{
    public String getExitMessage();
}
