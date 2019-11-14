package algorithms;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import data.DataContainer;

public class AlgForSmallGraph implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
	
		
		System.out.println("Alg for small graph start");
		
		DataContainer temp = new DataContainer();
		
		
		Integer [][] graph = temp.getGraph();
		
		ArrayList<String> Cities = temp.getCityNames();
		
		
		temp.setBestRoute("malygraf");
		
		System.out.println("Alg for small graph stop");
		
		return null;
	}

	
	
	

}
