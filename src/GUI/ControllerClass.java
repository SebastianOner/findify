package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerClass {
    private Stage thisStage;

    //initializes the controller for the class stage
    public ControllerClass() throws IOException{
        thisStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("classScene.fxml"));
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

    public void interfaceFired(ActionEvent actionEvent){

    }

    public void abstractFired(ActionEvent actionEvent){

    }

    public void ENUMFired(ActionEvent actionEvent){

    }

    public void finalFired(ActionEvent actionEvent){

    }

    public void standardClassFired(ActionEvent actionEvent){

    }

    public void publicFired(ActionEvent actionEvent){

    }

    public void privateFired(ActionEvent actionEvent){

    }

    public void protectedFired(ActionEvent actionEvent){

    }

    public void staticFired(ActionEvent actionEvent){

    }

    public void extendedYFired(ActionEvent actionEvent){

    }

    public void extendedNFired(ActionEvent actionEvent){

    }

    public void implementedYFired(ActionEvent actionEvent){

    }

    public void implementedNFired(ActionEvent actionEvent){

    }

    public void genericYFired(ActionEvent actionEvent){

    }

    public void genericNFired(ActionEvent actionEvent){

    }

    public void intFired(ActionEvent actionEvent){

    }

    public void stringFired(ActionEvent actionEvent){

    }

    public void arraysFired(ActionEvent actionEvent){

    }

    public void doubleFired(ActionEvent actionEvent){

    }

    public void booleanFired(ActionEvent actionEvent){

    }

    public void charFired(ActionEvent actionEvent){

    }

    public void searchFired(ActionEvent actionEvent){

    }

    public void goFired(ActionEvent actionEvent){

    }
}