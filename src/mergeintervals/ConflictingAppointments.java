package mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments {
    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start == o2.start) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        Interval last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval temp = intervals[i];
            if (last.end > temp.start) {
                return false;
            }
            last = temp;
        }
        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1,4), new Interval(2, 5), new Interval(7, 9)};
        System.out.println(canAttendAllAppointments(intervals));

        Interval[] intervals1 = {new Interval(6,7), new Interval(2, 4), new Interval(8, 12)};
        System.out.println(canAttendAllAppointments(intervals1));

        Interval[] intervals2 = {new Interval(4,5), new Interval(2, 3), new Interval(3, 6)};
        System.out.println(canAttendAllAppointments(intervals2));
    }
}
