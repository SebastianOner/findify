package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {


    Stage window;
/*
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("findify");

    }

    public static void main(String[] args) {launch(args);}

     */

    public Button projectButton;

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

        System.out.println(System.getProperty("os.name").toLowerCase());

        File defaultDir = new File(defaultPath);
        chooser.setInitialDirectory(defaultDir);
        File selected = chooser.showDialog(window);
        System.out.println(selected.getPath());
    }
}
