import java.io.*;
import java.util.*;

public class ListIterationTester 
{
	private static Scanner sc = new Scanner(System.in); 
	public static void main(String[] args)
	{
		System.out.println("1. Create List of Student IDs from input text file.");
		System.out.println("2. Create List of Student IDs by adding manually.");
		System.out.print("Choose option: ");
		String option = sc.nextLine();
		List<String> studentList = new ArrayList<String>();
		
		if(option.equals("1")) //Create List of Student IDs from input text file
			studentList = createListFromFile("input.txt");
		else if(option.equals("2")) //Create List of Student IDs by adding manual
			studentList = createListByAdding();
		else
		{
			System.out.println("Invalid option. Program is terminated.");
			System.exit(0);
		}
			
		ListIteration li = new ListIteration();
		Map<String, Integer> hm = li.frequencyCount(studentList);
		printHashMap(hm);	
		sc.close();
	}
	
	private static void printHashMap(Map<String, Integer> hm)
	{
		if(hm.isEmpty())
			System.out.println("Map is empty");
		else
		{
			System.out.printf("%-20s %s%n","Student ID", "Frequency");
			for(Map.Entry<String, Integer> mapEntry : hm.entrySet()) 
				System.out.printf("%-20s %d%n",mapEntry.getKey(),mapEntry.getValue());
		}
	}
	
	private static List<String> createListFromFile(String fileName)
	{
		List<String> studentList = new ArrayList<String>();
		try
		{
			Scanner sc = new Scanner(new File(fileName));
			while(sc.hasNext())
			{
				String s = sc.nextLine();
				studentList.add(s);
			}
			sc.close();
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return studentList;
	}
	
	private static List<String> createListByAdding()
	{
		System.out.println("Enter Student IDs seperated by comma: ");
		String studentIDString = sc.nextLine();	
		List<String> studentList = Arrays.asList(studentIDString.split("\\s*,\\s*"));
		return studentList;
	}
}
