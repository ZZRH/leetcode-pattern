package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumMeetingRooms {
    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        int result = 1;
        meetings.sort((a, b) -> {return Integer.compare(a.start, b.start);});
        for (int i = 0; i < meetings.size(); i++) {
            int tempTotal = 1;
            for (int k = 0; k < i; k++) {
                if (meetings.get(i).start < meetings.get(k).end) {
                    tempTotal++;
                }
            }
            result = tempTotal>result?tempTotal:result;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<Meeting>(){
            {
                add(new Meeting(4,5));
                add(new Meeting(2,3));
                add(new Meeting(2,4));
                add(new Meeting(3,5));
            }
        };
        System.out.println(findMinimumMeetingRooms(input));

        input = new ArrayList<Meeting>(){
            {
                add(new Meeting(1,4));
                add(new Meeting(2,5));
                add(new Meeting(7,9));
            }
        };
        System.out.println(findMinimumMeetingRooms(input));

        input = new ArrayList<Meeting>(){
            {
                add(new Meeting(6,7));
                add(new Meeting(2,4));
                add(new Meeting(8,12));
            }
        };
        System.out.println(findMinimumMeetingRooms(input));

        input = new ArrayList<Meeting>(){
            {
                add(new Meeting(1,4));
                add(new Meeting(2,3));
                add(new Meeting(3,6));
            }
        };
        System.out.println(findMinimumMeetingRooms(input));

        input = new ArrayList<Meeting>(){
            {
                add(new Meeting(4,5));
                add(new Meeting(2,3));
                add(new Meeting(2,4));
                add(new Meeting(3,5));
            }
        };
        System.out.println(findMinimumMeetingRooms(input));
    }
}

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}