package algorithms;

import java.util.concurrent.Callable;

import data.DataContainer;

public class AlgDjikstra implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		
		System.out.println(" Algorytm Dijkstry zaczyna sie ");
		Thread.sleep(5000);
		
		
		
		new DataContainer().setBestRoute("Djikstra");
		
		
		System.out.println(" Algorytm Dijkstry zakonczony");
		
				
		return null;
	}

}
