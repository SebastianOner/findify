package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerClass {
    private Stage thisStage;
    //yes no checkbox variables
    private CheckBox extendedYCheck, extendedNCheck, implementedYCheck, implementedNCheck, genericsYCheck, genericsNCheck;
    //rest of the check box variables
    private CheckBox publicCheck, privateCheck, protectedCheck, staticCheck, intCheck, stringCheck, doubleCheck, booleanCheck,
            charCheck, arraysCheck, abstractCheck, interfaceCheck, ENUMCheck, finalCheck, classCheck;
    private TextField searchField;
    private Button goButton;


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
        thisStage.show();
    }

    public void interfaceFired(){
        if(interfaceCheck.isSelected())
            System.out.println("True");
    }

    public void abstractFired(){
        if(abstractCheck.isSelected())
            System.out.println("True");
    }

    public void ENUMFired(){
        if(ENUMCheck.isSelected())
            System.out.println("True");
    }

    public void finalFired(){
        if(finalCheck.isSelected())
            System.out.println("True");
    }

    public void standardClassFired(){
        if(classCheck.isSelected())
            System.out.println("True");
    }

    public void publicFired(){
        if(publicCheck.isSelected())
            System.out.println("True");
    }

    public void privateFired(){
        if(privateCheck.isSelected())
            System.out.println("True");
    }

    public void protectedFired(){
        if(protectedCheck.isSelected())
            System.out.println("True");
    }

    public void staticFired(){
        if(staticCheck.isSelected())
            System.out.println("True");
    }

    public void extendedYFired(){
        if(extendedYCheck.isSelected()){
            extendedNCheck.setSelected(false);
        }

    }

    public void extendedNFired(){
        if(extendedNCheck.isSelected()){
            extendedYCheck.setSelected(false);
        }
    }

    public void implementedYFired(){
        if(implementedYCheck.isSelected())
            extendedNCheck.setSelected(false);
    }

    public void implementedNFired(){
        if(implementedNCheck.isSelected())
            extendedYCheck.setSelected(false);
    }

    public void genericYFired(){
        if(genericsYCheck.isSelected())
            genericsNCheck.setSelected(false);
    }

    public void genericNFired(){
        if(genericsNCheck.isSelected())
            genericsYCheck.setSelected(false);
    }

    public void intFired(){
        if(intCheck.isSelected())
            System.out.println("True");
    }

    public void stringFired(){
        if(stringCheck.isSelected())
            System.out.println("True");
    }

    public void arraysFired(){
        if(arraysCheck.isSelected())
            System.out.println("True");
    }

    public void doubleFired(){
        if(doubleCheck.isSelected())
            System.out.println("True");
    }

    public void booleanFired(){
        if(booleanCheck.isSelected())
            System.out.println("True");
    }

    public void charFired(){
        if(charCheck.isSelected())
            System.out.println("True");
    }

    public void searchFired(){
        CharSequence charSequence = searchField.getCharacters();
        System.out.println(charSequence.toString());

    }

    public void goFired(){
        System.out.println("GOOOO");
    }
}