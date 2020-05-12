/**
 9.�ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
ʾ�� 1:
����: 121
���: true

ʾ�� 2:
����: -121
���: false
����: �������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������

ʾ�� 3:
����: 10
���: false
����: ���������, Ϊ 01 �����������һ����������

����:
���ܲ�������תΪ�ַ�����������������

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/palindrome-number
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
    	//�ⷨ�������׽ⷨ��������ⷨ
    	//ִ����ʱ��50 ms		�ڴ����ģ�37.6 MB
//    	�� �ⷨһ ���ַ�ת���÷������Ż�����ȡ���������ֽ��з�ת��
//
//    	������Ҫע���һ����������ڻ�������λ�������ż��
//    	���Ե����ĳ�����ż��ʱ�������۹���Ӧ������ȵģ������ĳ���������ʱ����ô�����۹�������һ���ĳ�����Ҫȥ��һλ�������� 10 ��ȡ������
    	if(x<0 ||(x%10==0 && x!=0)) return false;
    	int rev = 0;
    	while(x > rev){
    		rev = rev*10+x%10;
    		x /= 10;
    	}
    	return x == rev || x == rev/10;
    	
    	
	
    	
/*    	//�ⷨ�������׽ⷨ������ѧ�ⷨ
 * 		ִ����ʱ��51 ms		�ڴ����ģ�38 MB
//    	ͨ��ȡ����ȡ�������ȡ�����ж�Ӧ�����ֽ��бȽϡ�
//
//    	�ٸ����ӣ�1221 ������֡�
//    	    ͨ������ 1221 / 1000�� ����λ1
//    	    ͨ������ 1221 % 10�� �ɵ�ĩλ 1
//    	    ���бȽ�
//    	    �ٽ� 22 ȡ���������Ƚ�
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
        * �ⷨһ���������ֵ��ú�Ľ������ǰ�����ֽ��бȽϣ�First-Blood method by myself.��
        * 		����ⷨ�Ż�ǰ
        * ִ����ʱ��47 ms		�ڴ����ģ�38.1 MB
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
