package cc.oakk.ladder.model;

import org.junit.jupiter.api.Test;

import cc.oakk.ladder.model.line.MutableLine;

import static org.assertj.core.api.Assertions.assertThat;

public class TraceTest {
    @Test
    public void move() {
        Trace trace = new Trace(2);
        MutableLine line = new MutableLine(5);
        line.connect(1);
        trace.move(line);
        assertThat(trace.getCurrentPosition()).isEqualTo(1);
    }
}
