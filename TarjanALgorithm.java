import java.util.ArrayList;

public class TarjanALgorithm {
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
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));
        

    }
    public static void dfs(ArrayList<Edge> graph[],int curr,int par,boolean vis[],int dt[],int low[],int time) {
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        for(int i=0;i<graph[curr].size();i++) {
            Edge e=graph[curr].get(i);
            if(e.dst==par){
                continue;
            }
            if(vis[e.dst]){
                low[curr]=Math.min(low[curr], dt[e.dst]);
                
            }else{
                dfs(graph, e.dst, curr, vis, dt, low, time);
                low[curr]=Math.min(low[curr], low[e.dst]);
                if(dt[curr]<low[e.dst]){
                    System.out.println("Bridge: "+curr+"---"+e.dst);
                }
            }
        }
    }
    public static void getBridge(ArrayList<Edge> graph[],int v) {
        int dt[] = new int[v];
        int low[]=new int[v];
        int time=0;
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(graph,i,-1,vis,dt,low,time);

            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        System.out.println("graphs");
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        getBridge(graph, v);
        

    }
}
