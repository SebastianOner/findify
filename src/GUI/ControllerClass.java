package GUI;

import SearchObjects.ClassObject;
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
        if(publicCheck.isSelected()) {
            privateCheck.setSelected(false);
            protectedCheck.setSelected(false);
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean privateFired(){
        if(privateCheck.isSelected()){
            publicCheck.setSelected(false);
            protectedCheck.setSelected(false);
            return Boolean.TRUE;
        }
        else
            return null;

    }

    public Boolean protectedFired(){
        if(protectedCheck.isSelected()) {
            privateCheck.setSelected(false);
            publicCheck.setSelected(false);
            return Boolean.TRUE;
        }
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
            return Boolean.TRUE;
        }
        else if((extendedNCheck.isSelected()==false) && (extendedYCheck.isSelected()==false))
            return null;
        else
            return Boolean.FALSE;
    }

    public Boolean extendedNFired(){
        if(extendedNCheck.isSelected()){
            extendedYCheck.setSelected(false);
            return Boolean.FALSE;
        }
        else if((extendedYCheck.isSelected()==false)&&(extendedNCheck.isSelected()==false))
            return null;
        else
            return Boolean.TRUE;
    }

    public Boolean implementedYFired(){
        if(implementedYCheck.isSelected()){
            implementedNCheck.setSelected(false);
            return Boolean.TRUE;
        }
        else if(extendedNCheck.isSelected()==false && extendedYCheck.isSelected()==false)
            return null;
        else
            return Boolean.FALSE;
    }

    public Boolean implementedNFired(){
        if(implementedNCheck.isSelected()){
            implementedYCheck.setSelected(false);
            return Boolean.FALSE;
        }
        else if(extendedNCheck.isSelected()==false && extendedYCheck.isSelected()==false)
            return null;
        else
            return Boolean.TRUE;
    }

    public Boolean genericYFired(){
        if(genericsYCheck.isSelected()){
            genericsNCheck.setSelected(false);
            return Boolean.TRUE;
        }
        else if((genericsYCheck.isSelected()==false)&&(genericsNCheck.isSelected()==false))
            return null;
        else
            return Boolean.FALSE;
    }

    public Boolean genericNFired(){
        if(genericsNCheck.isSelected()){
            genericsYCheck.setSelected(false);
            return Boolean.FALSE;
        }
        else if((genericsNCheck.isSelected()==false)&&genericsYCheck.isSelected()==false)
            return null;
        else
            return Boolean.TRUE;
    }

    public Boolean intFired(){
        if(intCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean stringFired(){
        if(stringCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;

    }

    public Boolean arraysFired(){
        if(arraysCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean doubleFired(){
        if(doubleCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean booleanFired(){
        if(booleanCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean charFired(){
        if(charCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public String searchFired(){
        CharSequence charSequence = searchField.getCharacters();
        return charSequence.toString();
    }

    public void goFired(){

        //ClassObject CO = new ClassObject()

        GUIClassInstance classInstance = new GUIClassInstance();
        classInstance.interfaceAtt = interfaceFired();
        classInstance.abstractClassAtt = abstractFired();
        classInstance.ENUMAtt = ENUMFired();
        classInstance.finalAtt = finalFired();
        classInstance.standardClassAtt = standardClassFired();
        classInstance.publicAtt = publicFired();
        classInstance.privateAtt = privateFired();
        classInstance.protectedAtt = protectedFired();
        classInstance.staticAtt = staticFired();
        classInstance.extendedYes = extendedYFired();
        classInstance.extendedNo = extendedNFired();
        classInstance.implementedYes = implementedYFired();
        classInstance.implementedNo = implementedNFired();
        classInstance.genericsYes = genericYFired();
        classInstance.genericsNo = genericNFired();
        classInstance.intAtt = intFired();
        classInstance.stringAtt = stringFired();
        classInstance.doubleAtt = doubleFired();
        classInstance.charAtt = charFired();
        classInstance.arraysAtt = arraysFired();
        classInstance.booleanAtt = booleanFired();
        classInstance.name = searchFired();


        System.out.println(classInstance.toString(classInstance));
    }
}