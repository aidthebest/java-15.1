package domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Issue {
    private int id;
    private boolean isClosed;
    private String author;
    private String label;
    private Set<String> assignees = new HashSet<>();

    public void addAssignee(String assignee){
        assignees.add(assignee);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return id == issue.id && isClosed == issue.isClosed && Objects.equals(author, issue.author) && Objects.equals(label, issue.label) && Objects.equals(assignees, issue.assignees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isClosed, author, label, assignees);
    }
}


