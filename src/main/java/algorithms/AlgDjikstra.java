package algorithms;

import java.util.concurrent.Callable;

import data.DataContainer;

public class AlgDjikstra implements Callable<Integer> {
	
	private int V=(int)(new DataContainer().getCityNames().size());
	
	Integer  graph [][] = new DataContainer().getGraph();
	
	@Override
	public Integer call() throws Exception {

		
		System.out.println(" Algorytm Dijkstry zaczyna sie ");
	//	Thread.sleep(5000);
		
		
		
		
		int dist[] = new int[V];
		Boolean sptSet[] =  new Boolean[V];
		for(int i=0;i<V;i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i]=false;
		}
		
		dist[0]=0;
		
		for(int count = 0;count <V -1 ;count++) {
			
			
			int u=minDistance(dist,sptSet);
			
			
			sptSet[u] = true;
			for(int v=0;v<V;v++) {
				
				if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
				dist[v] = dist[u] +graph[u][v];
			}
			
		}
		
		new DataContainer().setBestRoute("Djikstra");
		
		System.out.println(" Algorytm Dijkstry zakonczony");
		
				
		return null;
	}
	
	int minDistance(int dist[] , Boolean sptSet[]) {
		int min = Integer.MAX_VALUE, min_index=-1;
		for( int v = 0;v<V ;v++) {
			if(sptSet[v] == false && dist[v] <=min) {
				min = dist[v];
				min_index=v;
			}			
		}
		
		return min_index;
	}
	
	
}
