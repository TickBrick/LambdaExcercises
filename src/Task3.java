import static domain.Task.getTasks;
import static java.lang.System.*;

import domain.Task;
import domain.TaskType;

import java.util.*;
import java.util.stream.Collectors;

public class Task3 {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();
        PredicateFilters predicateFilters = new PredicateFilters();

        //Subtask1
        String longestTitle = tasks
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getTitle().length(), t1.getTitle().length()))
                .limit(1)
                .map(Task::getTitle)
                .collect(Collectors.joining());

        //Subtask2
        long totalNumberOFTags = tasks
                .stream()
                .mapToLong(t -> t.getTags().size())
                .sum();

        //Subtask3
        String titleSummary = tasks
                .stream()
                .map(Task::getTitle)
                .collect(Collectors.joining("***"));

        //Subtask4
        Map<TaskType, List<Task>> tasksGroupedByType = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getType));

        //print Subtask1
        out.println("---------------SUBTASK 1---------------");
        out.println(longestTitle);
        out.println("\n");

        //Print Subtask2
        out.println("---------------SUBTASK 2---------------");
        out.println(totalNumberOFTags);
        out.println("\n");


        //print Subtask3
        out.println("---------------SUBTASK 3---------------");
        out.println(titleSummary);
        out.println("\n");


        out.println("---------------SUBTASK 5---------------");
        Iterator<Map.Entry<TaskType,List<Task>>> iterator = tasksGroupedByType.entrySet().iterator();
        StringBuilder mapResultString = new StringBuilder();
        while(iterator.hasNext()){
            Map.Entry<TaskType,List<Task>> entry = iterator.next();
            mapResultString.append(entry.getKey());
            mapResultString.append(" : ");
            mapResultString.append(entry.getValue());
            mapResultString.append(" , ");
            mapResultString.append("\n");
        }

        out.println(mapResultString.toString());



    }
}
