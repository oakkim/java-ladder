package cc.oakk.ladder.model.trace;

import cc.oakk.ladder.model.person.Person;
import cc.oakk.ladder.model.result.Result;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TraceResultsTest {
    @ParameterizedTest
    @CsvSource(value = { "pobi:꽝", "honux:꽝", "crong:5000", "jk:3000" }, delimiter = ':')
    public void putResult_getResult(String name,  String result) {
        TraceResults traceResults = new TraceResults();
        traceResults.putResult(new Person(name), new Result(result));
        assertThat(traceResults.getResult(new Person(name))).isEqualTo(new Result(result));
    }
}
