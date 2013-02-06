package org.kieda.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * This is a nice class used for any advanced painting a client
 * might want to do. 
 * 
 * This renderable type is associated with Disp, a neat way of
 * frame handling. 
 *
 * Painting through renderables allows objects themselves have certain
 * properties of being renderable.
 *
 * A good example is the paint graph. The paint graph has a 
 * backing of a graph, and implements renderable and has all of the
 * necessary functions filled in, so it can do painting
 * based on its mathematical backing and its painting-ness.
 * 
 * @author kieda
 */
public interface Renderable {
   /**
    * This method is used for painting whatever the
    * user wants. Typically, the client is handed the current
    * graphics that will be painted onto the screen.
    */
    public void render(Graphics2D g);
   /**
    * this method is called in case if there is something that the
    * rendered object should update about.
    */ 
    public void update();
}
