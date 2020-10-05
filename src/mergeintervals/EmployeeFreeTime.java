package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EmployeeFreeTime {
    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();

        //合并所有员工的工作时间
        List<Interval> workTime = schedule.get(0);//已合并的员工工作时间
        for (int i = 1; i < schedule.size(); i++) {
            List<Interval> currentWorkTime = schedule.get(i);//当前员工的工作时间
            List<Interval> tempWorkTime = new LinkedList<>();//将workTime和currentWorkTime合并后临时保存的结果
            List<Interval> tempResultWorkTime = new LinkedList<>();
            int index1 = 0, index2 = 0;
            while (index1 < workTime.size() || index2 < currentWorkTime.size()) {
                if (index1 >= workTime.size()) {
                    tempWorkTime.add(currentWorkTime.get(index2));
                    index2++;
                } else if (index2 >= currentWorkTime.size()) {
                    tempWorkTime.add(workTime.get(index1));
                    index1++;
                } else if (workTime.get(index1).start <= currentWorkTime.get(index2).start) {
                    tempWorkTime.add(workTime.get(index1));
                    index1++;
                } else {
                    tempWorkTime.add(currentWorkTime.get(index2));
                    index2++;
                }
            }
            for (Interval interval : tempWorkTime) {
                if (tempResultWorkTime.isEmpty()) {
                    tempResultWorkTime.add(interval);
                    continue;
                }
                Interval lastInterval = tempResultWorkTime.get(tempResultWorkTime.size() - 1);
                if (lastInterval.end < interval.start) {
                    tempResultWorkTime.add(interval);
                    continue;
                }
                int start = Math.min(lastInterval.start, interval.start);
                int end = Math.max(lastInterval.end, interval.end);
                tempResultWorkTime.set(tempResultWorkTime.size()-1, new Interval(start, end));
            }
            workTime = tempResultWorkTime;
        }

        for (int i = 1; i < workTime.size(); i++) {
            result.add(new Interval(workTime.get(i-1).end, workTime.get(i).start));
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1,3), new Interval(5,6))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2,3), new Interval(6,8))));
        List<Interval> employeeFreeTime = findEmployeeFreeTime(input);
        System.out.println(Arrays.toString(employeeFreeTime.toArray()));

        input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1,3), new Interval(9,12))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2,4))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(6,8))));
        employeeFreeTime = findEmployeeFreeTime(input);
        System.out.println(Arrays.toString(employeeFreeTime.toArray()));

        input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1,3))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2,4))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(3,5), new Interval(7,9))));
        employeeFreeTime = findEmployeeFreeTime(input);
        System.out.println(Arrays.toString(employeeFreeTime.toArray()));
    }
}
