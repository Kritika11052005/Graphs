import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {
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
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));

    }
    public static boolean isCycleDirected(ArrayList<Edge> graph[],boolean vis[],int curr,boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dst]){//cycle
                return true;
            }
            else if(!vis[e.dst]){
                if(isCycleDirected(graph,vis,e.dst,rec)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        System.out.println("graphs");
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        boolean vis[]=new boolean[v];
        boolean rec[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                boolean isCycle=isCycleDirected(graph, vis, 0, rec);
                if(isCycle){
                    System.out.println(isCycle);
                    break;
                }
            }
        }
        

    }

    
}
