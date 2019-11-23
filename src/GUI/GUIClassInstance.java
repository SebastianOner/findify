package GUI;

public class GUIClassInstance {
    //class types
    public Boolean interfaceAtt = null, abstractClassAtt = null, ENUMAtt = null, finalAtt = null, standardClassAtt = null;
    //modifiers
    public Boolean publicAtt = null, privateAtt = null, protectedAtt = null, staticAtt = null;
    //extended yes or nos
    public Boolean extendedYes = null, extendedNo = null;
    //implemented yes or nos
    public Boolean implementedYes = null, implementedNo = null;
    //generics yes or no
    public Boolean genericsYes = null, genericsNo = null;
    //attribute types
    public Boolean intAtt = null, stringAtt = null, arraysAtt = null, doubleAtt = null, booleanAtt = null, charAtt = null;
    //possible class name
    public String name = "";



    public String toString(GUIClassInstance classInstance) {
        String extend, implement, generic;
        if (classInstance.extendedYes!=null && classInstance.extendedYes) {
            extend = "Yes";
        } else if (classInstance.extendedNo!=null && !classInstance.extendedNo) {
            extend = "No";
        } else {
            extend = "Not specified";
        }
        if (classInstance.implementedYes!=null && classInstance.implementedYes)
            implement = "Yes";
        else if (classInstance.implementedNo!=null && !classInstance.implementedNo)
            implement = "No";
        else
            implement = "Not specified";
        if (classInstance.genericsYes!=null && classInstance.genericsYes)
            generic = "Yes";
        else if (classInstance.genericsNo!=null && !classInstance.genericsNo)
            generic = "No";
        else
            generic = "Not specified";

        return  ("Interface: " + classInstance.interfaceAtt +
                "\nAbstract Class: " + classInstance.abstractClassAtt +
                "\nENUM: " + classInstance.ENUMAtt +
                "\nFinal: " + classInstance.finalAtt +
                "\nStandard class: " + classInstance.standardClassAtt +
                "\nPublic: " + classInstance.publicAtt +
                "\nPrivate: " + classInstance.privateAtt +
                "\nProtected: " + classInstance.protectedAtt +
                "\nStatic: " + classInstance.staticAtt +
                "\nExtended?: " + extend +
                "\nImplemented?: " + implement +
                "\nGenerics?: " + generic +
                "\nInts: " + classInstance.intAtt +
                "\nStrings: " + classInstance.stringAtt +
                "\nArrays: " + classInstance.arraysAtt +
                "\nDoubles: " + classInstance.doubleAtt +
                "\nBooleans: " + classInstance.booleanAtt +
                "\nChars: " + classInstance.charAtt +
                "\nName: " + classInstance.name);
    }
}