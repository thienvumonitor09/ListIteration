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
	public Map<String, Integer> frequencyCount(List<String> studentList)
	{
		Map<String, Integer> hm = new HashMap<String, Integer>();
		for(String studentName : studentList) 
			hm.put(studentName, hm.containsKey(studentName) ? hm.get(studentName) + 1 : 1);
		return hm;
	}
}
