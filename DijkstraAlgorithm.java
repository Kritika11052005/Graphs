import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
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
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));
        graph[2].add(new Edge(2,4,3));
        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;//ascending 
        }
    }
    public static void Dijkstra(ArrayList<Edge> graph[],int src,int v){
        PriorityQueue<Pair> queue=new PriorityQueue<Pair>();
        boolean vis[]=new boolean[v];
        int dist[]=new int[v];
        for(int i=0;i<v;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        queue.add(new Pair(src,0));
        while(!queue.isEmpty()){
            Pair curr=queue.remove();//shortest
            if(!vis[curr.node]){
                vis[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int w=e.dst;
                    if(dist[u]+e.wt < dist[w]){//relaxation
                        dist[w]=dist[u]+e.wt;
                        queue.add(new Pair(w,dist[w]));
                    }
                }
            }
        }
        for(int i=0;i<v;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        System.out.println("graphs");
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        Dijkstra(graph, 0,v);

    }
}
