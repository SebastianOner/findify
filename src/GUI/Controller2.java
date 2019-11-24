package GUI;

import SearchObjects.ClassObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller2{
    private ArrayList<ClassObject> projectClasses;

	private Stage               thisStage;
	private ControllerClass     controllerClass;
	private ControllerMethod    controllerMethod;
	private ControllerAttribute controllerAttribute;
	
	public Controller2(ArrayList<ClassObject> projectClasses) throws IOException{
        this.projectClasses = projectClasses;
		thisStage = new Stage();
		
		try{
			
			FXMLLoader loader =
					new FXMLLoader(getClass().getResource("chooseScene.fxml"));
			
			loader.setController(this);
			
			thisStage.setScene(new Scene(loader.load()));
			
			thisStage.setTitle("findify");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void showStage(){
		thisStage.show();
	}
	
	//creates the action event for clicking on the class button
	public void classFired(){
		thisStage.close();
		initializeControllerClass();
	}
	
	//creates the action event for clicking on the method button
	public void methodFired(){
		thisStage.close();
		initializeControllerMethod();
	}
	
	//creates the action for clicking on the attribute button
	public void attributeFired(){
		
		thisStage.close();
		initializeControllerAttribute();
	}
	
	//creates and initializes our class controller and stage
	private void initializeControllerClass(){
		try{
			controllerClass = new ControllerClass(projectClasses);
			controllerClass.showStage();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//creates and initializes our method controller and stage
	private void initializeControllerMethod(){
		try{
			controllerMethod = new ControllerMethod(projectClasses);
			controllerMethod.showStage();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//creates and initializes our attribute controller and stage
	private void initializeControllerAttribute(){
		try{
			controllerAttribute = new ControllerAttribute();
			controllerAttribute.showStage();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
