import java.util.ArrayList;

public class Articulationpoint {
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
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));

    }
    public static void dfs(ArrayList<Edge> graph[],int curr,int par,int dt[],int low[],boolean vis[],int time,boolean ap[]) {
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        int child=0;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            int neigh=e.dst;
            if(par==neigh){
                continue;

            }else if(vis[neigh]){
                low[curr]=Math.min(low[curr],dt[neigh]);

            }else{
                dfs(graph,neigh, curr, dt, low, vis,time,ap);
                low[curr]=Math.max(low[curr],low[neigh]);
                if(dt[curr]<=low[neigh]&&par!=-1){
                    ap[curr]=true;
                }
                child++;
            }
        }
        if(par==-1 && child>1){
            ap[curr]=true;
        }
    }
    public static void getAP(ArrayList<Edge> graph[],int v) {
        int dt[]=new int[v];
        int low[]=new int[v];
        int time=0;
        boolean vis[]=new boolean[v];
        boolean ap[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,vis,time,ap);
            }
        }
        for(int i=0;i<v;i++){
            if(ap[i]){
                System.out.println(i);
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        System.out.println("graphs");
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        getAP(graph, v);


    }
}
