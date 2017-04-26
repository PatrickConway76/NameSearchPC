package com.eclipse.patrickconway;

import java.io.File;
import java.io.FileNotFoundException;
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
		File file = new File("names.txt");
		
		Scanner inputFile;
		List<String> lines = null;
		Path namesPath = Paths.get("C:\\Users\\Patrick\\Documents", "names.txt");
		Charset charset = Charset.forName("ISO-8859-1");
		
		try 
		{
			lines = Files.readAllLines(namesPath, charset);
			
			for (String line : lines)
			{
				System.out.println(line);
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		String[] crap = new String[lines.size()];
		lines.toArray(crap);
		quickSort(crap);
		//for (String element : crap)
			//System.out.print(element + " ");
		Boolean blah = search(crap, "ANN");
		
		if (blah == true)
		{
			System.out.println("sdfds");
		}
		else
		{
			System.out.println("123");
		}
	}
	
	public static void quickSort(String array[])
	{
		doQuickSort(array, 0, array.length - 1);
	}
	
	public static void doQuickSort(String array[], int start, int end)
	{
		int pivotPoint;
		
		if (start < end)
		{
			pivotPoint = partition(array, start, end);
			
			doQuickSort(array, start, pivotPoint -1);
			
			doQuickSort(array, pivotPoint + 1, end);
		}
	}
	
	private static int partition(String array[], int start, int end)
	{
		String pivotValue;
		int endOfLeftList;
		int mid;
		
		mid = (start + end) / 2;
		
		swap(array, start, mid);
		
		pivotValue = array[start];
		
		endOfLeftList = start;
		
		for (int scan = start + 1; scan <= end; scan++)
		{
			if (array[scan].compareToIgnoreCase(pivotValue) < 0)
			{
				endOfLeftList++;
				swap(array, endOfLeftList, scan);
			}
		}
		
		swap(array, start, endOfLeftList);
		
		return endOfLeftList;
	}
	
	private static void swap(String array[], int a, int b)
	{
		String temp;
		
		temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static Boolean search(String[] array, String value)
	{
		int first;
		int last;
		int middle;
		boolean found;
		
		first = 0;
		last = array.length -1;
		found = false;
		
		while (!found && first <= last)
		{
			middle = (first + last) / 2;
			
			if (array[middle] == value)
			{
				found = true;
				System.out.println("Founssssssssssssssd");
			}
			else if (array[middle].compareToIgnoreCase(value) >= 0)
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
