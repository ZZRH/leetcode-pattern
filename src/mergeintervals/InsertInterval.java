package mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        boolean isNewIntervalMerged = false;
        for (int i = 0; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            if (!isNewIntervalMerged) {
                boolean overlap = isOverlap(currentInterval, newInterval);
                if (currentInterval.end < newInterval.start) {
                    continue;
                } else if(currentInterval.start > newInterval.end){
                    intervals.add(i, newInterval);
                    isNewIntervalMerged = true;
                    break;
                } else {
                    intervals.set(i, merge(currentInterval, newInterval));
                    isNewIntervalMerged = true;
                }
            } else {
                Interval preInterval = intervals.get(i-1);
                if (isOverlap(preInterval, currentInterval)) {
                    Interval mergeInterval = merge(preInterval, currentInterval);
                    intervals.set(i - 1, mergeInterval);
                    intervals.remove(i);
                } else {
                    break;
                }
            }
        }
        if (!isNewIntervalMerged) {
            intervals.add(newInterval);
        }
        return intervals;
    }

    /**
     * 判断两个区间是否有重叠部分
     * @param interval1
     * @param interval2
     * @return
     */
    public static boolean isOverlap(Interval interval1, Interval interval2) {
        if (interval1.end < interval2.start || interval1.start > interval2.end) {
            return false;
        }
        return true;
    }

    /**
     * 合并两个区间
     * 若两个区间没有重叠部分，返回null
     * @param interval1
     * @param interva2
     * @return
     */
    public static Interval merge(Interval interval1, Interval interva2) {
        if (!isOverlap(interval1, interva2)) {
            return null;
        }
        int start = Math.min(interval1.start, interva2.start);
        int end = Math.max(interval1.end, interva2.end);
        return new Interval(start, end);
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(5,7));
        input.add(new Interval(8,12));
        for (Interval interval : insert(input, new Interval(4, 6))) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(5,7));
        input.add(new Interval(8,12));
        for (Interval interval : insert(input, new Interval(4, 10))) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(2,3));
        input.add(new Interval(5,7));
        for (Interval interval : insert(input, new Interval(1, 4))) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1,3));
        input.add(new Interval(5,7));
        input.add(new Interval(11,12));
        for (Interval interval : insert(input, new Interval(8, 10))) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

    }
}
