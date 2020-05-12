/**
 9.判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
示例 1:
输入: 121
输出: true

示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

进阶:
你能不将整数转为字符串来解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-number
 */
package net.exercises;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class LC_09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int x = sc.nextInt();
		Solution09 s = new Solution09();
		
		System.out.println(s.isPalindrome(x));
	}

}

class Solution09 {
    public boolean isPalindrome(int x) {
    	//解法三：进阶解法——巧妙解法
    	//执行用时：50 ms		内存消耗：37.6 MB
//    	将 解法一 数字反转倒置方法的优化——取出后半段数字进行翻转。
//
//    	这里需要注意的一个点就是由于回文数的位数可奇可偶，
//    	所以当它的长度是偶数时，它对折过来应该是相等的；当它的长度是奇数时，那么它对折过来后，有一个的长度需要去掉一位数（除以 10 并取整）。
    	if(x<0 ||(x%10==0 && x!=0)) return false;
    	int rev = 0;
    	while(x > rev){
    		rev = rev*10+x%10;
    		x /= 10;
    	}
    	return x == rev || x == rev/10;
    	
    	
	
    	
/*    	//解法二：进阶解法——数学解法
 * 		执行用时：51 ms		内存消耗：38 MB
//    	通过取整和取余操作获取整数中对应的数字进行比较。
//
//    	举个例子：1221 这个数字。
//    	    通过计算 1221 / 1000， 得首位1
//    	    通过计算 1221 % 10， 可得末位 1
//    	    进行比较
//    	    再将 22 取出来继续比较
    	int div = 1;
    	if(x < 0) return false;
    	while(x/div >= 10) div *= 10;
    	while(x > 0){
    		int right = x%10;
    		int left = x/div;
    		if(left != right) return false;
    		x = x%div/10;
    		div /= 100;
    	}
    	return true;
*/    	
    	
    	
    	
       /*
        * 解法一：利用数字倒置后的结果与先前的数字进行比较（First-Blood method by myself.）
        * 		巧妙解法优化前
        * 执行用时：47 ms		内存消耗：38.1 MB
    	int ans = 0;
        if(x < 0 || (x%10==0 && x!=0)) return false;
        int pre = x;
        while(x != 0){
            int pop = x%10;
            x /= 10;
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && pop > 7))
            	throw new IllegalArgumentException("Out of the upper bound!");
            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && pop < -8))
            	throw new IllegalArgumentException("Out of the lower bound!");
        	ans = ans*10 + pop;
        }
        if(ans == pre){
        	return true;
        }else{
        	return false;
        }
      */  
    }
}
