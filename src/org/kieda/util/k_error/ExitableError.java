/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kieda.util.k_error;

/**
 *
 * @author kieda
 */
public interface ExitableError<Q> extends K_Error<Q>{
    public void exit();
}