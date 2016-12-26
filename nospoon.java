/**
 * Created by victor on 26/12/16.
 */
/*The game is played on a rectangular grid with a given size. Some cells contain power nodes.
The rest of the cells are empty.
The goal is to find, when they exist, the horizontal and vertical neighbors of each node.
https://www.codingame.com/ide/puzzle/there-is-no-spoon-episode-1
*/

import java.util.*;
import java.io.*;
import java.math.*;
// Write an action using System.out.println()
// To debug: System.err.println("Debug messages...");
// Three coordinates: a node, its right neighbor, its bottom neighbor


class Nodo {
    private int x;
    private int y;
    private int hx = -1;
    private int hy = -1;
    private int vx = -1;
    private int vy = -1;

    public Nodo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Nodo(int x, int y, int hx, int hy, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.hx = hx;
        this.hy = hy;
        this.vx = vx;
        this.vy = vy;
    }

    public int getX() {
        return x;
    }

    public int getY() { return y; }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHx() {
        return hx;
    }

    public int getHy() {
        return hy;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public void setH(int hx, int hy) {
        this.hx = hx;
        this.hy = hy;
    }

    public void setV(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }

    @Override
    public String toString() {
        return y + " " + x + " " + hx + " " + hy + " " + vx + " " + vy;
    }
}
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        List<Nodo> nodos = new ArrayList<>();
        //ArrayList<char[]> mapa = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            char[] charline = line.toCharArray();
            //System.err.println("*Tamaño charline: "+charline.length);
            for(int j=0; j < charline.length; j++){
                if((char)charline[j] == '0'){
                    nodos.add(new Nodo(i,j));
                }
            }
        }
        /*debug Lista nodos
        for(Nodo n:nodos){
            System.err.println(n.toString());
        }
        /*****************/
        for(int i=0; i<nodos.size(); i++) {
            int ix = nodos.get(i).getX();
            int iy = nodos.get(i).getY();
            for (int j = 0; j < nodos.size(); j++) {
                int jx = nodos.get(j).getX();
                int jy = nodos.get(j).getY();
                if (ix < jx & iy == jy) {
                    Nodo aux = nodos.get(i);
                    Nodo nuevo = new Nodo(aux.getX(), aux.getY(), aux.getVx(), aux.getVy(), jy, jx);
                    nodos.set(i, nuevo);
                    break;
                }
            }
            for (int j = 0; j < nodos.size(); j++) {
                int jx = nodos.get(j).getX();
                int jy = nodos.get(j).getY();
                if (ix == jx & iy < jy) {
                    Nodo aux = nodos.get(i);
                    Nodo nuevo = new Nodo(aux.getX(), aux.getY(), jy, jx, aux.getVx(), aux.getVy());
                    nodos.set(i, nuevo);
                    break;
                }
            }
        }
        /*Debug de lista-nodos ya comprobados los vecinos*/
        System.err.println("Nodos");
        for(Nodo n:nodos){
            System.err.println(n.toString());
        }
        /*****/
        for(Nodo n:nodos){
            System.out.println(n.toString());
        }

        //System.out.println("0 0 1 0 0 1");
        //System.err.println("*Tamaño lista nodos: "+nodos.size());
    }



}