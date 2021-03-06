package manager;

import domain.Issue;
import repository.IssuesRepository;

import java.util.*;
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
        return filterBy(Issue::isClosed);
    }

    public Collection<Issue> findOpen() {
        return filterBy(issue -> !issue.isClosed());
    }

    public Collection<Issue> findByAuthor(String author) {
        return filterBy(issue -> issue.getAuthor().equalsIgnoreCase(author));
    }

    public Collection<Issue> findById(int id) {
        return filterBy(issue -> issue.getId() == id);
    }

    public void closeById(int id) {
        for (Issue issue : this.findById(id)) {
            issue.setClosed(true);
        }
    }

    public void openById(int id) {
        for (Issue issue : this.findById(id)) {
            issue.setClosed(false);
        }
    }

    public Collection<Issue> findByAssignee (Set<String> assignees) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.getAssignees().equals(assignees)) {
                result.add(issue);
            }
        }
        return result;
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
