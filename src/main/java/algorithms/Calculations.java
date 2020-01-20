package algorithms;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import Kurier.CalculatingController;
import Kurier.Order;
import Kurier.SecondCalculationController;
import data.RoutesWraper;
import data.Server;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;

public class Calculations extends Task<String> implements Callable<String> {
	ProgressBar progressBar;
	CalculatingController controler = null;
	ObjectWraper objectWraper;
	SecondCalculationController controler2 = null;

	public Calculations(CalculatingController calculatingCaontroller, ProgressBar pb, ObjectWraper ow) {
		objectWraper = ow;
		progressBar = pb;
		controler = calculatingCaontroller;
	}

	public Calculations(SecondCalculationController calculatingCaontroller, ProgressBar pb, ObjectWraper ow) {
		objectWraper = ow;
		progressBar = pb;
		controler2 = calculatingCaontroller;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Start Obliczen");
		String result;
		
		try {

		Algorithm algorithm = new Algorithm();

		ArrayList<Order> orders = objectWraper.getOrders();

//		ArrayList<Integer> ordersID = objectWraper.getOrdersID();

		ArrayList<String> places = new ArrayList<String>();

		for (Order o : orders) {
			if (!places.contains(o.getAdressFrom()))
				places.add(o.getAdressFrom());
		}

		int[][] matrix = new int[places.size()][places.size()];

		Server server = new Server();

		RoutesWraper routes = server.getRoutes();

		ArrayList<String> Cities = routes.getCities();
		ArrayList<String> Cities2 = routes.getCities2();
		ArrayList<Integer> distance = routes.getDistance();

		for (int i = 0; i < Cities.size(); i++) {

			for (int a = 0; a < places.size(); a++) {
				for (int b = 0; b < places.size(); b++) {
//					matrix[a][b]= -1;
					if (a == b) {
						matrix[a][b] = 0;
					} else {
						if (Cities.get(i).equals(places.get(a)) && Cities2.get(i).equals(places.get(b))) {
							matrix[a][b] = distance.get(i);
						}
					}

				}
			}

		}

		for (int a = 0; a < matrix[0].length; a++) {
			for (int b = 0; b < matrix[0].length; b++) {

				if (matrix[a][b] == 0 && a != b)
					matrix[a][b] = matrix[b][a];

				System.out.print(matrix[a][b] + " ");

			}
			System.out.println();
		}

		algorithm.minCost(matrix);
		String lastTrace = algorithm.GetLastTrace();

		result = "Trasa " + lastTrace;
		int counter = 0;
		for (String s : places) {

			result += ("\n [" + counter + "] - " + s);
			counter++;

		}
		
		} catch(ArrayIndexOutOfBoundsException e) {
			result = "brak wartosci";
		}
		if (controler == null) {
			controler2.updateProgress();
			controler2.futureString = result;
		}
		if (controler2 == null){
			controler.updateProgress();
			controler.futureString = result;
		}
		System.out.println("Koniec Obliczen");
		
		

		return result;
	}

}
