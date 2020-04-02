import java.util.*;
class Graph
{
    private int v;
    private ArrayList<Integer>[]adjList;
    private ArrayList<Integer>currPath=new ArrayList<>();
    private boolean[]isVisited;
    private int no_of_paths = 0;
    Graph(int vertices)
    {
        this.v=vertices;
        isVisited = new boolean[vertices];
        initAdjList();
    }
    private void initAdjList()
    {
        adjList = new ArrayList[v];
        for(int i=0;i<v;i++)
            adjList[i] = new ArrayList<>();
    }
    void addEdge(int u,int v)
    {
        adjList[u].add(v);
    }
    void printPaths(int s,int d)
    {
        if(isVisited[s])return;
        isVisited[s] = true;
        currPath.add(s);
        if(s==d)
        {
            printPath(currPath);
            no_of_paths++;
            currPath.remove(currPath.size()-1);
            isVisited[s]=false;
            return;
        }
        for(int i=0;i<adjList[s].size();i++)
            printPaths(adjList[s].get(i),d);
        
        currPath.remove(currPath.size()-1);
        isVisited[s] = false;
    }
    private void printPath(ArrayList<Integer>path)
    {
        for(int i=0;i<path.size();i++)
            System.out.print(path.get(i)+" ");
        System.out.println("");
    }
    public int getCountOfPaths()
    {
        return no_of_paths;
    }
}

class solution {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t=scan.nextInt();
		while(t-->0)
		{
		    int V = scan.nextInt();
		    int E = scan.nextInt();
		    
		    Graph graph = new Graph(V);
		    
		    for(int i=0;i<E;i++)
		    {
		        int u=scan.nextInt();
		        int v=scan.nextInt();
		        graph.addEdge(u,v);
		    }
		    int source = scan.nextInt();
		    int destination = scan.nextInt();
		    
		    graph.printPaths(source,destination);
		}
	}
}
