package Kurier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import algorithms.Calculations;
import algorithms.ObjectWraper;
import data.Counter;
import data.Server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

public class CalculatingController {
	Calculations task;
	List<Future<String>> ft;
	static List<Button> showsButton = new ArrayList<Button>();
	static List<Button> startButton = new ArrayList<Button>();

	public String futureString;

	private int counterinteger;
	
	@FXML
	private Label counter;
	@FXML
	private ProgressBar progressBar;

	@FXML
	private TextArea textAreaCalculating;

	@FXML
	private Button calculate;
	
	static List<Callable<String>> taskList = new ArrayList<Callable<String>>();

	@FXML
	void calculateOnAction(ActionEvent event) throws InterruptedException {

		textAreaCalculating.setText("Obliczanie...");

		
		for (Button b : startButton)
			b.setDisable(true);
		textAreaCalculating.setText("Obliczanie ...");


		ExecutorService executorService = Executors.newFixedThreadPool(1);

		

		ft = executorService.invokeAll(taskList);

		executorService.shutdown();

		System.out.println("koniec dzialania");

	}

	@FXML
	private Button show;

	@FXML
	void showOnAction(ActionEvent event) {
		getTask();
		show.setDisable(true);
	}

	private String getTask() {
		String result = "";

		if (ft != null) {
			for (Future<String> r : ft)
				try {
					result = String.valueOf(r.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} else {
			result = futureString;
		}
		textAreaCalculating.setText(result);

		return result;

	}

	public void updateProgress() {
		textAreaCalculating.setText("Zakonczone");
		for (Button b : showsButton)
			b.setDisable(false);

	}

	@FXML
	private StackPane calculatingBackground;
	private ObjectWraper objectWraper;

	@FXML
	protected void initialize() {

		counterinteger= Counter.numberOfCalculatingWindows;
		counter.setText("Okno numer : " + String.valueOf(Counter.numberOfCalculatingWindows));
		Counter.numberOfCalculatingWindows += 1;

		Server server = new Server();

		objectWraper = server.getOrdersToCalculate(counterinteger);

		ArrayList<Order> orders = objectWraper.getOrders();

		ArrayList<Integer> ordersID = objectWraper.getOrdersID();

		String stringToShow = "";

		for (int i = 0; i < orders.size(); i++) {

			stringToShow += "ID obiektu " + ordersID.get(i) + " nadane przez : " + orders.get(i).getName() + " "
					+ orders.get(i).getSurname() + " adres wysylki" + orders.get(i).getAdressFrom() + "\n";
		}

		textAreaCalculating.setText(stringToShow);
		Calculations task = new Calculations(this, progressBar, objectWraper);
		taskList.add(task);
		
		showsButton.add(show);
		startButton.add(calculate);
	}
}
