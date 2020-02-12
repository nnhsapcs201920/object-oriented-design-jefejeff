import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 * A class to hold information about a person
 *
 * @author jcheng3 & eemilyshih
 * @version 10 February 2020
 */
public class Person implements Comparable<Person>
{
    private String name;

    public Person(String name1)
    {
        name = name1; 
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(Person other)
    {
        return this.name.compareTo(other.name);
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Insert the name of a person.");
        String s1 = s.next();
        Person p1 = new Person(s1);
        System.out.println("Insert the name of a person");
        String s2 = s.next();
        Person p2 = new Person(s2);
        System.out.println("Insert the name of a person.");
        String s3 = s.next();
        Person p3 = new Person(s3);
        System.out.println("Insert the name of a person");
        String s4 = s.next();
        Person p4 = new Person(s4);
        System.out.println("Insert the name of a person.");
        String s5 = s.next();
        Person p5 = new Person(s5);
        System.out.println("Insert the name of a person");
        String s6 = s.next();
        Person p6 = new Person(s6);
        System.out.println("Insert the name of a person.");
        String s7 = s.next();
        Person p7 = new Person(s7);
        System.out.println("Insert the name of a person");
        String s8 = s.next();
        Person p8 = new Person(s8);
        System.out.println("Insert the name of a person.");
        String s9 = s.next();
        Person p9 = new Person(s9);
        System.out.println("Insert the name of a person");
        String s10 = s.next();
        Person p10 = new Person(s10);

        ArrayList<Person> people = new ArrayList<Person>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        people.add(p6);
        people.add(p7);
        people.add(p8);
        people.add(p9);
        people.add(p10);
        for (Person a : people)
        {
            System.out.print(a.getName());
        }
        System.out.println();
        Collections.sort(people);
        for (Person a : people)
        {
            System.out.print(a.getName());
        }
    }
}
