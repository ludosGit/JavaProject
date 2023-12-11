
import java.util.ArrayList;
// arrays and arraylist are two differentthings!!
import java.util.Arrays;
// List is an interface not a class!!
// Interface is a collection of abstract methods (methods without a body)
// and constant declarations. It defines a contract that concrete classes must adhere to
//  by implementing the methods declared in the interface.
// allows for polymorphism and flexibility in the design of classes, 
// promoting code abstraction and separation of concerns.
//  Interface types are often used in scenarios where you want to define a common
//  contract for multiple classes to follow.
import java.util.List;

// code to implement a list of list
public class Trial {
    public static void main(String[] args){
        // defining some object as interface (List) is broader and more flexible than defining an ArrayList
        List<List<Integer>> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayList2 = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(1);
        b.add(2);
        b.add(2);
        arrayList.add(a);
        arrayList.add(b);
        arrayList2.add(a);
        arrayList2.add(a);
        System.out.println(arrayList);
        System.out.println(arrayList2);
        String s = new String("ciao");
        System.out.println(s);
    }
}
