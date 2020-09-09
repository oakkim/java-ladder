package cc.oakk.ladder.model.trace;

import cc.oakk.ladder.model.person.Person;
import cc.oakk.ladder.model.result.Result;

import java.util.HashMap;
import java.util.Map;

import static cc.oakk.ladder.util.ValidationUtils.throwIfNull;

public class TraceResults {
    private final Map<Person, Result> results = new HashMap<>();

    public TraceResults putResult(Person person, Result result) {
        results.put(throwIfNull(person), throwIfNull(result));
        return this;
    }

    public Result getResult(Person person) {
        return results.get(throwIfNull(person));
    }
}
