package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//// TODO : implement reading data from database

public class DataContainer {

	private File cityFile;

	private File graphFile;

	private static Integer[][] graph=null;
	
	private static String bestRoute="";

	private static ArrayList<String> namesOfCities = new ArrayList<String>();

	public DataContainer() {}
	
	public DataContainer(String srcFileCity, String srcFileData) {

		try {

			cityFile = new File(srcFileCity);

			graphFile = new File(srcFileData);

			readData();
		} catch (NullPointerException e) {
			System.out.println("Error with File, probably empty name of file");
		}

	}

	private void readData() {

		Scanner inNames = null;

		try {
			inNames = new Scanner(cityFile);

			while (inNames.hasNext()) {

				namesOfCities.add(inNames.next());
			}

			graph = new Integer[namesOfCities.size()][namesOfCities.size()];

			for (int i = 0; i < namesOfCities.size(); i++)
				graph[i] = new Integer[namesOfCities.size()];

			
			Scanner inGraph = null;

			
			try {
				
				inGraph = new Scanner(graphFile);

				for (int i = 0; i < namesOfCities.size(); i++) {

					for (int j = 0; j < namesOfCities.size(); j++) {
						
						graph[i][j]=inGraph.nextInt();
						
					}

				}

			} catch (FileNotFoundException e) {
				System.out.println("File not found ");
				e.printStackTrace();
			}
			finally {
				if (inGraph != null)
					inGraph.close();
			}


		} catch (FileNotFoundException e) {
			System.out.println("File not found ");
		} finally {
			if (inNames != null)
				inNames.close();
		}

	}
	
	public void printData() {
		System.out.print("        ");
		for(int i=0;i<namesOfCities.size();i++) {
			
			System.out.print(namesOfCities.get(i)+ " ");
		}
		System.out.println();
		for(int i=0;i<namesOfCities.size();i++) {
			System.out.print(namesOfCities.get(i)+"    ");

			for(int j=0;j<namesOfCities.size();j++) {
				
			
			System.out.print(graph[i][j]+"       ");
			
			
			
			
		}
			System.out.println();
		}
	}
	
	public void setBestRoute(String route) {
		
	DataContainer.bestRoute=route;	
		
	}
	
	public String getBestRoute() {
		return DataContainer.bestRoute;
	}
	
	public Integer[][] getGraph(){
		
		return DataContainer.graph;
	}
	
	public ArrayList<String> getCityNames(){
		return DataContainer.namesOfCities;
	}
	
	

}
