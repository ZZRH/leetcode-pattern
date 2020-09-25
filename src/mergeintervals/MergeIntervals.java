package mergeintervals;

import java.util.*;

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            ArrayList<Interval> dest = new ArrayList<>(intervals.size());
            Collections.copy(dest, intervals);
            return dest;
        }
        List<Interval> mergeIntervals = new LinkedList<>();
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                if (interval1.start < interval2.start) {
                    return -1;
                } else if (interval1.start < interval2.start) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for (int index = 0; index < intervals.size(); index++) {
            if (mergeIntervals.size() == 0) {
                mergeIntervals.add(new Interval(intervals.get(index).start, intervals.get(index).end));
                continue;
            }
            Interval currentMergeInterval = mergeIntervals.get(mergeIntervals.size()-1);
            Interval currentIngerval = intervals.get(index);
            if (currentMergeInterval.end >= currentIngerval.start) {//合并
                currentMergeInterval.end = Math.max(currentMergeInterval.end, currentIngerval.end);
            } else {
                mergeIntervals.add(new Interval(intervals.get(index).start, intervals.get(index).end));
                continue;
            }
        }
        return mergeIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1,4));
        input.add(new Interval(2,5));
        input.add(new Interval(7,9));
        for (Interval interval : merge(input)) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(6,7));
        input.add(new Interval(2,4));
        input.add(new Interval(5,9));
        for (Interval interval : merge(input)) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1,4));
        input.add(new Interval(2,6));
        input.add(new Interval(3,5));
        for (Interval interval : merge(input)) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();
        input.subList(1,2).clear();
    }
}
