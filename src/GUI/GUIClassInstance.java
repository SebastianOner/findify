package GUI;

public class GUIClassInstance {
    //class types
    public Boolean interfaceAtt=null, abstractClassAtt=null, ENUMAtt=null, finalAtt=null, standardClassAtt=null;
    //modifiers
    public Boolean publicAtt=null, privateAtt=null, protectedAtt=null, staticAtt=null;
    //extended yes or nos
    public Boolean extendedYes=null, extendedNo=null;
    //implemented yes or nos
    public Boolean implementedYes=null, implementedNo=null;
    //generics yes or no
    public Boolean genericsYes=null, genericsNo=null;
    //attribute types
    public Boolean intAtt=null, stringAtt=null, arraysAtt=null, doubleAtt=null, booleanAtt=null, charAtt=null;
    //possible class name
    public String name=null;

    public String toString(){
        String extend, implement, generic;
        if(extendedYes.booleanValue() == true)
            extend = "Yes";
        else if(extendedNo.booleanValue() == false)
            extend = "No";
        else
            extend = "Not specified";
        if(implementedYes.booleanValue() == true)
            implement = "Yes";
        else if(implementedNo.booleanValue() == false)
            implement = "No";
        else
            implement = "Not specified";
        if(genericsYes.booleanValue() == true)
            generic = "Yes";
        else if(genericsNo.booleanValue() == false)
            generic = "No";
        else
            generic = "Not specified";

        return  "Interface: " + interfaceAtt.toString() +
                "\nAbstract Class: " + abstractClassAtt.toString() +
                "\nENUM: " + ENUMAtt.toString() +
                "\nFinal: " + finalAtt.toString() +
                "\nStandard class: " + standardClassAtt.toString() +
                "\nPublic: " + publicAtt.toString() +
                "\nPrivate: " + privateAtt.toString() +
                "\nProtected: " + protectedAtt.toString() +
                "\nStatic: " + staticAtt.toString() +
                "\nExtended?: " + extend +
                "\nImplemented?: " + implement +
                "\nGenerics?: " + generic +
                "\nInts: " + intAtt.toString() +
                "\nStrings: " + stringAtt.toString() +
                "\nArrays: " + arraysAtt.toString() +
                "\nDoubles: " + doubleAtt.toString() +
                "\nBooleans: " + booleanAtt.toString() +
                "\nChars: " + charAtt.toString();
    }

}
