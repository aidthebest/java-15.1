package manager;

import domain.Issue;
import manager.IssuesManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssuesRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IssuesManagerTest {
    private IssuesManager manager = new IssuesManager(new IssuesRepository());


    private Issue first = new Issue(1, true, "VKO", "AER", "Belov");
    private Issue second = new Issue(2, false, "SVO", "SIP", "Chernov");
    private Issue third = new Issue(3, false, "DME", "TAS", "Ivanov");
    private Issue four = new Issue(4, true, "DME", "TBS", "Belov");
    private Issue fifth = new Issue(5, true, "VKO", "AER", "Belov");
    private Issue sixt = new Issue(6, false, "VKO", "AER", "Chernov");

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



}