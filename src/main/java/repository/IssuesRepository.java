package repository;

import domain.Issue;

import java.util.*;

public class IssuesRepository {
    private Set<Issue> issues = new HashSet<>();

    public void save (Issue issue) {
        issues.add(issue);
    }

    public Issue[] findAll() {
        return issues.toArray(new Issue[0]);
    }

}


