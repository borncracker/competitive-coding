package test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
public class Guru99VariableMetaDataTest {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        // Create Class object for Guru99VariableMetaData.class
        Guru99VariableMetaData guru99ClassVar = new Guru99VariableMetaData();
        Class guru99ClassObjVar = guru99ClassVar.getClass();

        // Get the metadata of all the fields of the class Guru99VariableMetaData
        Field[] guru99Field1= guru99ClassObjVar.getDeclaredFields();

        // Print name, datatypes, access modifiers and values of the varibales of the specified class
        for(Field field : guru99Field1) {
            System.out.println("Variable name : "+field.getName());
            System.out.println("Datatypes of the variable :"+field.getType());

            int guru99AccessModifiers = field.getModifiers();
            System.out.println("Access Modifiers of the variable : "+Modifier.toString(guru99AccessModifiers));
            System.out.println("Value of the variable : "+field.get(guru99ClassVar));
            System.out.println();
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *") ;
        }
    }
}
