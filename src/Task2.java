import static java.lang.System.out;
import static java.time.LocalTime.MIN;

import domain.Task;
import domain.TaskType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {
        List<Task> tasks = Task.getTasks();

        PredicateFilters predicateFilters = new PredicateFilters();


        //Subtask1
        List<Task> taskTitlesSortedByCreationDate = tasks
                .stream()
                .filter(predicateFilters.readingTitles)
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .collect(Collectors.toList());


        //Subtask2
        List<Task> readingTasksByCreationDateSortedInReverse = tasks
                .stream()
                .filter(predicateFilters.readingTitles)
                .sorted(Comparator.comparing(Task::getCreatedOn).reversed())
                .collect(Collectors.toList());

        //Subtask3
        List<Task> distinctTasks = tasks
                .stream()
                .distinct()
                .collect(Collectors.toList());


        //Subtask4
        List<Task> topTwoTasksSortedByCreationDate = tasks
                .stream()
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .collect(Collectors.toList())
                .subList(0,1);

        //Subtask5
        Set<String> allUniqueTags = tasks
                .stream()
                .flatMap(task -> task.getTags().stream())
                .collect(Collectors.toSet());

        //Subtask6
        boolean tagBook = tasks
                .stream()
                .filter(predicateFilters.readingTitles)
                .noneMatch(task -> task.getTags().isEmpty());


        //Subtask7
        String titleSummary = tasks
                .stream()
                .map(Task::getTitle)
                .collect(Collectors.joining("***"));





    }
}