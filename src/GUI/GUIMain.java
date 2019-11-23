package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Stack;

public class GUIMain extends Application {

    Stage window;
    Scene startupScene, classScene, methodScene, attributeScene;
    Button classButton, methodButton, attributeButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Project Path");

        String os = System.getProperty("os.name").toLowerCase();
        String defaultPath = "";
        if (os.equals("linux") || os.equals("mac os x")) {
            defaultPath = "/home/";
        } else if (os.contains("windows")) {
            defaultPath = "%userprofile%";
        }

        System.out.println(System.getProperty("os.name").toLowerCase());

        File defaultDir = new File(defaultPath);
        chooser.setInitialDirectory(defaultDir);
        File selected = chooser.showDialog(primaryStage);
        System.out.println(selected.getPath());

         */

        System.out.println(System.getProperty("os.name").toLowerCase());

        //window definitions
        window = primaryStage;
        window.setTitle("findify");

        //startup window buttons definitions
        classButton = new Button("Class");
        methodButton = new Button("Method");
        attributeButton = new Button("Attribute");

        classButton.setOnAction(e -> window.setScene(classScene));
        methodButton.setOnAction(e -> window.setScene(methodScene));
        attributeButton.setOnAction(e -> window.setScene(attributeScene));

        //startup window scene definition
        Label startupText = new Label("Welcome to findify! What are you trying to find?");
        VBox startupLayout = new VBox(20);
        startupLayout.getChildren().addAll(startupText, classButton, methodButton, attributeButton);
        startupScene = new Scene(startupLayout, 400, 200);

        //classScene definition
        StackPane classLayout = new StackPane();
        classScene = new Scene(classLayout, 600, 300);

        //attributeScene definition
        StackPane attributeLayout = new StackPane();
        attributeScene = new Scene(attributeLayout, 600, 300);

        window.setScene(startupScene);
        window.show();


    }
    public static void main(String[] args) {launch(args);}
}
