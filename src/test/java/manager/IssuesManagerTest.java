package manager;

import domain.Issue;
import manager.IssuesManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssuesRepository;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IssuesManagerTest {
    private IssuesManager manager = new IssuesManager(new IssuesRepository());


    private Issue first = new Issue(1, true, "VKO", "AER", Collections.singleton("Belov"));
    private Issue second = new Issue(2, false, "SVO", "SIP", Collections.singleton("Chernov"));
    private Issue third = new Issue(3, false, "DME", "TAS", Collections.singleton("Ivanov"));
    private Issue four = new Issue(4, true, "DME", "TBS", Collections.singleton("Belov"));
    private Issue fifth = new Issue(5, true, "VKO", "AER", Collections.singleton("Belov"));
    private Issue sixt = new Issue(6, false, "VKO", "AER", Collections.singleton("Chernov"));

    @BeforeEach
    void SetUp() {
        manager.add(fifth);
        manager.add(second);
        manager.add(sixt);
        manager.add(first);
        manager.add(third);
        manager.add(four);
    }


    @Test
    void save() {

        Issue[] expected = {second, sixt, fifth, first, four, third};
        Issue[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldGetClosed() {

        Issue[] expected = {fifth, first, four};
        Issue[] actual = manager.findClosed().toArray(new Issue[0]);
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldGetOpen() {

        Issue[] expected = {second, sixt, third};
        Issue[] actual = manager.findOpen().toArray(new Issue[0]);
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldGetByAuthor() {

        Issue[] expected = {sixt, fifth, first};
        Issue[] actual = manager.findByAuthor("VKO").toArray(new Issue[0]);
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldGetById () {
        Issue[] expected = {sixt};
        Issue[] actual = manager.findById(6).toArray(new Issue[0]);
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSetClosedById () {
        manager.closeById(3);
        Issue[] expected = {second, sixt};
        Issue[] actual = manager.findOpen().toArray(new Issue[0]);
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSetOpenById () {
        manager.openById(1);
        Issue[] expected = {second, sixt, first, third};
        Issue[] actual = manager.findOpen().toArray(new Issue[0]);
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFilterByAssignee () {
        Issue[] expected = {first, four, fifth};
        Issue[] actual = manager.findByAssignee(Collections.singleton("Belov")).toArray(new Issue[0]);
        assertArrayEquals(expected, actual);
    }
}