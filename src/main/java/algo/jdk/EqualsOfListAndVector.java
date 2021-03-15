package algo.jdk;

import java.util.ArrayList;
import java.util.Vector;

public class EqualsOfListAndVector {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("this is list");
        Vector<String> vector = new Vector<>();
        vector.add("this is list");
        System.out.println(list.equals(vector));  // true
    }
}
