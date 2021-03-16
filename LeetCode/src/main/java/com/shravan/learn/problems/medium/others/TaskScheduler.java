package com.shravan.learn.problems.medium.others;

import java.util.Arrays;

public class TaskScheduler {

    private int totalTasks;

    public static void main(String[] args) {
        TaskScheduler solution1 = new TaskScheduler();
        int leastInterval1 = solution1.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2);
        // possible solution - A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
        System.out.println("leastInterval1 = " + leastInterval1);// 16

        TaskScheduler solution2 = new TaskScheduler();
        int leastInterval2 = solution2.leastInterval(new char[]{'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B'}, 2);
        System.out.println("leastInterval2 = " + leastInterval2);// 11

        TaskScheduler solution3 = new TaskScheduler();
        int leastInterval3 = solution3.leastInterval(new char[]{'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B'}, 3);
        System.out.println("leastInterval3 = " + leastInterval3);// 14
    }

    // one task takes one unit of time
    // need n units of time between same task
    public int leastInterval(char[] tasks, int n) {
        Integer[] countsMap = createCountsMap(tasks);
        //Sort the counts map - descending order, the task with the larget number of occurrences
        // comes first
        Arrays.sort(countsMap, (lhs, rhs) -> rhs - lhs);
        // if we are to order the tasks  due to cool down period we will get areas where we can
        // allocate other tasks. If there are no tasks like that, we will have "idle" in these area
        // the size of each area like that equals to the cool down period
        // if for example we have 3 occurrences of the task with the large occurrences,
        // we have 2 allocation areas
        int idle = (countsMap[0] - 1) * n;
        int allocationAreas = countsMap[0] - 1;
        for (int counter = 1; counter < countsMap.length; counter++) {
            // We're reducing the the number of idle allocation -
            // for each task - if the number of its occurrences is smaller
            // than the number of allocation areas , its occurrences will fit
            // to to the allocation areas, and we can reduce the number of idle slots
            //
            // If the task has more occurrences than the number of the allocated areas
            // we will be able to remove idle spots up to the number of allocation areas
            idle -= Math.min(allocationAreas, countsMap[counter]);
        }
        // We might find ourselves with negative idle number if we have more task types than
        // the size of the cool down period
        // in this case we will allocate them after the last allocation of the task with the largest
        // number of allocations
        idle = Math.max(idle, 0);
        return idle + totalTasks;
    }

    private Integer[] createCountsMap(char[] tasks) {
        Integer[] results = new Integer[26];
        for (int counter = 0; counter < 26; counter++) {
            results[counter] = 0;
        }
        for (char ch : tasks) {
            ++results[ch - 'A'];
            totalTasks++;
        }
        return results;
    }

}
