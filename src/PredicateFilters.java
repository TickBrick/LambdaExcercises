import domain.Task;
import domain.TaskType;

import java.util.function.Predicate;

public class PredicateFilters {
    Predicate<Task> readingTitles = p -> p.getType() == (TaskType.READING);
    Predicate<Task> codingTitles = p -> p.getType() == (TaskType.CODING);
    Predicate<Task> bloggingTitles = p -> p.getType() == (TaskType.BLOGGING);


    public Predicate<Task> getReadingTitles() {
        return readingTitles;
    }



}
