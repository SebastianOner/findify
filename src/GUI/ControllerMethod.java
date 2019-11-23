package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMethod {
    private Stage thisStage;

    //visibility for methods
    public CheckBox publicCheck, privateCheck, protectedCheck, ppCheck;
    //parameter types for methods
    public CheckBox intPCheck, doublePCheck, booleanPCheck, stringPCheck, charPCheck, intArrayPCheck;
    //return types for methods
    public CheckBox intRCheck, doubleRCheck, booleanRCheck, stringRCheck, charRCheck, intArrayRCheck;
    //static yes or no
    public CheckBox staticYCheck, staticNCheck;
    //method name textField
    public TextField nameField;

    public ControllerMethod() throws IOException {
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

    public Boolean publicFired(){
        if(publicCheck.isSelected()){
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
        if(protectedCheck.isSelected()){
            publicCheck.setSelected(false);
            privateCheck.setSelected(false);
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean ppFired(){
        if(ppCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean intPFired(){
        if(intPCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean doublePFired(){
        if(doublePCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean booleanPFired(){
        if(booleanPCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean stringPFired(){
        if(stringPCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean intArrayPFired(){
        if(intArrayPCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean charPFired(){
        if(charPCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean intRFired(){
        if(intRCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean doubleRFired(){
        if(doubleRCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean booleanRFired(){
        if(booleanRCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean stringRFired(){
        if(stringRCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean intArrayRFired(){
        if(intArrayRCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean charRFired(){
        if(charRCheck.isSelected()){
            return Boolean.TRUE;
        }
        else
            return null;
    }

    public Boolean staticYFired(){
        if(staticYCheck.isSelected()){
            staticNCheck.setSelected(false);
            return Boolean.TRUE;
        }
        else if((staticNCheck.isSelected()==false) && (staticYCheck.isSelected()))
            return null;
        else
            return Boolean.FALSE;
    }

    public Boolean staticNFired(){
        if(staticNCheck.isSelected()){
            staticYCheck.setSelected(false);
            return Boolean.TRUE;
        }
        else if((staticYCheck.isSelected()==false) && (staticNCheck.isSelected()==false))
            return null;
        else
            return Boolean.FALSE;
    }

    public String nameFired(){
        CharSequence charSequence = nameField.getCharacters();
        return charSequence.toString();
    }

    public void goFired(){

    }
}
