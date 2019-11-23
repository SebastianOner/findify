package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller2 {
    private Stage thisStage;

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
}
