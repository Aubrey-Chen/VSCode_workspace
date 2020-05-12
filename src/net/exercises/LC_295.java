/**
 * 295. 数据流中的中位数
 *中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
例如，
[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：
    void addNum(int num) - 从数据流中添加一个整数到数据结构中。
    double findMedian() - 返回目前所有元素的中位数。

示例：
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-median-from-data-stream 
 */

package net.exercises;
import java.util.Collections;
import java.util.PriorityQueue;

public class LC_295 {

	public static void main(String[] args) {
		int[] num = {45,36,18,53,72,30,48,93,15,35};
		MedianFinder obj = new MedianFinder();
		for(int i=0;i<=num.length-1;i++) {
			obj.addNum(num[i]);
		}
		double param_2 = obj.findMedian();
		System.out.println(param_2);
	}

}

class MedianFinder {
	private int count;
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
		
    /** initialize your data structure here. */
    public MedianFinder() {
    	count = 0;
    	minHeap = new PriorityQueue<>();
    	maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //Collections.reverseOrder()可替换为：(x, y) -> y-x
    }
    
    public void addNum(int num) {
    	count+=1;
    	maxHeap.offer(num);
    	minHeap.offer(maxHeap.poll());
    	if((count & 1) != 0) {
    		maxHeap.offer(minHeap.poll());
    	}
    }
    
    public double findMedian() {
        if((count & 1) == 0) {
        	return (double)(maxHeap.peek()+minHeap.peek())/2;
        }else {
        	return (double)maxHeap.peek();
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */