package cs2400project1;

import java.util.Arrays;

public class ArrayBagTest 
{
    public static void main(String[] args)
    {
        UnionTestOne();
        // UnionTestTwo();
        
        IntersectionTestOne();
        // IntersectionTestTwo();
        
        // DifferenceTestOne();
        // DifferenceTestTwo();
    }

    public static void UnionTestOne()
    {
        System.out.println("-----------------------");
        System.out.println("START OF UNION TEST ONE");
        
        System.out.println();
        
        BagInterface<String> bag1 = new ResizeableArrayBag<String>();
        BagInterface<String> bag2 = new ResizeableArrayBag<String>();

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        System.out.println("Bag One: " + Arrays.toString(bag1.toArray()));
        
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        
        System.out.println("Bag Two: " + Arrays.toString(bag2.toArray()));

        BagInterface<String> bag3 = bag1.union(bag2);

        System.out.println();
        
        System.out.println("Frequency of a: " + bag3.getFrequencyOf("a"));
        System.out.println("Frequency of b: " + bag3.getFrequencyOf("b"));
        System.out.println("Frequency of c: " + bag3.getFrequencyOf("c"));
        System.out.println("Frequency of d: " + bag3.getFrequencyOf("d"));
        System.out.println("Frequency of e: " + bag3.getFrequencyOf("e"));
        
        System.out.println();
        
        System.out.println("Union Bag: " + Arrays.toString(bag3.toArray()));
        
        System.out.println();
        
        System.out.println("END OF UNION TEST ONE");
        System.out.println("---------------------");
    }

    public static void UnionTestTwo()
    {
        System.out.println("Union Test Two");
        
        BagInterface<String> bag1 = new ResizeableArrayBag<>();
        BagInterface<String> bag2 = new ResizeableArrayBag<>();

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        BagInterface<String> bag3 = bag1.union(bag2);

        System.out.println("Frequency of a: " + bag3.getFrequencyOf("a"));
        System.out.println("Frequency of b: " + bag3.getFrequencyOf("b"));
        System.out.println("Frequency of c: " + bag3.getFrequencyOf("c"));
        System.out.println("Frequency of d: " + bag3.getFrequencyOf("d"));
        System.out.println("Frequency of e: " + bag3.getFrequencyOf("e"));

        System.out.println(Arrays.toString(bag3.toArray()));
    }

    public static void IntersectionTestOne()
    {
    	System.out.println("------------------------------");
        System.out.println("START OF INTERSECTION TEST ONE");
        
        System.out.println();
        
        BagInterface<String> bag1 = new ResizeableArrayBag<>();
        BagInterface<String> bag2 = new ResizeableArrayBag<>();

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        
        System.out.println("Bag One: " + Arrays.toString(bag1.toArray()));

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        
        System.out.println("Bag Two: " + Arrays.toString(bag2.toArray()));
        
        System.out.println();

        BagInterface<String> bag3 = bag1.intersection(bag2);

        System.out.println("Frequency of a: " + bag3.getFrequencyOf("a"));
        System.out.println("Frequency of b: " + bag3.getFrequencyOf("b"));
        System.out.println("Frequency of c: " + bag3.getFrequencyOf("c"));
        System.out.println("Frequency of d: " + bag3.getFrequencyOf("d"));
        System.out.println("Frequency of e: " + bag3.getFrequencyOf("e"));

        System.out.println("Intersection Bag: " + Arrays.toString(bag3.toArray()));
        
        System.out.println();
        
        System.out.println("END OF INTERSECTION TEST ONE");
        System.out.println("----------------------------");
        
    }

    public static void IntersectionTestTwo()
    {
        System.out.println("Intersection Test Two");

        BagInterface<String> bag1 = new ResizeableArrayBag<>();
        BagInterface<String> bag2 = new ResizeableArrayBag<>();

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        BagInterface<String> bag3 = bag1.intersection(bag2);

        System.out.println("Frequency of a: " + bag3.getFrequencyOf("a"));
        System.out.println("Frequency of b: " + bag3.getFrequencyOf("b"));
        System.out.println("Frequency of c: " + bag3.getFrequencyOf("c"));
        System.out.println("Frequency of d: " + bag3.getFrequencyOf("d"));
        System.out.println("Frequency of e: " + bag3.getFrequencyOf("e"));

        System.out.println(Arrays.toString(bag3.toArray()));
    }

    public static void DifferenceTestOne()
    {
        System.out.println("Difference Test One");

        BagInterface<String> bag1 = new ResizeableArrayBag<>();
        BagInterface<String> bag2 = new ResizeableArrayBag<>();

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        BagInterface<String> bag3 = bag1.difference(bag2);

        System.out.println("Frequency of a: " + bag3.getFrequencyOf("a"));
        System.out.println("Frequency of b: " + bag3.getFrequencyOf("b"));
        System.out.println("Frequency of c: " + bag3.getFrequencyOf("c"));
        System.out.println("Frequency of d: " + bag3.getFrequencyOf("d"));
        System.out.println("Frequency of e: " + bag3.getFrequencyOf("e"));

        System.out.println(Arrays.toString(bag3.toArray()));
    }

    public static void DifferenceTestTwo()
    {
        System.out.println("Difference Test Two");

        BagInterface<String> bag1 = new ResizeableArrayBag<>();
        BagInterface<String> bag2 = new ResizeableArrayBag<>();

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        BagInterface<String> bag3 = bag1.difference(bag2);

        System.out.println("Frequency of a: " + bag3.getFrequencyOf("a"));
        System.out.println("Frequency of b: " + bag3.getFrequencyOf("b"));
        System.out.println("Frequency of c: " + bag3.getFrequencyOf("c"));
        System.out.println("Frequency of d: " + bag3.getFrequencyOf("d"));
        System.out.println("Frequency of e: " + bag3.getFrequencyOf("e"));

        System.out.println(Arrays.toString(bag3.toArray()));
    }
}
