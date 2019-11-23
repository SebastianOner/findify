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

public class GUIMain extends Application{

    Stage window;
    Scene chooseProjectScene, startupScene, classScene, methodScene, attributeScene;
    Button projectButton, classButton, methodButton, attributeButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("projectSelectorScene.fxml"));
        //window definitions
        window = primaryStage;
        window.setTitle("findify");
        window.setScene(new Scene(root, 300, 275));
        window.show();



        //startup window buttons definitions
        /*
        classButton = new Button("Class");
        methodButton = new Button("Method");
        attributeButton = new Button("Attribute");
        projectButton = new Button("Choose Project File");

        classButton.setOnAction(e -> window.setScene(classScene));
        methodButton.setOnAction(e -> window.setScene(methodScene));
        attributeButton.setOnAction(e -> window.setScene(attributeScene));
        projectButton.setOnAction(this);

        //project choosing scene definition
        StackPane projectLayout = new StackPane();
        projectLayout.getChildren().add(projectButton);
        chooseProjectScene = new Scene(projectLayout, 400, 400);

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

         */




    }

    public static void main(String[] args) {
        launch(args);
    }
/*
    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource() == projectButton){
            DirectoryChooser chooser = new DirectoryChooser();
            chooser.setTitle("Project Path");

            String os = System.getProperty("os.name").toLowerCase();
            String defaultPath = "";
            if (os.equals("linux") || os.equals("mac os x")) {
                defaultPath = "/home/";
            } else if (os.contains("windows")) {
                defaultPath = "C:\\Users\\";
            }

            System.out.println(System.getProperty("os.name").toLowerCase());

            File defaultDir = new File(defaultPath);
            chooser.setInitialDirectory(defaultDir);
            File selected = chooser.showDialog(window);
            System.out.println(selected.getPath());
        }
    }
    */

}
