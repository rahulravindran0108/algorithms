### Leet Code Code

## Description

Here you will find Leet Code solutions to 
- [Binary Search](#Binary-Search)
- [Trees](Trees)
- [Linked List] (Linked List)
- [Backtracking]
- [Sorting] (Sorting)
- [Dynamic Programming] (Dynamic Programming)


## Dynamic Programming
> Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
> For example, given the following matrix:

```
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
```

```
public class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] dp = new int[row][col];
        int max = 0;
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = matrix[i][j] - '0';
                    System.out.println(dp[i][j]);
                } else if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }
                max = Math.max(max,dp[i][j]);
            }
            
        }
        
        return max*max;
    }
}
```

## Trees

## Linked List

> Odd Even Linked List
> Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

> You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

> Example:
```
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.
```

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        
        ListNode curr1 = dummy1, curr2 = dummy2;
        
        int index = 0;
        
        while(head!=null) {
            ++index;
            if(index % 2 !=0) {
                curr1.next = head;
                curr1 = curr1.next;
            } else {
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }
        
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
        
        
    }
}
```

## Backtracking

## Sorting

# Binary-Search

> Median of Two Sorted Arrays

```java
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if((m+n) % 2 != 0) {
            return (double) findKth(nums1,nums2, (m+n)/2,0,m-1,0,n-1);
        } else {
            return (findKth(nums1,nums2, (m+n)/2,0,m-1,0,n-1) +
                        findKth(nums1,nums2, (m+n)/2-1,0,m-1,0,n-1)) * 0.5;
        }
    }
    
    public static int findKth(int [] A, int [] B, int k , int aStart, int aEnd, 
                                    int bStart, int bEnd) {
            
            int aLen = aEnd - aStart + 1;
            int bLen = bEnd - bStart + 1;
            if(aLen == 0)
                return B[bStart+k];
            if(bLen == 0)
                return A[aStart+k];
            if(k == 0)
                return (A[aStart] < B[bStart]) ? A[aStart] : B[bStart];
                
            int aMid = aLen * k / (aLen+bLen); // get the middle count of A
            int bMid =  k - aMid - 1; // get the middle count of B 
            
            aMid += aStart;
            bMid += bStart;
            
            if(A[aMid] > B[bMid]) {
                k = k - (bMid - bStart + 1);
                aEnd = aMid;
                bStart = bMid +1;
            } else {
                k = k - (aMid - aStart + 1);
                bEnd = bMid;
                aStart = aMid +1;
            }
            
            return findKth(A,B,k,aStart,aEnd,bStart,bEnd);
    }
}
```

