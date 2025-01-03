import java.util.ArrayList;

public class CycleDetectionInUndirectedGraph {
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
        graph[0].add(new Edge(0,4));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,4));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,2));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));
        graph[5].add(new Edge(5,4));

    }
    public static boolean isCycleUndirected(ArrayList<Edge> graph[],boolean vis[],int curr,int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dst]&&e.dst!=par){
                return true;
            }
            else if(!vis[e.dst]){
                if(isCycleUndirected(graph, vis, e.dst,curr)){
                    return true;
                }
        }}
        return false;
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        System.out.println("graphs");
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycleUndirected(graph,new boolean[v], 0, -1));

    }
    
}
