/**
 * author: Vu Nguyen
 * can use input
 * can add manual
 * case: long file
 * long name
 * 
 * The input is a List of String student ids, 
 * and the output is a Map of String to Integer where the String is the student id 
 * and the Integer is the number of times the student id showed up in the input List
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListIteration 
{
	private static Map<String, Integer> frequencyCount(List<String> studentList)
	{
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for(String studentName : studentList) 
			hm.put(studentName, hm.containsKey(studentName) ? hm.get(studentName) + 1 : 1);
		
		return hm;
	}
	
	
	public static void main(String[] args)
	{
		//Create List 
		List<String> studentList = new ArrayList<String>();
		
		try
		{
			Scanner sc = new Scanner(new File("input.txt"));
			while(sc.hasNext())
			{
				String s = sc.nextLine();
				studentList.add(s);
				//System.out.println(s);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		Map<String, Integer> hm = frequencyCount(studentList);
		//Map<String, Integer> hm = new HashMap<String, Integer>();
		if(hm.isEmpty())
			System.out.println("Map is empty");
		else
		{
			for(Map.Entry<String, Integer> mapEntry : hm.entrySet()) 
			{
				System.out.println(mapEntry.getKey()+" " + mapEntry.getValue());
			}
		}
		
	}
	

}
