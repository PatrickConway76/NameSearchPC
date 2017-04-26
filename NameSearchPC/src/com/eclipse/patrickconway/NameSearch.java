package com.eclipse.patrickconway;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class NameSearch {

	public static void main(String[] args)
	{
		
		String name;
		Boolean keepGoing = true;
		Scanner sc = new Scanner(System.in);
		List<String> lines = null; // The list to read lines from the text file into
		Path namesPath = Paths.get("src\\com\\eclipse\\patrickconway\\names.txt");
		Charset charset = Charset.forName("ISO-8859-1");
		
		try 
		{
			lines = Files.readAllLines(namesPath, charset); // Grabs all lines from the txt file

		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		
		// Creates an array and converts the list object to an array
		String[] listOfNames = new String[lines.size()];
		lines.toArray(listOfNames);
		
		// Sorts the names alphabetically
		QuickSorter.quickSort(listOfNames);
		
		while (keepGoing == true)
		{
		
			System.out.print("Enter a name to see if it's on the list or enter 'exit' to quit: ");
			name = sc.nextLine();
			
			if (name.equalsIgnoreCase("exit"))
			{
				keepGoing = false;
			}
			else
			{
				// Searches the names and assigns the result to a boolean
				Boolean containsName = BinarySearcher.search(listOfNames, name);
				
				if (containsName == true)
				{
					System.out.println("The name is on the list.");
				}
				else
				{
					System.out.println("The name is not on the list.");
				}
			}
		}
		System.exit(0);
	}
}
