package cc.oakk.ladder.model.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void width() {
        assertThat(new Line(4).width()).isEqualTo(4);
        assertThat(new Line(5).width()).isEqualTo(5);
        assertThat(new Line(6).width()).isEqualTo(6);
        assertThat(new Line(7).width()).isEqualTo(7);
    }

    @Test
    public void isMoveableToLeft() {
        MutableLine line = new MutableLine(5);
        line.connect(0, 2);

        assertThat(line.isMoveableToLeft(0)).isFalse();
        assertThat(line.isMoveableToLeft(1)).isTrue();
        assertThat(line.isMoveableToLeft(2)).isFalse();
        assertThat(line.isMoveableToLeft(3)).isTrue();
        assertThat(line.isMoveableToLeft(4)).isFalse();
    }

    @Test
    public void isMoveableToRight() {
        MutableLine line = new MutableLine(5);
        line.connect(0, 2);

        assertThat(line.isMoveableToRight(0)).isTrue();
        assertThat(line.isMoveableToRight(1)).isFalse();
        assertThat(line.isMoveableToRight(2)).isTrue();
        assertThat(line.isMoveableToRight(3)).isFalse();
        assertThat(line.isMoveableToRight(4)).isFalse();
    }
}