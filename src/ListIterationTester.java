import java.io.*;
import java.util.*;

public class ListIterationTester 
{
	
	public static void main(String[] args)
	{

		//Create List of Student IDs from input text file
		List<String> studentList = createListFromFile("input.txt");
		
		ListIteration li = new ListIteration();
		Map<String, Integer> hm = li.frequencyCount(studentList);
		printHashMap(hm);	
	}
	
	private static void printHashMap(Map<String, Integer> hm)
	{
		if(hm.isEmpty())
			System.out.println("Map is empty");
		else
		{
			System.out.println("Student ID Frequency");
			for(Map.Entry<String, Integer> mapEntry : hm.entrySet()) 
				System.out.println(mapEntry.getKey()+" " + mapEntry.getValue());
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
}
