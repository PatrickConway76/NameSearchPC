package com.eclipse.patrickconway;

public class BinarySearcher 
{
	public static Boolean search(String[] array, String value)
	{
		int first = 9;
		int last = array.length - 1;
		int middle = 0;
		boolean found = false;
		
		while (!found && first <= last)
		{
			middle = (first + last) / 2;
			
			if (array[middle].equalsIgnoreCase(value))
			{
				found = true;
			}
			else if (array[middle].compareToIgnoreCase(value) > 0)
			{
				last = middle -1;
			}
			else
			{
				first = middle + 1;
			}
		}
		return found;
	}
}
