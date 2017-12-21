import java.io.*;
import java.util.*;
/**
 * The program takes input of List of String student ids 
 * and generate output of Map of String to Integer
 * where the String is the student id and the Integer is the number of times the student id showed up in the input List. 
 * The program allows user to create student list from input file or read from stdin
 * @author Vu Nguyen
 * @version 1.0
 *
 */
public class ListIterationTester 
{
	public static void main(String[] args)
	{
		System.out.println("1. Create List of Student IDs from input text file.");
		System.out.println("2. Create List of Student IDs by adding manually.");
		System.out.print("Choose option: ");
		Scanner sc = new Scanner(System.in);
		String option = sc.nextLine();
		List<String> studentList = new ArrayList<String>();
		if(option.equals("1")) //Create List of Student IDs from input text file
			studentList = createListFromFile();
		else if(option.equals("2")) //Create List of Student IDs by adding manual
			studentList = createListByAdding();
		else
		{
			//If users choose invalid option. The program will terminanate
			System.out.println("Invalid option. Program is terminated.");
			System.exit(0);
		}
		sc.close();
		ListIteration li = new ListIteration();
		Map<String, Integer> hm = li.frequencyCount(studentList);
		printHashMap(hm);
		sc.close();
	}
	
	/*
	 * This method is used to print and format HashMap
	 */
	private static void printHashMap(Map<String, Integer> hm)
	{
		if(hm.isEmpty())
			System.out.println("Map is empty.");
		else
		{
			System.out.printf("%-20s %s%n","Student ID", "Frequency");
			for(Map.Entry<String, Integer> mapEntry : hm.entrySet()) 
				System.out.printf("%-20s %d%n",mapEntry.getKey(),mapEntry.getValue());
		}
	}
	
	/*
	 * This method is used to create List of String student ids from input text file
	 */
	private static List<String> createListFromFile()
	{
		System.out.print("Enter input file name: ");
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		List<String> studentList = new ArrayList<String>();
		try
		{
			sc = new Scanner(new File(fileName));
			while(sc.hasNext())
			{
				String s = sc.nextLine();
				studentList.add(s);
			}
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return studentList;
	}
	
	/*
	 * This method is used to create List of String student ids by adding from command separated by comma.
	 * The method will eliminate leading and trailing spaces between commas
	 */
	private static List<String> createListByAdding()
	{
		System.out.println("Enter Student IDs seperated by comma: ");
		Scanner sc = new Scanner(System.in);
		String studentIDString = sc.nextLine();	
		List<String> studentList = new ArrayList<String>();
		if(studentIDString.length() > 0)
			studentList = Arrays.asList(studentIDString.split("\\s*,\\s*"));
		return studentList;
	}
}
