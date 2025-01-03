import java.util.*;

public class PrimsAlgo {
    static class Edge{
    int src;
    int dst;
    int wt;
    Edge(int s,int d,int w){
        this.src = s;
        this.dst = d;
        this.wt=w;
    }
}
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));
        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));
        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));

    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;//ascending 
        }
    }
    public static void prims(ArrayList<Edge> graph[],int v) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        boolean vis[]=new boolean[v];
        queue.add(new Pair(0,0));
        int mstcost=0;
        while(!queue.isEmpty()) {
            Pair curr=queue.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;
                mstcost+=curr.cost;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    if(!vis[e.dst]){
                        queue.add(new Pair(e.dst,e.wt));
                    }
                }

            }
            
        }
        System.out.println(mstcost + " ");
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        System.out.println("graphs");
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        prims(graph, v);
        

    }
}
