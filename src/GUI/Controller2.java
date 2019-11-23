package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller2 {
    private Stage thisStage;
    private ControllerClass controllerClass;
    private ControllerMethod controllerMethod;
    private ControllerAttribute controllerAttribute;

    public Controller2() throws IOException {

        thisStage = new Stage();

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("chooseScene.fxml"));

            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));

            thisStage.setTitle("findify");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.showAndWait();
    }

    public void classFired(ActionEvent actionEvent){

    }

    public void methodFired(ActionEvent actionEvent){

    }

    public void attributeFired(ActionEvent actionEvent){

    }

    //creates and initializes our third controller and stage
    private void initializeControllerClass(){
        try {
            controllerClass = new ControllerClass();
            controllerClass.showStage();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void initializeControllerMethod(){
        try {
            controllerMethod = new ControllerMethod();
            controllerMethod.showStage();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void initializeControllerAttribute(){
        try {
            controllerAttribute = new ControllerAttribute();
            controllerAttribute.showStage();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
