package application;

/*
*
*Election program representing by Javafx interface .
*
*Enjoy!
*
*/
import controller.ElectionController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Election;
import model.ElectionsList;
import view.viewElectionTe;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		ElectionsList theModel = new ElectionsList();
		viewElectionTe electionView = new viewElectionTe(primaryStage);
		ElectionController electioncontoroller = new ElectionController(theModel, electionView);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
