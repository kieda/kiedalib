/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kieda.graphics.aura;

import java.awt.geom.Point2D;

/**
 * a "point vector"
 * Essentially, a point that also has a magnitude (size).
 * This is different from a vector which has a magnitude due to the property
 * of vectors. In this case, the point is a physical location, without a 
 * direction. The size is the weight at the certain point.
 * 
 * This is useful, say, if you want to describe where a circle's center should 
 * be (A Point) and what size the circle is (a size)
 * 
 * @author kieda
 */
public class ptV {
    //a point with a magnitude
    public ptV(float x, float y, float size){
        this.p = new Point2D.Float(x, y); this.size = size;}
    public Point2D p;
    public float size;
}
