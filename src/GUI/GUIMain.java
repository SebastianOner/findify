package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUIMain extends Application{

    //Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller1 controller1 = new Controller1();

        controller1.showStage();
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
}
