package test;
import controll.AlgControll;

import data.Element;
import module.Module;
public class Main {

    public static void main(String[] args)  {
        Module library = new Module();
        Element element = new Element();
        //1. Enter a possitive number
        element.setSize_array(library.getInt("Enter number of array", 1, 100));
        //2. Create array by generate random integer in range
        element.setArray(library.createArray(element.getSize_array()));
        new AlgControll(element).run();

    }
}
