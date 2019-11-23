package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerClass {
    private Stage thisStage;

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
}
