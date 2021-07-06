package domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Issue {
    private int id;
    private Boolean isClosed;
    private String author;
    private String label;
    private String assignee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return id == issue.id && Objects.equals(isClosed, issue.isClosed) && Objects.equals(author, issue.author) && Objects.equals(label, issue.label) && Objects.equals(assignee, issue.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isClosed, author, label, assignee);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", isClosed=" + isClosed +
                ", author='" + author + '\'' +
                ", label='" + label + '\'' +
                ", assignee='" + assignee + '\'' +
                '}';
    }
}


