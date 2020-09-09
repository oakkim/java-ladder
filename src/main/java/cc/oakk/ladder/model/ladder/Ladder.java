package cc.oakk.ladder.model.ladder;

import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import cc.oakk.ladder.model.ladder.dto.LadderDto;
import cc.oakk.ladder.model.line.Line;
import cc.oakk.ladder.model.person.Person;
import cc.oakk.ladder.model.person.Persons;
import cc.oakk.ladder.model.result.Result;
import cc.oakk.ladder.model.result.Results;
import cc.oakk.ladder.model.size.LadderHeight;
import cc.oakk.ladder.model.size.LadderWidth;
import cc.oakk.ladder.model.trace.Trace;
import cc.oakk.ladder.model.trace.TraceResults;

public class Ladder {
    private static final BinaryOperator<Trace> IDENTITY = (a, b) -> a;

    private final List<Line> lines;

    public Ladder(int width, int height) {
        new LadderWidth(width);
        new LadderHeight(height);
        this.lines = Collections.unmodifiableList(IntStream.range(0, height).boxed()
                            .map(dummy -> new Line(width))
                            .collect(Collectors.toList()));
    }

    public Ladder initLines(Function<Integer, int[]> eval) {
        lines.forEach(line -> line.connect(eval.apply(line.width())));
        return this;
    }

    public LadderDto getDto() {
        return new LadderDto(lines.stream()
                .map(Line::getDto)
                .collect(Collectors.toList()));
    }

    public Trace trace(Trace of) {
        return lines.stream()
                .reduce(of, Trace::move, IDENTITY);
    }

    public TraceResults traceAll(Persons persons, Results results) {
        if (persons.size() != width() || results.size() != width()) {
            throw new IllegalArgumentException("주어진 리스트의 크기가 사다리의 너비와 동일하지 않습니다.");
        }
        TraceResults traceResults = new TraceResults();
        for (int i = 0; i < width(); i++) {
            Trace trace = trace(Trace.of(i));
            Person person = persons.get(i);
            Result result = results.get(trace.get());
            traceResults.putResult(person, result);
        }
        return traceResults;
    }

    public int width() {
        return lines.get(0).width();
    }

    public int height() {
        return lines.size();
    }
}
