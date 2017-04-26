package com.eclipse.patrickconway;

public class QuickSorter 
{
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
			if (array[scan].compareToIgnoreCase(pivotValue) > 0)
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
}
