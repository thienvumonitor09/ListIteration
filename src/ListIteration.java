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
import java.util.*;

public class ListIteration 
{
	/**
	 * This method is used to generate Map of String to Integer from List of String student ids
	 * The map will ignore null or empty elements from the List
	 * If the List is empty or null, an empty map will be returned.
	 * @param studentList List of String student ids
	 * @return Map<String, Integer> This is the Map of String to Integer
	 */
	public Map<String, Integer> frequencyCount(List<String> studentList) 
	{
		Map<String, Integer> hm = new HashMap<String, Integer>();
		if(studentList == null)
			System.out.println("List is null");
		else
		{
			for(String studentName : studentList) 
			{
				if(studentName != null) // not null
				{
					studentName = studentName.trim(); // studentIDs ignore leading and trailing spaces
					if(studentName.length() > 0)
						hm.put(studentName, hm.containsKey(studentName) ? hm.get(studentName) + 1 : 1);
				}
			}
		}
		return hm;
	}
}
