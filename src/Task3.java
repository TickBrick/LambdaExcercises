import static domain.Task.getTasks;
import static java.lang.System.*;

import domain.Task;
import domain.TaskType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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



    }
}
