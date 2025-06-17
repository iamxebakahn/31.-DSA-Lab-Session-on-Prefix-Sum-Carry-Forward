/*Problem Description

Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Problem Constraints

1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109


Input Format

First argument contains an array A of integers of size N


Output Format

Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Example Input

Input 1:
A = [2, 1, 6, 4]
Input 2:

A = [1, 1, 1]






Example Output

Output 1:
1
Output 2:

3






Example Explanation

Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
Therefore, the required output is 1. 
Explanation 2:

Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Therefore, the required output is 3.




 */
public class Q2_DSA_Lab_Session_on_Prefix_Sum_&_Carry_Forward {
    public int solve(int[] A) {
        
        int[] pref_even=new int[A.length];
        pref_even[0]=A[0];

        for(int i=1;i<A.length;i++)
        {
            if(i%2!=0)
                pref_even[i]=pref_even[i-1];

            else 
                pref_even[i]=pref_even[i-1]+A[i];
        }


        int[] pref_odd=new int[A.length];
        pref_odd[0]=0;

        for(int i=1;i<A.length;i++)
        {
            if(i%2==0)
                pref_odd[i]=pref_odd[i-1];

            else 
                pref_odd[i]=pref_odd[i-1]+A[i];
        }

        int count=0;
        int sum_even_indice=0;
        int sum_odd_indice=0;

        for(int i=0;i<A.length;i++)
        {
            if(i==0)
                {
                    sum_even_indice=pref_odd[A.length-1]-pref_odd[0];
                    sum_odd_indice=pref_even[A.length-1]-pref_even[0];
                }

            else
            {
               sum_even_indice=pref_even[i-1]+pref_odd[A.length-1]-pref_odd[i];
               sum_odd_indice=pref_odd[i-1]+pref_even[A.length-1]-pref_even[i];
            }

            if(sum_even_indice==sum_odd_indice)
                count++;

        }

        return count;
    }
}
