package cc.oakk.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MutableLineTest {
    @Test
    public void connect() {
        final MutableLine line = new MutableLine(4);
        assertThat(line.isConnected(0)).isEqualTo(Connection.FALSE);
        line.connect(0);
        assertThat(line.isConnected(0)).isEqualTo(Connection.TRUE);
    }

    @Test
    public void connect_ShouldThrow() {
        final MutableLine line = new MutableLine(4);
        line.connect(0);
        assertThatIllegalArgumentException().isThrownBy(() -> line.connect(1));
        assertThatIllegalArgumentException().isThrownBy(() -> line.connect(3));
    }
}