package org.kieda.data_structures;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

/**
 * This is an awesome class used for most excellent interfacing using graphs.
 * Just have a class extend Graph, and create sub-classes for the vertices and
 * edges specific to your graph implementation, and then you'll have a great-working
 * graph with a strong backing!
 * 
 * Note - this backing uses asserts, in order for fp's great theories about code-correctness
 * and contracts. If there ever is any user input that will eventually be processed through
 * the graph system, make sure that you have checked it for errors on the client-input side.
 *
 * @author kieda
 */
public class Graph{
   /**
    * this is the list of vertices based on the vertices integer name.
    * In this graph, the vertices and edges are labled using integers,
    * so this map works rather nicely or some bullshit.
    *
    * This is protected if the client wants to create a graph based on
    * this structure.
    */
    protected Map<Integer,Vertex> vertices;
  
   /**
    * This is just a set of edges that the graph contains.
    * See the class edge to tell the way it works a bit better.
    * 
    * You should also check out the DirEdge and UndirEdge,
    * which are implementations of edge which allow their type-
    * checking to go into the hashset such that UndirEdges
    * represent directed edges going both ways between two points. 
    */
    protected HashSet<Edge> edges;

   /**
    * just creates a new, completely empty graph (no edges or vertices)
    */ 
    public Graph(){
        vertices = new HashMap<Integer, Vertex>();
        edges = new HashSet<Edge>();
    }

   /**
    * Adds an edge to the graph. Make sure before calling this method that the edge you're
    * putting in has valid output vertices (the edge has to connect two things together)
    */
    @SuppressWarnings("") public void addEdge(Edge e){
        assert vertices.containsKey(e.from)&&vertices.containsKey(e.to): "Invalid Edge " + e;
        edges.add(e);
    }

    /**
     * by default, adds an undirected edge between p1 to p2.
     *
     * this method may be overridden such that the default adds on a different type of
     * edge. (like you want to only ad on paintable edges onto a paint graph, you would want
     * the default to add a paintable edge.)
     */
    @SuppressWarnings("") public void addEdge(Integer p1, Integer p2){
        assert vertices.containsKey(p1)&&vertices.containsKey(p2): "Invalid Edge {"+p1+", "+p2+"}";
        edges.add(new UndirEdge(p1, p2));
    }

    /**
     * removes an edge. Direction matters here, i.e. removing an undirected edge 
     * would remove all directed and undirected edges between the two points.
     * Removing an directed edge will remove all undirected edges between the two 
     * specified vertices, and will remove all directed edges with the same 
     * beginning and end.
     *
     * @requires that the edge being removed connects to vertices in the graph.
     */
    @SuppressWarnings("") public void removeEdge(Edge e){
        assert vertices.containsKey(e.from)&&vertices.containsKey(e.to): "Invalid Edge " + e;
        edges.remove(e);
        //there might be an edge that goes both ways,so we would want to remove
        //both of them.
        if(e instanceof UndirEdge){
            edges.remove(e);
        }
    }
    
    @SuppressWarnings("") public void removeEdge(Integer p1, Integer p2){
        assert vertices.containsKey(p1)&&vertices.containsKey(p2): "Invalid Edge {"+p1+", "+p2+"}";
        edges.remove(new UndirEdge(p1, p2));
    }
    //override this method if you need specific typing
    public void removeVertex(Vertex v){
        //get v name
        //v name -> map -> position
        if(v!=null)
            removeVertex(v.name);
    }
    public void removeVertex(int v){
        //get v name
        //v name -> map -> position
        
        Vertex pos = vertices.remove(new Integer(v));
        if(pos!=null){
            Object[] n = edges.toArray();
            for(Object c : n){
                Edge nn = (Edge)c;
                if(nn.to==v || nn.from == v){
                    edges.remove(nn);
                }
            }
        }
    }
    //override this method if you need specific typing
    public void addVertex(Vertex v){
        //get v name
        //put v ono the map
        //add v on the map's position
        if(v!= null && v.name!=null)
        vertices.put(v.name, v);
    }
    public void addVerts(Integer... verts){
        for(Integer i : verts){
            addVertex(i);
        }
    }
    /**
     * default for creating a new vertex. Just adds a basic vertex at the name
     * @param v 
     */
    public void addVertex(Integer v){
        Vertex c = new Vertex(v);
        //get v name
        //put v ono the map
        //add v on the map's position
        addVertex(c);
    }
    public int size(){
        return vertices.size();
    }
    /**
     * please don't do shit you shouldn't do with this method (i.e setting the
     * vals to things that they shouldn't be.)
     */
    public ArrayList<Vertex> getVerts(){
        return new ArrayList<Vertex>(vertices.values());
    }
    public Vertex getVert(int i){
        return vertices.get(
                    i 
                    //gets the index for which the name is at
                );
    }
    public Set<Edge> getEdges(){
        return edges;
    }
    public class Vertex { //wrapper class that stores info.
        Integer name;
        @Override public boolean equals(Object other){
            if(other instanceof Integer) return (Integer)other == name;
            else if(other instanceof Vertex) return ((Vertex)other).name == name;
            return false;
        } public Vertex(Integer name){this.name = name;}
        @Override public int hashCode(){
            return name;
        } @Override public String toString(){
            return ""+ name;
        }
    }
    /**in case if the client wants to make a new way for the Edges to function*/
    public interface hqeq{
        public boolean eq(Object other);
        public int hc();
    }
    public abstract class Edge implements hqeq{
        public Integer from, to;  //an edge FROM x TO y
        public Edge(Integer from, Integer to){this.from = from; this.to = to;}
        @Override public boolean equals(Object other){
            return eq(other);
        } 
        @Override public int hashCode(){
            return hc();
        } @Override public String toString(){
            return "{"+from+", "+to+"}";
        }
    } 
    /*Basic class used for directed edges*/
    public class DirEdge extends Edge{
        public DirEdge(Integer from, Integer to){super(from, to);}
        /**
        * Hash code does not depend on which edge is which. 
        * This is because it is important that an undirected edge can remove a
        * directed edge. This is sub-optimal, as edges in both directions are
        * placed in the same bucket, but that's OK I guess.
        */
        @Override public int hc(){
            return (Math.max(from, to)<<20)^Math.min(from, to);
        }
        /**
        * Non-neutral equal. Two edges are equal if and only if the edges are the
        * same, and have the same order.
        */
        @Override public boolean eq(Object other){
            //in the case we are comparing undirected edges
            if(other instanceof UndirEdge)
                return (((Edge)other).from == from 
                    &&((Edge)other).to == to)
                    ||(((Edge)other).to == from 
                    &&((Edge)other).from == to);
            if(other instanceof Edge) 
                return (((Edge)other).from == from 
                    &&((Edge)other).to == to);
            return false;
        }
    }
    /*Basic class used for undirected edges*/
    public class UndirEdge extends Edge{
        public UndirEdge(Integer from, Integer to){super(from, to);}

        /**
        * Hash code does not depend on which edge is which. It's directionless.
        */
        @Override public int hc(){
            return (Math.max(from, to)<<20)^Math.min(from, to);
        }
        /**
        * A neutral equal - two edges can be the same with the edges backwards.
        */
        @Override public boolean eq(Object other){
            if(other instanceof Edge) 
                return (((Edge)other).from == from 
                    &&((Edge)other).to == to)
                    ||(((Edge)other).to == from 
                    &&((Edge)other).from == to);
            return false;
        }
    }
}
