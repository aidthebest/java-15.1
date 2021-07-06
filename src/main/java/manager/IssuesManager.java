package manager;

import domain.Issue;
import repository.IssuesRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class IssuesManager {
    private IssuesRepository repository = new IssuesRepository();

    public IssuesManager(IssuesRepository issuesRepository) {

    }

    public void add(Issue issue) {
        repository.save(issue);
    }

    public Issue[] getAll() {
        return repository.findAll();
    }

    public Collection<Issue> findClosed() {
        return filterBy(Issue::getIsClosed);
    }

    public Collection<Issue> findOpen() {
        return filterBy(issue -> !issue.getIsClosed());
    }

    public Collection<Issue> findByAuthor(String author) {
        return filterBy(issue -> issue.getAuthor().equalsIgnoreCase(author));
    }

    private Collection<Issue> filterBy(Predicate<Issue> filter) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (filter.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }
}
