/*Problem Description

You are given:
An integer array A representing the array of numbers of size N.
A 2D array B of size Q, where each row B[i] contains two integers B[i][0] and B[i][1], representing the range [L, R].

For each query in B, calculate the sum of elements in A at odd indices within the specified range [L, R] and return the results as an array.


Problem Constraints

1 <= N <= 10^5
-10^5 <= A[i] <= 10^5
1 <= Q <= 10^5
0 <= B[i][0], B[i][1] < N
B[i][0] <= B[i][1].


Input Format

First Argument A, is a list of integers representing the array.
Second Argument B, is a 2D list where each sublist B[i]=[L,R] contains two integers L and R, representing the range for the query.


Output Format

Return a list of integers where each integer is the result of the sum of elements at odd indices in the range [L, R] for each query.


Example Input

Input 1:
A = [2, 8, 3, 9, 15]
B = [ [1, 4], 
      [0, 2], 
      [2, 3] ]
Input 2:
A = [5, 15, 25, 35, 45]
B = [ [2, 2], 
      [2, 4] ]


Example Output

Output 1:
[17, 8, 9]
Output 2:
[0, 35]


Example Explanation

Explanation 1:
Query 1: [1, 4] -> Sum = A[1] + A[3] = 8 + 9 = 17
Query 2: [0, 2] -> Sum = A[1] = 8
Query 3: [2, 3] -> Sum = A[3] = 9

Thus [17, 8, 9] is the Result.
Explanation 2:
Query 1: [2, 2] -> Sum = 0
Query 2: [2, 4] -> Sum = A[3] = 35

Thus [0, 35] is the result. */
public class Q4_DSA_Lab_Session_on_Prefix_Sum_&_Carry_Forward {
    public int[] sumOfOddIndexedElements(int[] A, int[][] B) {
        
        int[] ans=new int[B.length];

        int[] pref_odd=new int[A.length];
        pref_odd[0]=0;

        for(int i=1;i<A.length;i++)
        {
            if(i%2==0)
                pref_odd[i]=pref_odd[i-1];

            else 
                pref_odd[i]=pref_odd[i-1]+A[i];
        }

        for(int i=0;i<B.length;i++)
        {
            int L=B[i][0];
            int R=B[i][1];

            if(L==0)
                ans[i]=pref_odd[R];
            else
                ans[i]=pref_odd[R]-pref_odd[L-1];
        }

        return ans;
    }
}
