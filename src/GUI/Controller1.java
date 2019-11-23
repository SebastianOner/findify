package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller1 {

    private Stage thisStage;

    public Button projectButton;

    public Controller1() throws IOException {
        thisStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("projectSelectorScene.fxml"));

        loader.setController(this);

        thisStage.setScene(new Scene(loader.load()));

        thisStage.setTitle("findify");
    }

    public void projectButtonFired(ActionEvent actionEvent) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Project Path");

        String os = System.getProperty("os.name").toLowerCase();
        String defaultPath = "";
        if (os.equals("linux") || os.equals("mac os x")) {
            defaultPath = "/home/";
        } else if (os.contains("windows")) {
            defaultPath = "C:\\Users\\";
        }

        File defaultDir = new File(defaultPath);
        chooser.setInitialDirectory(defaultDir);
        File selected = chooser.showDialog(thisStage);

        System.out.println(selected.getPath());

    }

    public void showStage() {
        thisStage.showAndWait();
    }

    public void classFired(ActionEvent actionEvent) {
    }

    public void attributeFired(ActionEvent actionEvent) {
    }

    public void methodFired(ActionEvent actionEvent) {
    }
}
