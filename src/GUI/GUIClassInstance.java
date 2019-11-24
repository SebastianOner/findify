package GUI;

public class GUIClassInstance {
    //class types
    public Boolean interfaceAtt = null, abstractClassAtt = null, ENUMAtt = null,
            finalAtt = null, standardClassAtt = null;
    //modifiers
    public Boolean publicAtt = null, privateAtt = null, protectedAtt = null,
            staticAtt = null;
    //extended yes or nos
    public Boolean extendedYes = null, extendedNo = null;
    //implemented yes or nos
    public Boolean implementedYes = null, implementedNo = null;
    //generics yes or no
    public Boolean genericsYes = null, genericsNo = null;
    //attribute types
    public Boolean intAtt = null, stringAtt = null, arraysAtt = null,
            doubleAtt = null, booleanAtt = null, charAtt = null;
    //possible class name
    public String name = "";
    //possible tags
    public String tags = "";

    public String toString(GUIClassInstance classInstance) {
        String extend, implement, generic;
        if (classInstance.extendedYes != null && classInstance.extendedYes) {
            extend = "Yes";
        } else if (classInstance.extendedNo != null &&
                !classInstance.extendedNo) {
            extend = "No";
        } else {
            extend = "Not specified";
        }
        if (classInstance.implementedYes != null && classInstance.implementedYes)
            implement = "Yes";
        else if (classInstance.implementedNo != null &&
                !classInstance.implementedNo)
            implement = "No";
        else
            implement = "Not specified";
        if (classInstance.genericsYes != null && classInstance.genericsYes)
            generic = "Yes";
        else if (classInstance.genericsNo != null && !classInstance.genericsNo)
            generic = "No";
        else
            generic = "Not specified";

        return "Interface: " + classInstance.interfaceAtt +
                "\nAbstract Class: " + classInstance.abstractClassAtt +
                "\nENUM: " + classInstance.ENUMAtt + "\nFinal: " +
                classInstance.finalAtt + "\nStandard class: " +
                classInstance.standardClassAtt + "\nPublic: " +
                classInstance.publicAtt + "\nPrivate: " +
                classInstance.privateAtt + "\nProtected: " +
                classInstance.protectedAtt + "\nStatic: " +
                classInstance.staticAtt + "\nExtended?: " + extend +
                "\nImplemented?: " + implement + "\nGenerics?: " + generic +
                "\nInts: " + classInstance.intAtt + "\nStrings: " +
                classInstance.stringAtt + "\nArrays: " +
                classInstance.arraysAtt + "\nDoubles: " +
                classInstance.doubleAtt + "\nBooleans: " +
                classInstance.booleanAtt + "\nChars: " + classInstance.charAtt +
                "\nName: " + classInstance.name + "\nTags: " +
                classInstance.tags;
    }
}
/*
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
 */