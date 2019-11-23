package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class GUIMain extends Application {

    Stage window;
    Scene startupScene, classScene, methodScene, attributeScene;
    Button classButton, methodButton, attributeButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Project Path");
        File defaultDir = new File("/home/");
        chooser.setInitialDirectory(defaultDir);
        File selected = chooser.showDialog(primaryStage);
        System.out.println(selected.getPath());

    }
    public static void main(String[] args) {launch(args);}
}
