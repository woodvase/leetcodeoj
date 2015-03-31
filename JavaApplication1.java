/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author yoli
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(isMatch("hi","*?"));
        
        longestCommonPrefix(new String[]{"a", "b"});
        
        int[] aa = new int[2];
        aa[0] = 1;
        int[] bb = new int[1];
        bb[0] = 2;
        
        merge(aa, 1, bb, 1);
        ladderLength("hot", "dog", new HashSet<>(Arrays.asList("hot", "dot", "dog")));
        
        shiftZeros(new int[]{0,0,0});
        
        //permute(new int[]{1,2,3});
        maxProfit2(new int[]{2,2,5});
        
        anagrams(new String[]{"",""});
        
        System.out.println(convertToTitle(50));
        
        System.out.println(titleToNumber("AAA"));
        
        System.out.println(candy(new int[]{1,2,2}));
        
        firstMissingPositive(new int[]{0,1,2});
        combinationSum(new int[]{2,3,6,7}, 6);
        
        isValidSudoku(new char[][]{
                                    {'.','.','.', '.','5','.', '.','1','.'},
                                    {'.','4','.', '3','.','.', '.','.','.'},
                                    {'.','.','.', '.','.','3', '.','.','1'},
                                    
                                    {'8','.','.', '.','.','.', '.','2','.'},
                                    {'.','.','2', '.','7','.', '.','.','.'},
                                    {'.','1','5', '.','.','.', '.','.','.'},
                                    
                                    {'.','.','.', '.','.','2', '.','.','.'},
                                    {'.','2','.', '9','.','.', '.','.','.'},
                                    {'.','.','4', '.','.','.', '.','.','.'}
                                  }             
        );
        
        searchInsert(new int[]{1,3}, 0);
        searchRange(new int[]{5, 8, 8, 8, 8}, 1);
        
        findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        
        int[] arrayThreeSum = new int[]{-4,-1,-1,0,1,2};
        threeSum(arrayThreeSum);
        
        System.out.println(maxArea(new int[]{1,1}));
                
        int palindrome = 10;
        System.out.println(revertInteger(-4546763));
        System.out.println(isPalindrome(palindrome)? "YES": "NO");
        
        String zigzag = "PAYPALISHIRING";
        System.out.println(zigZagConvert(zigzag, 3));
        
        String p = "aaskljdlfejlsfkjsdkfjlkj";        
        System.out.println(longestPalindrome(p));
        
        int[] A = {1,5,101,200,301,400,999};
        int[] B = {8,20,31};
        findMedianSortedArrays(A,B);
        
        String s1 = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        System.out.println(lengthOfLongestSubstring(s1));
        
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);        
        printList(addTwoNumbers(l1,l2));
        
        int[] b = {1,2,3,4,1,1,6,1,9,11221,1,1,2,1,1,1};
        System.out.println(majorityElement(b));
        
        String s = "this \" is a\" b og";
        System.out.println(splitString(s));
        
        int[] a = {1,6,4,0,9,12};
        quickSort(a,0,a.length -1);
        System.out.println(maximumGap(a));
    }
    
    // https://leetcode.com/problems/rotate-array/
    public void rotate1(int[] nums, int k) {
        int l = nums.length;
        int[] ret = new int[l];
        for(int i = 0; i < l; i ++)
        {
            ret[(i + k) % l] = nums[i];
        }
        
        for(int i = 0; i < l; i ++)
        {
            nums[i] = ret[i];
        }
    }
    
    public void rotate2(int[] nums, int k) {
        for(int i =  nums.length - k % nums.length - 1; i >= 0; i --)
        {
            for(int j = i; j < nums.length; j ++)
            {
                int tmp = nums[j + 1];
                nums[j + 1] = nums[j];
                nums[j] = tmp;
            }
        }
    }
    
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String s = strs[0];
        String ret = "";
        for(int i = 1;i <= s.length(); i ++)
        {
            ret = s.substring(0,i);
            for(int j = 1; j < strs.length; j ++)
            {
                if(!strs[j].startsWith(ret))
                {
                    return ret.substring(0, ret.length()- 1);
                }
            }
        }
        return ret;
    }
    
    // https://leetcode.com/problems/merge-sorted-array/
    public static void merge(int A[], int m, int B[], int n) {
        if(n == 0) return;
        
        int total = m + n - 1;
        int j = m - 1;
        int k = n - 1;
        for(int i = total; i >= 0; i --)
        {
           A[i] = ( k< 0 || (j>=0 && A[j] >= B[k])) ? A[j --]: B[k --];
        }
    }
    
    // https://leetcode.com/problems/validate-binary-search-tree/
    public boolean isValidBST(TreeNode root) {
        
        List<Integer> tmp = new ArrayList<>();
        isValidBSTHelper(root, tmp);
        for(int i = 1; i < tmp.size(); i ++)
        {
            if(tmp.get(i) <= tmp.get(i - 1))
                return false;
        }
        return true;
    }
    
    private void isValidBSTHelper(TreeNode root, List<Integer> inOrder)
    {
        if(root == null) return;  
        isValidBSTHelper(root.left, inOrder);
        inOrder.add(root.val);
         isValidBSTHelper(root.right, inOrder);    
    }
    
    // https://oj.leetcode.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(i < m)
        {
            p = p.next;
            i ++; 
        }
        ListNode insertAfter = p;
         p = p.next;
        while(i < n)
        {
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = insertAfter.next;
            insertAfter.next = tmp;
            i ++;            
       }
        
       return dummy.next;
    }
    
    // https://oj.leetcode.com/problems/word-ladder-ii/    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        return null;
    }
    
    private boolean findLaddersHelper(String start, String end, Set<String> dict, List<String> trans, List<List<String>> allTrans, List<String> visited)
    {
        if(start.equals(end))
        {
            trans.add(end);
            allTrans.add(trans);
            return true;
        }  
        
        visited.add(start);        
        int n = start.length();      
        List<String> sind = new ArrayList<>();
        for(int i = 0; i < n; i ++)
        {
            char[] tmp = start.toCharArray();
            char c = start.charAt(i);
            for(char j = 'a'; j <= 'z'; j ++)
            {
                if(j != c)
                {
                    tmp[i] = j;
                    String s = new String(tmp);
                    if(!visited.contains(s) && dict.contains(s) )
                    {
                       sind.add(s);
                    }
                }
            }
        }
        
        for(int i = 0; i < sind.size(); i ++)
        {
            if(findLaddersHelper(sind.get(i),end, dict, trans, allTrans, visited))
            {
                trans.add(start);
            }
        }        
        
        return false;
    }
    
    // https://oj.leetcode.com/problems/word-ladder/
    public static int ladderLength(String start, String end, Set<String> dict) {
         Queue<String> queue = new LinkedList<>();    
         HashSet<String> visited = new HashSet<>();
         int ret = 1;
         int currentLevelNum = 0;
         queue.add(start);
         int upLevelNum = 1;
         visited.add(start);
         while(!queue.isEmpty())
         {
             String s = queue.poll();
             upLevelNum --;
             int n = s.length();             
             for(int i = 0; i < n; i ++)
             {                 
                char[] a = s.toCharArray();
                for(char c = 'a'; c <= 'z'; c ++)
                {
                     a[i] = c;
                     String tmp = new String(a);
                     if(tmp.equals(end)) return ret + 1;
                     if(!visited.contains(tmp) && dict.contains(tmp))
                     {
                         queue.add(tmp);
                         visited.add(tmp);
                         currentLevelNum ++;
                         dict.remove(tmp);
                     }
                }
             }
             if(upLevelNum == 0)
             {
                 upLevelNum = currentLevelNum;
                 currentLevelNum = 0;
                 ret ++;
             }
         }
         
         return 0;
    }  
    
    // https://oj.leetcode.com/problems/clone-graph/
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        Map<Integer, UndirectedGraphNode> elements = new HashMap<>();
        UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
        elements.put(ret.label, ret);
        cloneGraphHelper(node, ret,elements);  
        return ret;
    }
    
    private void cloneGraphHelper(UndirectedGraphNode OriginalNode, UndirectedGraphNode newNode, Map<Integer, UndirectedGraphNode> dict)
    {
        for(int i = 0; i < OriginalNode.neighbors.size(); i ++)
        {
            UndirectedGraphNode oldn = OriginalNode.neighbors.get(i);
            if(oldn.label != newNode.label)
            {
                if(!dict.containsKey(oldn.label))
                {
                    UndirectedGraphNode newn = new UndirectedGraphNode(oldn.label);
                    newNode.neighbors.add(newn);
                    dict.put(newn.label, newn);
                    cloneGraphHelper(oldn,newn,dict);
                }
                else
                {
                    UndirectedGraphNode existNewNode = dict.get(oldn.label);
                    newNode.neighbors.add(existNewNode);
                }
            }
            else
            {
                newNode.neighbors.add(newNode);
            }
        }
    }
    
    // shift 0s to right of array
    public static void shiftZeros(int[] a)
    {
        if(a.length <= 1) return;
        int i = 0; 
        int j = a.length -1;
        while(i < j)
        {
            while(i < a.length && a[i] != 0)
            {
                i ++;
            }
            while(j >= 0 && a[j] == 0)
            {
                j --;
            }
            if(i < j)
            {
                swap(a, i ++, j --);
            }
        }
    }
    
    // https://oj.leetcode.com/problems/search-a-2d-matrix/
    public static boolean searchMatrix(int[][] matrix, int target) {
        
        if(target < matrix[0][0] && target > matrix[matrix.length - 1][matrix[0].length - 1])
        {
            return false;
        }
        if(target == matrix[0][0]) return true;
        
        for(int i = 0; i < matrix.length; i ++)
        {
            if(target <= matrix[i][matrix[i].length - 1])
            {
                return Arrays.binarySearch(matrix[i], target) >= 0;
            }
        }        
        return false;
    }
    
    // https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode pa = headA;
        ListNode pb = headB;
        int counta = 1;
        int countb = 1;
                
        while(pa != null)
        {
            counta ++;
            pa = pa.next;
        }
        
        while(pb != null)
        {
            countb ++;
            pb = pb.next;
        }        
        
        if(counta > countb)
        {
            int i = 0;
            pa = headA;
            while(i < counta - countb)
            {
                pa = pa.next;
                i ++;
            }
            pb = headB;
        }
        else if(counta < countb)
        {
            int i = 0;
            pb = headB;
            while(i < countb - counta)
            {
                pb = pb.next;
                i ++;
            }
            pa = headA;
        }
        else
        {
            pa = headA;
            pb = headB;
        }
        
        while(pa != null && pb != null && pa != pb)
        {
            pa = pa.next;
            pb = pb.next;
        }
        
        return pa;
    }
    
    // https://oj.leetcode.com/problems/sort-list/
    public static ListNode sortList(ListNode head) 
    {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        while(p != null)
        {
            p = p.next;
        }
        return dummy.next;
    }
    
    // https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public static int maxProfit2(int[] prices)
    {
        int ret = 0;
        if(prices == null || prices.length < 2) return 0;
        if(prices.length == 2)
        {
            if(prices[1] > prices[0]) 
                return prices[1] - prices[0];
            else
                return 0;
        }
        
        boolean needToBuy = true;
        int buyPrice = 0;
        for(int i = 1; i < prices.length; i++)
        {
            if(needToBuy)
            {
                if(i + 1 < prices.length && (prices[i] < prices[i - 1] && prices[i] < prices[i + 1]))
                {
                    needToBuy = false;
                    buyPrice = prices[i];
                }
                else if(prices[i] > prices[i - 1])
                {
                    needToBuy = false;
                    buyPrice = prices[i - 1];
                    i = i -1;
                }
            }
            else
            {
                if(prices[i] < prices[i - 1])
                {
                    ret += prices[i - 1] - buyPrice;
                    needToBuy = true;
                }
            }                
        }
        
        if(!needToBuy)
        {
            ret += prices[prices.length - 1] - buyPrice;
        }
        
        return ret;
    }
    
    // https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        
        int min = prices[0];
        int max = prices[0];
        int gain = 0;
        for(int i = 1; i < prices.length; i ++)
        {
            if(prices[i] < min)
            {
                gain = Math.max(gain, max - min);
                min = prices[i];
                max = prices[i];
                
            }
            else if(prices[i] > max)
            {
                max = prices[i];
            }
        }
        
        return Math.max(gain, max - min);
    }
    
     public static List<String> anagrams(String[] strs)
     {
         if(strs == null)
             return null;
         List<String> ret = new ArrayList<>();
         if(strs.length == 0)
             return ret;
         
         boolean hasAnagrams = false;
         for(int i = 0; i < strs.length; i ++)
         {
             if(!ret.contains(strs[i]))
             {
                 for(int j = i + 1; j < strs.length; j ++)
                 {
                     if(isAnagrams(strs[i], strs[j]))
                     {
                         hasAnagrams = true;
                         ret.add(strs[j]);
                     }
                 }
                 if(hasAnagrams)
                 {
                     ret.add(strs[i]);
                     hasAnagrams = false;
                 } 
             }
         }
         
         return ret;
     }
     
     private static boolean isAnagrams(String str1, String str2)
     {
        if(str1.length() != str2.length())
            return false;
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        
        for(int i = 0; i < str1.length(); i ++)
        {
            a1[str1.charAt(i) - 'a'] += 1;
        }
        
        for(int j = 0; j < str2.length(); j ++)
        {
            a2[str2.charAt(j) - 'a'] += 1;
        }
        
        for(int k = 0; k < a1.length; k ++)
        {
            if(a1[k] != a2[k])
            {
                return false;
            }
        }
        
        return true;
     }
    
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<>();
        if(num.length == 0)
            return ret;        
        int flags[] = new int[num.length];        
        List<Integer> tmp = new ArrayList<>();
        permuteHelper(ret, num, flags,tmp);
        return ret;
    }
    
    private static void permuteHelper(List<List<Integer>> arrays, int[] num, int[] bitState, List<Integer> permutation)
    {
        if(permutation.size() == num.length)
        {
            List<Integer> current = new ArrayList<>(permutation);
            arrays.add(current);                 
        }
        else
        {
            for(int i = 0; i < num.length; i ++)
            {
                if(bitState[i] != 1)
                {
                    bitState[i] = 1;
                    permutation.add(num[i]);
                    permuteHelper(arrays, num, bitState, permutation);
                    bitState[i] = 0;
                    permutation.remove(permutation.size() - 1);
                }
            } 
        }
    }
    
     public static String convertToTitle(int n) {
        if(n == 0) return "";
        StringBuilder sb = new StringBuilder();
        while(n > 0)
        {
            n --;
            sb.insert(0,(char)('A' + n % 26));
            n = n / 26;
        }
        
        return sb.toString();
    }

    // https://oj.leetcode.com/problems/excel-sheet-column-number/
    public static int titleToNumber(String s) {
        int ret = 0;
        for(int i = 0; i < s.length(); i ++)
        {
            ret = ret * 26 + (s.charAt(i) - 'A' + 1);
        }
        
        return ret;
    }
    
    // https://oj.leetcode.com/problems/candy/
    public static int candy(int[] ratings)
    {
        if(ratings.length == 1) return 1;
        int candies = 0;
        int candyForEach[] = new int[ratings.length];
        for(int i = 0; i < candyForEach.length; i ++)
        {
            candyForEach[i] = 1;
        }
        
        for(int i = 1; i < ratings.length; i ++)
        {
            if(ratings[i] > ratings[i - 1])
            {
                candyForEach[i] = 1 + candyForEach[i - 1];
            }
        }    
                
        for(int i = candyForEach.length - 2; i >= 0; i --)
        {
            if(ratings[i] > ratings[i + 1] && candyForEach[i] < candyForEach[i + 1])
            {
                candyForEach[i] = 1 + candyForEach[i + 1];
            }
        }
        
        for(int k = 0; k < candyForEach.length; k ++ )
        {
            candies = candies + candyForEach[k];
        }
        return candies;
    }
    
    // https://oj.leetcode.com/problems/first-missing-positive/
    public static int firstMissingPositive(int[] A)
    {
        if(A.length == 0) return 1;
        for(int i = 0; i < A.length; i ++)
        {
            if(A[i] > 0 && (A[i] - 1) < A.length && A[i] != A[A[i] - 1])
            {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
                i --;
            }
        }
        int i;
        for(i = 0; i < A.length; i ++)
        {
            if(i != A[i] - 1)
                break;
        }
        
        return i + 1;
    }
    
    // https://oj.leetcode.com/problems/combination-sum/
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {        
        Arrays.sort(candidates);
        return combinationSumHelper(candidates, candidates.length -1, target);
    }
    
    private static List<List<Integer>> combinationSumHelper(int[] candidates, int end, int target)
    {
        List<List<Integer>> ret = new ArrayList<>();
        if(target < candidates[0])
        {
            return ret;
        }
        
        int num = candidates[end];
        
        if(end == 0 && target % num != 0)
        {
            return ret;
        }
        
        if(end ==0 && target % num == 0)
        {
            List<Integer> c = new ArrayList();
            for(int k = 0; k < target / num; k ++)
            {
                c.add(num);
            }
            ret.add(c);
            
            return ret;
        }
        
        for(int i = 0; i <= target / candidates[end]; i ++)
        {
            if(target - i * num > 0)
            {
                List<List<Integer>> tmp = combinationSumHelper(candidates, end - 1, target - i * num);

                for(List<Integer> l : tmp)
                {
                    int j = 0;
                    while(j < i)
                    {
                        l.add(num);
                        j ++;
                    }
                    ret.add(l);
                }
            }
            else if(target - i * num == 0)
            {
                List<Integer> c = new ArrayList();
                for(int k = 0; k < i; k ++)
                {
                    c.add(num);
                }
                
                ret.add(c);
            }
        }
        
        return ret;
    }
    
    public static boolean isValidSudoku(char[][] board)
    {
        int l = board[0].length;
        for(int i = 0; i < l; i ++)
        {
            int[] rowFlags = new int[l];
            int[] colFlags = new int[l];
            int[] subArrayFlags = new int[l];
        
            for(int j = 0; j < l; j ++)
            {
                if(board[i][j] != '.')
                {
                    rowFlags[board[i][j] - '1'] += 1;
                    if(rowFlags[board[i][j] -'1'] > 1)
                    {
                        return false;
                    }
                }
                
                if(board[j][i] != '.')
                {
                    colFlags[board[j][i] - '1'] += 1;
                    if(colFlags[board[j][i] - '1'] > 1)
                    {
                        return false;
                    }
                }
                
                int rowina = 3 *(i / 3) +  j / 3;
                int colina = 3 *(i % 3) + j % 3;
                
                if(board[rowina][colina] != '.')
                {
                    subArrayFlags[board[rowina][colina] - '1'] += 1;
                    if(subArrayFlags[board[rowina][colina] - '1'] > 1)
                    {
                        return false;
                    }                    
                }
            }         
        }
        
        return true;
    }
    
    // https://oj.leetcode.com/problems/search-insert-position/
    // Here are few examples.
    //[1,3,5,6], 5 → 2
    //[1,3,5,6], 2 → 1
    //[1,3,5,6], 7 → 4
    //[1,3,5,6], 0 → 0
    public static int searchInsert(int[] A, int target) {
        if(A.length == 0)
            return 0;
        return searchInsertHelper(A, 0, A.length - 1, target);
    }
    
    private static int searchInsertHelper(int[] arr, int left, int right, int target)
    {
        if(left <= right)
        {
            if(target < arr[left])  return left;
            if(target > arr[right] ) return right + 1;
            
            int i = left + (right - left) / 2;
            int elem = arr[left + (right - left) / 2];
            
            if(elem == target)
            {
                return i;
            }
            else if(elem < target)
            {
                return searchInsertHelper(arr, i + 1, right, target);
            }
            else
            {
                return searchInsertHelper(arr, left, i - 1, target);
            }
        } 
        
        return -1;
    }
    
    // https://oj.leetcode.com/problems/search-for-a-range/
    // If the target is not found in the array, return [-1, -1].
    //For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
    public static int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        ret[0] = ret[1] = -1;
        searchRangeHelper(A, 0, A.length - 1, target, ret);
        return ret;
    }
    
    private static void searchRangeHelper(int[] arr, int left, int right, int target, int[] p)
    {
        if(left <= right)
        {
            int i = left + (right - left) / 2;
            int elem = arr[left + (right - left) / 2];
        
            if(elem == target)
            {
                int start = i - 1;
                int end = i + 1;
                while(start >= 0 && arr[start] == target)
                {
                    start --;
                }
                
                while(end < arr.length && arr[end] == target)
                {
                    end ++;
                }
                
                p[0] = start +1;
                p[1] = end -1;
            }
            else if(elem < target)
            {
                searchRangeHelper(arr, i + 1, right, target, p);
            }
            else
            {
                searchRangeHelper(arr, left, i - 1, target, p);
            }
        }
    }
    
    // https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
    // For example, given:
    // S: "barfoothefoobarman"
    // L: ["foo", "bar"]
    // You should return the indices: [0,9].
    public static List<Integer> findSubstring(String S, String[] L)
    {
        List<Integer> ret = new ArrayList<>();
        int[] flags = new int[L.length];  
        int l = L[0].length();
        int charsInL = L.length * l;
        for(int i = 0; i < S.length() - charsInL  + 1; i ++)
        {
            int j = i;
            String s = S.substring(j, j + l);
            while((j - i) < charsInL  && arrayContains(L, flags,s))
            {
                j += l;
                if(j + l > S.length())
                    break;
                s = S.substring(j, j + l);
            }
            
            Boolean allOnce = true;
            for(int k = 0; k < L.length; k ++)
            {
                if(flags[k] != 1)
                {
                    allOnce = false;
                    break;                    
                }
            }
            
            if(allOnce)
            {
                ret.add(i);
            }
            
            for(int k = 0; k < L.length; k ++)
            {
                flags[k] = 0;
            }            
        }
        
        return ret;
    }
    
    private static Boolean arrayContains(String[] strs, int[] states, String target)
    {
        for(int i = 0; i < strs.length; i ++)
        {
            if( strs[i].equals(target) && states[i] == 0)
            {
                states[i] ++;
                return true;
            }
        }
        
        return false;
    }
    
    public static List<List<Integer>> threeSum(int[] num) {
        if(num  == null)
            return null;
        
        List<List<Integer>> ret = new ArrayList<>();
        if(num.length == 0)
        {
            return ret;
        }
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; i ++)
        {
            int twoSum = 0 - num[i];
            
            int j = i + 1;
            int e = num.length -1;

            if(num[j] > twoSum)
            {
                continue;
            }
            
            while(e > j)
            {
                int r2 = twoSum - num[j];
                if(num[e] < r2)
                {
                    j ++;
                }                
                else if(num[e] == r2)
                {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(num[i]);
                    tmp.add(num[j]);
                    tmp.add(num[e]);
                    ret.add(tmp);
                    do { j ++; }while (j < e && num[j - 1] == num[j]);
                    do { e --; }while (j < e && num[e + 1] == num[e]);
                }
                else
                {
                    e --;   
                }
            }
            
            while(i <(num.length - 3) && num[i + 1] == num[i])
            {
                i ++;
            }
        }        
        return ret; 
    }
    
    public static boolean isValid(String s) {
        if(s == null) return false;
        if(s.length() < 2) return false;
        
        Stack st = new Stack();
        int i = 0; 
        while(i < s.length())
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
            {
                st.push(c);
            }
            else 
            {
                char d;
                if(!st.empty())
                {
                    d = (char)st.pop();
                }
                else
                {
                    return false;
                }
                if(c == '}' && d != '{') return false;
                if(c == ']' && d != '[') return false;
                if(c == ')' && d != '(') return false;                
            }
            
            i ++;
        }
        
        return st.empty();
    }
    
    public static int trailingZeroes(int n)
    {
       int ret = 0;
       if(n == 0)
           return ret;
       int i = n / 10;
       int j = n % 10;
       if(j >= 5 )
       {
           ret = i * 2 + 1;
           ret = ret + (n/25);
       }
       else if(j > 0)
       {
           ret = i * 2;
           ret = ret + (n/25);
       }
       else
       {
           ret = trailingZeroes(n - 1);
           int tmp = 1;
           while(i / 10 > 0)
           {
               tmp ++;
               i = i / 10;
           }
           ret += tmp;
       }  
       
       return ret;
    }
    
    
    public static ListNode removeNthFromEnd(ListNode head, int n)
    {
        if(head == null)
            return null;
        if(head.next == null && n > 0)
            return null;
        ListNode nfromend = head;
        ListNode end = nfromend;
        int i = 0;
        while(i < n && end.next != null)
        {
            end = end.next;
            i ++;
        }
        while(end.next != null)
        {
            end = end.next;
            nfromend = nfromend.next;
        }
               
           
        ListNode tmp = nfromend.next;
        if(tmp != null)
        {
            nfromend.next = tmp.next;
            tmp = null;
        }
        else
        {
            nfromend.next = null;
        }
        return head;
    }
    
    public static int maxArea(int[] height) {
        if(height.length == 1)
            return height[0];
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while(i < j)
        {            
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if(height[i] >= height[j])
            {
                j --;
            }
            else
            {
                i ++;
            }
        }
        
        return maxArea;
    }
    
    // https://leetcode.com/problems/wildcard-matching/
    public static boolean isMatch(String s, String p)
    {
        if(s == null || p == null)
            return false;
        if(s.isEmpty() && p.isEmpty()) return true;
        int is = 0;
        int ip = 0;
        int ss = 0;
        int pp = 0;
        boolean isStar = false;
        while(is < s.length())
        {
            if(ip < p.length() && (p.charAt(ip) == '?' || p.charAt(ip) == s.charAt(is)))
            {
                ip ++;
                is ++;
                continue;
            }
            if(ip < p.length() && p.charAt(ip) == '*')
            {
                ss = is;                    
                isStar = true;
                while(ip < p.length() && p.charAt(ip) == '*')
                {
                    ip ++;
                }
                if(ip >= p.length())
                {
                    return true;
                }
                pp = ip;
                continue;
            }
            if(isStar)
            {
                ss ++;
                ip = pp;
                is = ss;
                continue;
            }
            return false;
        }
        while(ip < p.length() && (p.charAt(ip) == '*'))
        {
            ip ++;
        }
        return ip == p.length();
    }
    
    public static int revertInteger(int x)
    {
        int i = 1;
       long tmp = x;
        if(x < 0)
        {
           tmp = x * (-1);
           i = -1;
        }
        
        if(tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE)
        {
            return 0;
        }
        
        long ret = tmp % 10;
        tmp = tmp / 10;
        while(tmp > 0)
        {
            ret = ret * 10 + tmp % 10;
            tmp = tmp /10;
        }
       
        if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE)
        {
            return 0;
        }
        
        return (int)ret * i;        
    }
    
    public static boolean  isPalindrome(int x) 
    {
        if (x < 0) return false;
        int digits = 1;
        while(x / digits >= 10)
        {
            digits *= 10;
        }
        while((digits >= 10) && (x / digits == x % 10))
        {
            x = (x % digits) / 10;
            digits = digits /100;
        }
        
        return digits < 10;
    }
    
    public static String zigZagConvert(String s, int nRows)
    {
        if(s == null)
            return null;
        if (nRows == 1)
            return s;
        
        StringBuilder[] results = new StringBuilder[nRows];
        for(int k = 0 ; k < nRows; k ++)
        {
            results[k] = new StringBuilder();
        }
        
        int rowPlaced = 0;
        boolean isZig = true;
        for(int i = 0; i < s.length(); i ++)
        {
            if(isZig)
            {
                results[rowPlaced].append(s.charAt(i));
                rowPlaced ++;
                if(rowPlaced == nRows)
                {
                    rowPlaced = rowPlaced - 2;
                    if(rowPlaced > 0)
                    {
                        isZig = false;   
                    }
                }
            }
            else
            {
                results[rowPlaced].append(s.charAt(i));                
                rowPlaced --;
                if(rowPlaced == 0)
                {
                    isZig = true;
                }
            }
        }
        
        for(int j = 1; j < nRows; j ++)
        {
            results[0].append(results[j]);
        }
        
        return results[0].toString();
    }
    
    public static String longestPalindrome(String s) {     
       if(s == null || s.length() == 0)
           return null;
       int l = s.length();
       if(l == 1)
           return s;
       String ret = null;
       int sl, sr;
       int maxl = 1;
       for(int i = 1; i < l; i++ )
       {
           sl = i - 1;
           sr = i + 1;
           while(sl >= 0 && sr < l && s.charAt(sl) == s.charAt(sr))
           {
               sl --;
               sr ++; 
           }
           if(sl != (i -1) && (sr - sl - 1) > maxl)
           {
               maxl = sr -sl -1;
               ret = s.substring(sl + 1, sr);
           }
               
           sl = i-1;
           sr = i;
           while(sl >= 0 && sr < l && s.charAt(sl) == s.charAt(sr))
           {
               sl --;
               sr ++;
           }
           if(sl != i && (sr - sl - 1) > maxl)
           {
               maxl = sr -sl - 1;
               ret = s.substring(sl + 1, sr);
           }
       }
       return ret;        
    }
    
    public static void quickSort(int a[], int start, int end)
    {
        if(a == null || end - start < 1)
            return;
        int p = quickSortPartition(a, start, end);
        if(p > 1)
        {
            quickSort(a, start, p - 1);
        }
        if(p < end)
        {
            quickSort(a, p + 1, end);
        }
    }
    
    private static int quickSortPartition(int a[], int start, int end)
    {
        if(a == null || end > a.length)
            return -1;
        int pivotIndex = start + (end - start) / 2;
        int pivot = a[pivotIndex];
        swap(a,pivotIndex,end);
        int indexOfBigger = start;
        for(int i = start; i < end; i ++)
        {
            if(a[i] < pivot)
            {
                swap(a, i, indexOfBigger);
                indexOfBigger += 1;
            }
        }
        swap(a,end,indexOfBigger);
        return indexOfBigger;
    }
    
    private static void swap(int[] a, int index1, int index2)
    {
        int tmp  = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }
    
    // https://leetcode.com/problems/median-of-two-sorted-arrays/
    public static double findMedianSortedArrays(int A[], int B[]) {
        return findMedianSortedArraysHelper(A, 0, A.length - 1, B, 0, B.length -1);
    }
    
    public static double findMedianSortedArraysHelper(int A[], int startA, int endA, int B[], int startB, int endB) 
    {
        if(startA >= endA || startB >= endB)
        {
            
        }
        while(startA < endA && startB < endB)
        {
            int midA = startA + (endA - startA) / 2;
            int midB = startB + (endB - startB) / 2;
            
            if(A[midA] > B[midB])
            {
                findMedianSortedArraysHelper(A, startA, midA, B, midB + 1, endB);
                //endA = midA;
                //startB = midB + 1;
            }
            else if(A[midA] < B[midB])
            {
                findMedianSortedArraysHelper(A, midA + 1, endA, B, startB, midB);
                //startA = midA + 1;
                //endB = midB;
            }
            else return A[midA];
        }
        
        return -1;
    }
    
    public static int majorityElement(int[] num)
    {
        int ret = 0;
        
        Map<Integer, Integer> frequencyEle = new HashMap<>();
        for(int i = 0; i < num.length; i ++)
        {
            Integer fre = frequencyEle.get(num[i]);
            frequencyEle.put(num[i], (fre == null)? 1 : fre +1);
        }
        
        Integer max = num.length/2;
        
        for(Map.Entry<Integer, Integer> entry : frequencyEle.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                ret = entry.getKey();
            }
        }
        return ret;
    }
    
    public static int lengthOfLongestSubstring(String s)
    {
        if(s == null)
        {
            return 0;
        }
        
        int startIndex = 0;
        int maxLen = 0;
        Map<Character, Integer> t = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(t.containsKey(s.charAt(i)))
            {
                startIndex = Math.max(t.get(s.charAt(i)) + 1, startIndex);
            }
            
            t.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - startIndex + 1);    
        }
        return maxLen;
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        int tmp1 = l1.val + l2.val;
        ListNode retNode = new ListNode(tmp1 < 10 ? tmp1 : tmp1 -10);
        int carryOn = (tmp1 < 10 ? 0 : 1);
        ListNode curL1 = l1.next;
        ListNode curL2 = l2.next;
        ListNode curNode = retNode;
        
        while(curL1 != null && curL2 != null)
        {
            tmp1 = carryOn + curL1.val + curL2.val;
            curNode.next = new ListNode(tmp1 < 10 ? tmp1 : tmp1 -10);
            carryOn = (tmp1 < 10 ? 0 : 1);
            curNode = curNode.next;
            curL1 = curL1.next;
            curL2 = curL2.next;
        }
        
        ListNode restNode = (curL1 != null)? curL1 : curL2;
        while(restNode != null)
        {
            tmp1 = carryOn + restNode.val;
            curNode.next = new ListNode(tmp1 < 10 ? tmp1 : tmp1 -10);
            carryOn = tmp1 < 10 ? 0 : 1;
            curNode = curNode.next;
            restNode = restNode.next;
        }  
        
        if(carryOn > 0)
        {
            curNode.next = new ListNode(carryOn);
        }
        
        return retNode;
    }
    
    private static int listToInt(ListNode ln)
    {
        int i = 1;
        ListNode tmp = ln;
        int ret = ln.val;
        while(tmp.next != null)
        {
            ret = (int) (ret + tmp.next.val * Math.pow(10, i));
            i ++;
            tmp = tmp.next;
        }
        return ret;
    }
    
    private static ListNode intToList(int i)
    {
        ListNode headNode, curNode;
        headNode = curNode = new ListNode(i % 10);
        int tmp = i/10;
        while(tmp > 0)
        {
            curNode.next = new ListNode(tmp %10);
            tmp = tmp /10;            
            curNode = curNode.next;
        }
        return headNode;
    }
    
    public static void printList(ListNode ln)
    {
        if(ln == null)
            return;
        ListNode tmp = ln;
        while(tmp.next != null)
        {
            System.out.print(tmp.val);
            System.out.print(' ');
            tmp = tmp.next;
        }
        System.out.println(tmp.val);
    }
    
    public static int maximumGap(int[] num) {
        int max;
        int min;
        if(num == null) return -1;
        if(num.length < 2)
            return 0;
        
        if(num[0] >= num[1])
        {
            max = num[0];
            min = num[1];
        }
        else
        {
            max = num[1];
            min = num[0];
        }
        
        int diff = max - min;
        
        for(int i = 2; i < num.length; i ++)
        {
            if(num[i] > max)
            {
                if ((num[i] - max) > diff)
                {
                    diff = num[i] - max;
                }
                max = num[i];
            }
            else if(num[i] < min)
            {
                if((min - num[i]) > diff)
                {
                    diff = min - num[i];
                }
                min = num[i];
            }
            else
            {
                if((max - num[i] > (num[i] - min)))
                {
                    diff = max - num[i];
                }
                else
                {
                    diff = num[i] - min;
                }              
            }
        }
        
        return diff;
    }
    
    public static List<String> splitString(String str)
    {
        if(str == null || str.length() == 0)
            return null;
        
        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
            
        for(int i = 0; i < str.length(); i ++)
        {
            char c = str.charAt(i);
            if(c == '\"')
            {
                sb.append(c);
                while(++i < str.length() && str.charAt(i) != '\"' )
                {
                    sb.append(str.charAt(i));
                }
                
                // It won't throw if the string is ".
                if(i == str.length() && str.charAt(i-1) != '\"')
                {
                    throw new InvalidParameterException("Unmached \" in input string");
                }
                sb.append(c);
                ret.add(sb.toString());
                sb.setLength(0);
            }
            else if(c == ' ')
            {
                if(sb.length() > 0)
                {
                    ret.add(sb.toString());
                    sb.setLength(0);
                }
            }
            else
            {
                sb.append(c);
            }
        }
        if(sb.length() > 0)
        {
            ret.add(sb.toString());
        }
        return ret;
    }    
}
