import java.util.*;

public class TopologicalSorting {
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
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
        

    }
    public static void topSortUtil(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer> stack){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dst]){
                topSortUtil(graph,e.dst,vis,stack);
            }
        }
        stack.push(curr);
    }
    public static void topSort(ArrayList<Edge> graph[],int v){
        boolean vis[]=new boolean[v];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topSortUtil(graph,i,vis,stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop()+" ");
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        System.out.println("graphs");
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        topSort(graph,v);

    }

    
}
