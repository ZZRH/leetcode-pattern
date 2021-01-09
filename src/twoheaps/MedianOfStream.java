package twoheaps;

import java.util.PriorityQueue;

/**
 * @author ZRH
 * @date 2020/12/24 17:23
 */
public class MedianOfStream {
    private PriorityQueue<Integer> leftMaxQueue = new PriorityQueue<>((a,b) -> b-a);
    private PriorityQueue<Integer> rightMinQueue = new PriorityQueue<>();

    public void insertNum(int num) {
        if (leftMaxQueue.isEmpty() || num < leftMaxQueue.peek()) {
            leftMaxQueue.offer(num);
        } else if(rightMinQueue.isEmpty() || num > rightMinQueue.peek()) {
            rightMinQueue.offer(num);
        } else {
            if (leftMaxQueue.size() > rightMinQueue.size()) {
                rightMinQueue.offer(num);
            } else {
                leftMaxQueue.offer(num);
            }
            return;
        }
        if (leftMaxQueue.size() == rightMinQueue.size() + 2) {
            rightMinQueue.offer(leftMaxQueue.poll());
        } else if (rightMinQueue.size() == leftMaxQueue.size() + 1) {
            leftMaxQueue.offer(rightMinQueue.poll());
        }
    }

    public double findMedian() {
        if (leftMaxQueue.size() > rightMinQueue.size()) {
            return leftMaxQueue.peek();
        }
        return (leftMaxQueue.peek() + rightMinQueue.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianOfStream medianOfStream = new MedianOfStream();
        medianOfStream.insertNum(3);
        medianOfStream.insertNum(1);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.insertNum(5);
        System.out.println(medianOfStream.findMedian());
        medianOfStream.insertNum(4);
        System.out.println(medianOfStream.findMedian());
    }
}
