import java.util.Scanner;
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
    }
}
