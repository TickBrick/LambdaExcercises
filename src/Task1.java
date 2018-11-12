import static java.lang.System.*;

import domain.Task;
import domain.TaskType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1{

    public static void main(String[] args) {
        List<Task> tasks = Task.getTasks();
        PredicateFilters pf = new PredicateFilters();

        List<Task> resultTaks = tasks
                .stream()
                .filter(pf.readingTitles)
                .collect(Collectors.toList());

        out.println("---------------TASK 1---------------");
        resultTaks.forEach(out::println);
        out.println("\n");

    }
}
