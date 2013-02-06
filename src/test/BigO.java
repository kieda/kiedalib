/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author kieda
 */
public class BigO {
    protected int tokens = 0;
    protected void addTokens(int tokens){
        assert tokens >= 0;
        this.tokens += tokens;
    }
    protected void removeTokens(int tokens){
        assert tokens >= 0;
        this.tokens -= tokens;
    }
}
