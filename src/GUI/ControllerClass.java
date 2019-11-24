package GUI;

import SearchObjects.ClassObject;
import SearchObjects.FieldObject;
import SearchObjects.SearchObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ControllerClass {
    private ArrayList<ClassObject> projectClasses;

    private Stage thisStage;
    //yes no checkbox variables
    public CheckBox extendedYCheck, extendedNCheck, implementedYCheck, implementedNCheck, genericsYCheck, genericsNCheck;
    //rest of the check box variables
    public CheckBox publicCheck, privateCheck, protectedCheck, staticCheck, intCheck, stringCheck, doubleCheck, booleanCheck,
            charCheck, arraysCheck, abstractCheck, interfaceCheck, ENUMCheck, finalCheck, classCheck;
    public TextField searchField, tagsField;

    //initializes the controller for the class stage
    public ControllerClass(ArrayList<ClassObject> projectClasses) throws IOException {
        thisStage = new Stage();
        this.projectClasses = projectClasses;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("classScene.fxml"));
            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));
            thisStage.setTitle("findify");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    }

    public Boolean interfaceFired() {
        if (interfaceCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean abstractFired() {
        if (abstractCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean ENUMFired() {
        if (ENUMCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean finalFired() {
        if (finalCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean standardClassFired() {
        if (classCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean publicFired() {
        if (publicCheck.isSelected()) {
            privateCheck.setSelected(false);
            protectedCheck.setSelected(false);
            return Boolean.TRUE;
        } else
            return null;
    }

    public Boolean privateFired() {
        if (privateCheck.isSelected()) {
            publicCheck.setSelected(false);
            protectedCheck.setSelected(false);
            return Boolean.TRUE;
        } else
            return null;

    }

    public Boolean protectedFired() {
        if (protectedCheck.isSelected()) {
            privateCheck.setSelected(false);
            publicCheck.setSelected(false);
            return Boolean.TRUE;
        } else
            return null;
    }

    public Boolean staticFired() {
        if (staticCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean extendedYFired() {
        if (extendedYCheck.isSelected()) {
            extendedNCheck.setSelected(false);
            return Boolean.TRUE;
        } else if ((extendedNCheck.isSelected() == false) && (extendedYCheck.isSelected() == false))
            return null;
        else
            return Boolean.FALSE;
    }

    public Boolean extendedNFired() {
        if (extendedNCheck.isSelected()) {
            extendedYCheck.setSelected(false);
            return Boolean.FALSE;
        } else if ((extendedYCheck.isSelected() == false) && (extendedNCheck.isSelected() == false))
            return null;
        else
            return Boolean.TRUE;
    }

    public Boolean implementedYFired() {
        if (implementedYCheck.isSelected()) {
            implementedNCheck.setSelected(false);
            return Boolean.TRUE;
        } else if (extendedNCheck.isSelected() == false && extendedYCheck.isSelected() == false)
            return null;
        else
            return Boolean.FALSE;
    }

    public Boolean implementedNFired() {
        if (implementedNCheck.isSelected()) {
            implementedYCheck.setSelected(false);
            return Boolean.FALSE;
        } else if (extendedNCheck.isSelected() == false && extendedYCheck.isSelected() == false)
            return null;
        else
            return Boolean.TRUE;
    }

    public Boolean genericYFired() {
        if (genericsYCheck.isSelected()) {
            genericsNCheck.setSelected(false);
            return Boolean.TRUE;
        } else if ((genericsYCheck.isSelected() == false) && (genericsNCheck.isSelected() == false))
            return null;
        else
            return Boolean.FALSE;
    }

    public Boolean genericNFired() {
        if (genericsNCheck.isSelected()) {
            genericsYCheck.setSelected(false);
            return Boolean.FALSE;
        } else if ((genericsNCheck.isSelected() == false) && genericsYCheck.isSelected() == false)
            return null;
        else
            return Boolean.TRUE;
    }

    public Boolean intFired() {
        if (intCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean stringFired() {
        if (stringCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;

    }

    public Boolean arraysFired() {
        if (arraysCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean doubleFired() {
        if (doubleCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean booleanFired() {
        if (booleanCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public Boolean charFired() {
        if (charCheck.isSelected())
            return Boolean.TRUE;
        else
            return null;
    }

    public String searchFired() {
        CharSequence charSequence = searchField.getCharacters();
        return charSequence.toString();
    }

    public String tagsFired() {
        CharSequence charSequence = tagsField.getCharacters();
        return charSequence.toString();
    }

    public void goFired() {
        String name = searchFired();
        Boolean isChild = extendedYFired();
        Boolean isImplemented = implementedYFired();
        Boolean isGeneric = genericYFired();

        Boolean isInterface = interfaceFired();
        Boolean isENUM = ENUMFired();
        Boolean isDefaultClass = standardClassFired();

        Boolean isFinal = finalFired();
        Boolean isAbstract = abstractFired();
        //access modifiers
        Boolean isPublic = publicFired();
        Boolean isPrivate = privateFired();
        Boolean isProtected = protectedFired();

        List<FieldObject> attributeList = new ArrayList<FieldObject>();
        if (intFired() != null) {
            attributeList.add(new FieldObject("int"));
        }
        if (stringFired() != null) {
            attributeList.add(new FieldObject("String"));
        }
        if (arraysFired() != null) {
            attributeList.add(new FieldObject("int[]"));
        }
        if (doubleFired() != null) {
            attributeList.add(new FieldObject("double"));
        }
        if (booleanFired() != null) {
            attributeList.add(new FieldObject("boolean"));
        }
        if (charFired() != null) {
            attributeList.add(new FieldObject("char"));
        }

        Boolean isStatic = staticFired();
        SearchObject.AccessModifier am;
        if (isProtected != null) {
            am = SearchObject.AccessModifier.PROTECTED;
        } else if (isPublic != null) {
            am = SearchObject.AccessModifier.PUBLIC;
        } else if (isPrivate != null) {
            am = SearchObject.AccessModifier.PRIVATE;
        } else {
            am = SearchObject.AccessModifier.DEFAULT;
        }

        ClassObject.InheritanceType inh;
        if (isFinal != null) {
            inh = ClassObject.InheritanceType.FINAL;
        } else if (isAbstract != null) {
            inh = ClassObject.InheritanceType.ABSTRACT;
        } else {
            inh = ClassObject.InheritanceType.DEFAULT;
        }

        ClassObject.ClassType type;
        if (isInterface != null) {
            type = ClassObject.ClassType.INTERFACE;
        } else if (isENUM != null) {
            type = ClassObject.ClassType.ENUM;
        } else {
            type = ClassObject.ClassType.DEFAULT;
        }

        ClassObject CO = new ClassObject(name, am, isChild, isGeneric, isImplemented, inh, type, attributeList);

        Score.Search.getBests(projectClasses, CO);

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

        thisStage.close();
    }
}