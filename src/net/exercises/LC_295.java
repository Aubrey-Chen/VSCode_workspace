/**
 * 295. �������е���λ��
 *��λ���������б��м����������б�����ż������λ�������м���������ƽ��ֵ��
���磬
[2,3,4] ����λ���� 3
[2,3] ����λ���� (2 + 3) / 2 = 2.5

���һ��֧���������ֲ��������ݽṹ��
    void addNum(int num) - �������������һ�����������ݽṹ�С�
    double findMedian() - ����Ŀǰ����Ԫ�ص���λ����

ʾ����
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/find-median-from-data-stream 
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
    	maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //Collections.reverseOrder()���滻Ϊ��(x, y) -> y-x
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