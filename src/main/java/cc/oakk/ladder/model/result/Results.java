package cc.oakk.ladder.model.result;

import cc.oakk.ladder.util.ValidationUtils;

import java.util.List;
import java.util.Objects;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = ValidationUtils.throwIfEmptyList(results);
    }

    public Result get(int index) {
        ValidationUtils.throwIfOutOfListSize(results, index);
        return results.get(index);
    }

    public int size() {
        return results.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
