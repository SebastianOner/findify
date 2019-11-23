package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    public CheckBox extendedYCheck, extendedNCheck, implementedYCheck, implementedNCheck, genericsYCheck, genericsNCheck;
    //rest of the check box variables
    public CheckBox publicCheck, privateCheck, protectedCheck, staticCheck, intCheck, stringCheck, doubleCheck, booleanCheck,
            charCheck, arraysCheck, abstractCheck, interfaceCheck, ENUMCheck, finalCheck, classCheck;
    public TextField searchField;
    public Button goButton;


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

    public Boolean interfaceFired(){
        if(interfaceCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean abstractFired(){
        if(abstractCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean ENUMFired(){
        if(ENUMCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean finalFired(){
        if(finalCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean standardClassFired(){
        if(classCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean publicFired(){
        if(publicCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean privateFired(){
        if(privateCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;

    }

    public Boolean protectedFired(){
        if(protectedCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean staticFired(){
        if(staticCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean extendedYFired(){
        if(extendedYCheck.isSelected()){
            extendedNCheck.setSelected(false);
        }
        return Boolean.TRUE;
    }

    public void extendedNFired(){
        if(extendedNCheck.isSelected()){
            extendedYCheck.setSelected(false);
        }
    }

    public void implementedYFired(){
        if(implementedYCheck.isSelected())
            implementedNCheck.setSelected(false);
    }

    public void implementedNFired(){
        if(implementedNCheck.isSelected())
            implementedYCheck.setSelected(false);
    }

    public void genericYFired(){
        if(genericsYCheck.isSelected())
            genericsNCheck.setSelected(false);
    }

    public void genericNFired(){
        if(genericsNCheck.isSelected())
            genericsYCheck.setSelected(false);
    }

    public Boolean intFired(){
        if(intCheck.isSelected())
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
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
        GUIClassInstance classInstance = new GUIClassInstance();
        goButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                classInstance.interfaceAtt = interfaceFired();
            }
        });

        classInstance.toString();
    }


}