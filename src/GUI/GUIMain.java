package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUIMain extends Application{
	public static void main(String[] args){
		launch(args);
	}
	@Override public void start(Stage primaryStage) throws Exception{
		Controller1 controller1 = new Controller1();
		
		controller1.showStage();
	}
}
