package algorithms;

import java.util.concurrent.Callable;

import data.DataContainer;

public class AlgBellamFord implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		
		System.out.println(" Algorytm BellamForda zaczyna sie ");
		Thread.sleep(1000);
		
		
		new DataContainer().setBestRoute("BellamFord");
		
		
		System.out.println(" Algorytm BellamForda zakonczony ");
		
		
		
		return null;
	}

	
	
	
	
	
}
