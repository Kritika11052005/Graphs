import java.util.*;

public class Kosarajualgorithm {
    static class Edge{
    int src;
    int dst;
    Edge(int s,int d){
        this.src = s;
        this.dst = d;
        
    }
}
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));

    }
    public static void topSort(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer> stack){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dst]){
                topSort(graph,e.dst,vis,stack);
            }
        }
        stack.push(curr);
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[]){
        if(vis[curr]){
            return;
        }
        System.out.print(curr + " " );

        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dst]==false){
            dfs(graph,e.dst,vis);
        }}
    }
    @SuppressWarnings("unchecked")
    public static void kosaraju(ArrayList<Edge> graph[],int v){
        Stack<Integer> s=new Stack<>();
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topSort(graph,i,vis,s);
            }
        }
        ArrayList<Edge> transpose[]=new ArrayList[v];
        for(int i=0;i<transpose.length;i++){
            vis[i]=false;
            transpose[i]=new ArrayList<Edge>();
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                transpose[e.dst].add(new Edge(e.dst,e.src));

            }
        }
        while(!s.isEmpty()){
            int curr=s.pop();
            if(!vis[curr]){
                dfs(transpose,curr,vis);
                System.out.println();
            }
            
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        System.out.println("graphs");
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        kosaraju(graph, v);

    }

    
}
