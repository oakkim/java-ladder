package cc.oakk.ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import cc.oakk.ladder.model.size.LadderSize;
import cc.oakk.ladder.util.ValidationUtils;

public class Ladder {
    private final LadderSize size;
    private final List<MutableLine> lines;

    public Ladder(int width, int height) {
        this.size = new LadderSize(width, height);
        this.lines = Collections.unmodifiableList(IntStream.range(0, size.height().get()).boxed()
                            .map(v -> new MutableLine(size.width().get()))
                            .collect(Collectors.toList()));
    }

    public Line getLine(int index) {
        ValidationUtils.throwIfOutOfListSize(lines, index);
        return lines.get(index);
    }
}
