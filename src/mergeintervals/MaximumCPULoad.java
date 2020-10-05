package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumCPULoad {
    public static int findMaxCPULoad(List<Job> jobs) {
        int result = 0;
        jobs.sort((a,b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Job> priorityQueueJobs = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));
        for (Job job : jobs) {
            while (!priorityQueueJobs.isEmpty() && priorityQueueJobs.peek().end <= job.start) {
                priorityQueueJobs.poll();
            }
            int tempTotal = job.cpuLoad;
            for (Job temp : priorityQueueJobs) {
                tempTotal+=temp.cpuLoad;
            }
            result = tempTotal>result?tempTotal:result;
            priorityQueueJobs.offer(job);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<>(Arrays.asList(new Job(1,4,3), new Job(2,5,4), new Job(7,9,6)));
        System.out.println(findMaxCPULoad(input));

        input = new ArrayList<>(Arrays.asList(new Job(6,7,10), new Job(2,4,11), new Job(8,12,15)));
        System.out.println(findMaxCPULoad(input));

        input = new ArrayList<>(Arrays.asList(new Job(1,4,2), new Job(2,4,1), new Job(3,6,5)));
        System.out.println(findMaxCPULoad(input));
    }
}

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
}
