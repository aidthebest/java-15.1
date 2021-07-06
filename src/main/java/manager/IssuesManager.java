package manager;

import domain.Issue;
import repository.IssuesRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssuesManager {
    private IssuesRepository repository = new IssuesRepository();

    public IssuesManager(IssuesRepository issuesRepository) {

    }

    public void add (Issue issue){
        repository.save(issue);
    }

    public Issue[] getAll() {
        return repository.findAll();
    }
    public Collection<Issue> findClosed () {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.getIsClosed()) {
                result.add(issue);
            }
        }
        return result;
    }

    public Collection<Issue> findOpen () {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (!issue.getIsClosed()) {
                result.add(issue);
            }
        }
        return result;
    }

    public Collection<Issue> findByAuthor (String author) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.getAuthor().equals(author)) {
                result.add(issue);
            }
        }
        return result;
    }
}
