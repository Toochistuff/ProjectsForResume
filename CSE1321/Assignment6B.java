/*
Class: CSE 1321L
Section: Java
Term: FALL 2022
Instructor: Surya Praveen Adivi
Name: Tochi Okwudire
Lab#: Assignment6B
*/
import java.util.Scanner;
public class Assignment6B {
    static String WhatsmyType(int data)
    {
        return "'"+data+"' is a int value!";
    }

    static String WhatsmyType(String data)
    {
        return "'"+data+"' is a String value!";
    }

    static String WhatsmyType(float data)
    {
        return "'"+data+"' is a float value!";
    }

    static String WhatsmyType(char data)
    {
        return "'"+data+"' is a char value!";
    }

    static String WhatsmyType(boolean data)
    {
        return "'"+data+"' is a boolean value!";
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int i;
        String s;
        float f;
        char c;
        boolean b;

        System.out.println("[what's my datatype?]\n");
        System.out.print("Enter an int: ");
        i=sc.nextInt();
        System.out.print("Enter an String: ");
        s=sc.next();
        System.out.print("Enter an float: ");
        f=sc.nextFloat();
        System.out.print("Enter an char: ");
        c=sc.next().charAt(0);
        System.out.print("Enter an boolean: ");
        b=sc.nextBoolean();


        System.out.print("\nWhat dataType do you want to check? ");
        String choice=sc.next();

        switch(choice)
        {
            case "int":
                System.out.println(WhatsmyType(i));
                break;
            case  "string":
                System.out.println(WhatsmyType(s));
                break;
            case "float":
                System.out.println(WhatsmyType(f));
                break;
            case "char":
                System.out.println(WhatsmyType(c));
                break;
            case "boolean":
                System.out.println(WhatsmyType(b));
                break;
        }

    }
}


