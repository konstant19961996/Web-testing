/**
 * Created by 803100 on 27.10.2016.
 */
package com.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class graph {
    private int n=11; //вершины
    private int m=9; //дуги
   // private ArrayList<Integer> adj[];
    //public  boolean used[];

    private BufferedReader cin;
    private PrintWriter cout;
    private StringTokenizer tokenizer;
    public String str="";

    private ArrayList<Integer> adj[];
    private boolean used[];

    public boolean[] initused2(){
        used = new boolean[n];
        Arrays.fill(used, false);
        return used;

    }
    public ArrayList<Integer>[] initadj2(){
        adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<Integer>();
        }
        adj[0].add(1);
        adj[1].add(0);
        adj[0].add(2);
        adj[2].add(0);
        adj[1].add(3);
        adj[3].add(1);
        adj[1].add(4);
        adj[4].add(1);
        adj[2].add(5);
        adj[5].add(2);
        adj[2].add(6);
        adj[6].add(2);
        adj[3].add(7);
        adj[7].add(3);
        adj[3].add(8);
        adj[8].add(3);
        adj[4].add(9);
        adj[9].add(4);
        adj[6].add(10);
        adj[10].add(6);
        return adj;
    }

    public  boolean check (String str)
    {
        int p = str.length();
        boolean a1=true;
        if (str==null)
            return true;
        for (int i=0; i<p; i++)
        {
            if ((str.codePointAt(i)<48)||(str.codePointAt(i)>57))
                return false;
        }
        return a1;
    }

    public String dfs (int v, int d, ArrayList<Integer> adj[], boolean used[])
    {
        try {
        if (adj == null) {
            throw new Exception("There no graph");
        }
        if ((v>=n)||(v<0)) {
                throw new Exception("First vertex is wrong");
            }
            if (d>=n || (d<0)) {
                throw new Exception("Second vertex is wrong");
            }
            if (used == null) {
                throw new Exception("There no vertex array");
            }
    } catch(Exception o){
        return o.getMessage();
    }
        if (used[v])
            return str;
        used[v]=true;
        // cout.print((v + 1 ) + " ");
        if (v==d)
        {
            str=str+" "+(v + 1);
            Arrays.fill(used, true);
            return str;
        }

        str=str+" "+(v + 1);
        //int i=0;
        for (int i=0; i < adj[v].size(); ++i)
        {
            int w = adj[v].get(i);
            if (w==d)
            {
                str=str+" "+(w + 1);
                Arrays.fill(used, true);
                return str;
            }
            dfs(w,d,adj,used);
        }
        return  str;
    }


  /*  public  void run() throws  IOException{

       // readData();
        ArrayList<Integer> adj[],adj1[];
        cin = new BufferedReader(new InputStreamReader(System.in));
        cout = new PrintWriter(System.out);

        //инициализируем список смежности графа размерности n
        adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<Integer>();
        }

        //считываем граф, заданный списком ребер
        adj[0].add(1);
        adj[1].add(0);
        adj[0].add(2);
        adj[2].add(0);
        adj[1].add(3);
        adj[3].add(1);
        adj[1].add(4);
        adj[4].add(1);
        adj[2].add(5);
        adj[5].add(2);
        adj[2].add(6);
        adj[6].add(2);
        adj[3].add(7);
        adj[7].add(3);
        adj[3].add(8);
        adj[8].add(3);
        adj[4].add(9);
        adj[9].add(4);
        adj[6].add(10);
        adj[10].add(6);
        adj[5].add(9);
        adj[9].add(5);
        boolean used[];
        used = new boolean[n];
        Arrays.fill(used, false);
        int v=0,d=10;
        //for (int v=0; v<n; v++)
        dfs(v,d,adj,used);
        cout.print("Str=" + str);
        // cin.close();
        cout.close();
    }*/

   public  static  void main(String[] args) throws  Exception{
        //graph g = new graph();
        //g.run();
       //web www = new web();
    }
}
