package MergeSecuencial;

import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yazminurzuac
 */
/* Java program for Merge Sort */
class MergeSort
{
// Merges two subarrays of arr[].
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]
void merge(int arr[], int l, int m, int r)
{
// Find sizes of two subarrays to be merged
int n1 = m - l + 1;
int n2 = r - m;

/* Create temp arrays */
int L[] = new int [n1];
int R[] = new int [n2];

/*Copy data to temp arrays*/
for (int i=0; i<n1; ++i)
L[i] = arr[l + i];
for (int j=0; j<n2; ++j)
R[j] = arr[m + 1+ j];


/* Merge the temp arrays */

// Initial indexes of first and second subarrays
int i = 0, j = 0;

// Initial index of merged subarray array
int k = l;
while (i < n1 && j < n2)
{
if (L[i] <= R[j])
{
arr[k] = L[i];
i++;
}
else
{
arr[k] = R[j];
j++;
}
k++;
}

/* Copy remaining elements of L[] if any */
while (i < n1)
{
arr[k] = L[i];
i++;
k++;
}

/* Copy remaining elements of R[] if any */
while (j < n2)
{
arr[k] = R[j];
j++;
k++;
}
}

// Main function that sorts arr[l..r] using
// merge()
void sort(int arr[], int l, int r)
{
if (l < r)
{
// Find the middle point
int m = (l+r)/2;

// Sort first and second halves
sort(arr, l, m);
sort(arr , m+1, r);

// Merge the sorted halves
merge(arr, l, m, r);
}
}

/* A utility function to print array of size n */
static void printArray(int arr[])
{
int n = arr.length;
for (int i=0; i<n; ++i)
System.out.print(arr[i] + " ");
System.out.println();
}

// Driver method
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
int num;

        System.out.print("Ingrese la cantidad de números aleatorios que desea generar: ");
        int n = sc.nextInt();

        int[] arreglo = new int[n];
        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            arreglo[i] = rnd.nextInt(100);
        }

        System.out.println("Los números aleatorios generados son:");
        for (int i = 0; i < n; i++) {
            System.out.println(arreglo[i]);
        }


MergeSort obe = new MergeSort();
obe.sort(arreglo, 0, arreglo.length-1);


System.out.println("\nArray con MergeSort: ");
printArray(arreglo);
}
}
