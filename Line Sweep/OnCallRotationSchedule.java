// https://leetcode.com/discuss/interview-question/4835565/Google-or-Phone-Interview-or-Banglore-oror-SDE-III-oror-Android-(732024)

// Given on-call rotation schedule for multiple people by: their name, start time and end time of the rotation:

// Abby 1 10
// Ben 5 7
// Carla 6 12
// David 15 17

// Your goal is to return rotation table without overlapping periods representing who is on call during that time. Return "Start time", "End time" and list of on-call people:

// 1 5 Abby
// 5 6 Abby, Ben
// 6 7 Abby, Ben, Carla
// 7 10 Abby, Carla
// 10 12 Carla
// 15 17 David
import java.util.*;
class Schedule {
    String name;
    int start;
    int end;

    Schedule(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }
}

class Solution {
    void printOnCallRotationTable(List<Schedule> schedules) {
    //    1 (Abby)                                                  10 (Abby)
    //                 5 (Ben)                       7 (Ben)
    //                          6 (Carla)                                         12 (Carla)
    //                                                                                            15 (David)      17 (David)

       TreeMap<Integer, Set<String>> line = new TreeMap<>();

        for (Schedule s: schedules) {
            int start = s.start, end = s.end;
            String name = s.name;
            if (!line.containsKey(start)) {
                line.put(start, new HashSet<>());
            }

            if (!line.containsKey(end)) {
                line.put(end, new HashSet<>());
            }

            line.get(start).add(name);
            line.get(end).add(name);
       }

       int start = -1;
       System.out.println(line);

       Set<String> names = new HashSet<>();
       for (int point: line.keySet()) {
            List<String> namesToBeRemoved = new ArrayList<>();
            if (start != -1) {
                if (names.size() != 0) {
                    System.out.print(start + " " + point + " "); // [5, 6] 
                    for (String name: names) {
                        System.out.print(name + " "); // [Abby, Ben]
                    }
                    System.out.println();
                }
                for (String name: line.get(point)) {
                    if (names.contains(name)) {
                        namesToBeRemoved.add(name); // {}
                    }
                    names.add(name); // [Abby, Ben, Carla]
                }
                start = point; 
            } else {
                for (String name: line.get(point)) {
                    names.add(name); // [Abby]
                }
                start = point; // 1
            }
            
            for (String nameToBeRemoved: namesToBeRemoved) {
                names.remove(nameToBeRemoved);
            }
       }
    }
}

public class OnCallRotationSchedule {
    public static void main(String[] args) {
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule("Abby", 1, 10));
        schedules.add(new Schedule("Ben", 5, 7));
        schedules.add(new Schedule("Carla", 6, 12));
        schedules.add(new Schedule("David", 15, 17));

        (new Solution()).printOnCallRotationTable(schedules);
    }
}