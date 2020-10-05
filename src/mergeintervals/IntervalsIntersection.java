package mergeintervals;

import java.util.LinkedList;
import java.util.List;

public class IntervalsIntersection {
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length<1 || arr2.length<1) {
            return new Interval[]{};
        }
        List<Interval> intervalList = new LinkedList<>();
        int index1 = 0, index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            Interval interval1 = arr1[index1], interval2 = arr2[index2];
            if (interval1.start > interval2.end) {
                index2++;
            } else if (interval1.end < interval2.start) {
                index1++;
            }
            int start = Math.max(interval1.start, interval2.start);
            int end = Math.min(interval1.end, interval2.end);
            intervalList.add(new Interval(start, end));
            if (interval1.end < interval2.end) {
                index1++;
            } else if (interval1.end == interval2.end) {
                index1++;
                index2++;
            } else {
                index2++;
            }
        }
        return intervalList.toArray(new Interval[intervalList.size()]);
    }

    public static boolean isOverlap(Interval a, Interval b) {
        return a.start > b.end || a.end < b.start;
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[]{new Interval(1,3), new Interval(5,6), new Interval(7,9)};
        Interval[] input2 = new Interval[]{new Interval(2,3), new Interval(5,7)};
        Interval[] result = merge(input1, input2);
        for (Interval interval : result) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

        input1 = new Interval[]{new Interval(1,3), new Interval(5,7), new Interval(9,12)};
        input2 = new Interval[]{new Interval(5,10)};
        result = merge(input1, input2);
        for (Interval interval : result) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> resultList = new LinkedList<>();
        int i = 0, j = 0;
        while(i<A.length && j<B.length){
            if(A[i][0]>=B[j][0]&&A[i][0]<=B[j][1] || B[j][0]>=A[i][0]&&B[j][0]<=A[i][1]){
                //此时两个区间有交集
                int start = Math.max(A[i][0], B[j][0]);
                int end = Math.min(A[i][1], B[j][1]);
                resultList.add(new int[]{start, end});
            }
            if(A[i][1]>=B[j][1]){
                j++;
            } else {
                i++;
            }
        }
        return resultList.toArray(new int[0][0]);
    }
}
