import java.util.*;
import java.io.*;
import java.math.*;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Integer> h = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            h.add(pi);
        }
        h.sort((a,b)-> a-b);
        
        ArrayList<Integer> h2 = new ArrayList<>();
        for(int i=0; i<h.size()-1; i++){
            int n = h.get(i+1)-h.get(i);
            h2.add(n);    
            }
        h2.sort((a,b)-> a-b);

    System.out.println(h2.get(0));
    }
}