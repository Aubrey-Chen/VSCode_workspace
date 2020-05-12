/**
7.缁欏嚭涓�涓� 32 浣嶇殑鏈夌鍙锋暣鏁帮紝浣犻渶瑕佸皢杩欎釜鏁存暟涓瘡浣嶄笂鐨勬暟瀛楄繘琛屽弽杞��
绀轰緥 1:
杈撳叆: 123
杈撳嚭: 321
 	绀轰緥 2:
	杈撳叆: -123
	杈撳嚭: -321
		绀轰緥 3:
		杈撳叆: 120
		杈撳嚭: 21
娉ㄦ剰:
鍋囪鎴戜滑鐨勭幆澧冨彧鑳藉瓨鍌ㄥ緱涓� 32 浣嶇殑鏈夌鍙锋暣鏁帮紝鍒欏叾鏁板�艰寖鍥翠负 [鈭�231,  231 鈭� 1]銆傝鏍规嵁杩欎釜鍋囪锛屽鏋滃弽杞悗鏁存暟婧㈠嚭閭ｄ箞灏辫繑鍥� 0銆�

鏉ユ簮锛氬姏鎵ｏ紙LeetCode锛�
閾炬帴锛歨ttps://leetcode-cn.com/problems/reverse-integer
 */
package net.exercises;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class LC_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		int x = sc.nextInt();
		Solution07 s = new Solution07();
		System.out.println(x+"鍙嶈浆鍚庣殑缁撴灉涓猴細"+s.reverse(x));
	}

}

class Solution07{
	public int reverse(int x){
	int ans  = 0;
	while(x != 0){
		int pop = x%10;
		x = x/10;
		if(ans > Integer.MAX_VALUE/10 || ans == Integer.MAX_VALUE/10 && pop>7)
			return 0;
		if(ans < Integer.MIN_VALUE/10 || ans == Integer.MIN_VALUE/10 && pop<-8)
			return 0;
		ans = ans*10 + pop;
	}
	return ans;
		
		
		
		
		
		
		/*	
		int a = Math.abs(x), b = 0, c = 0, y = 0;
		int i = 0, j = 0;
		while(true){
			if(a >= (int) Math.pow(10, i) && a < (int) Math.pow(10, i+1)){
				j = i;
				break;
			}
			i++;
		}
		while(a != 0){
			int t = (int) Math.pow(10, j);
			b = a%10;
			c = b*t;
			y += c;
			a = a/10;
			j--;
		}
		if(x < 0){
			return -y;
		}else{
			return y;
		}
	*/	
	}
}