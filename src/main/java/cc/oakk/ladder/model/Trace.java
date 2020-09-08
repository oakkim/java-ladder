package cc.oakk.ladder.model;

import java.util.Objects;

import cc.oakk.ladder.model.line.Line;

public class Trace {
    private int currentPosition;

    public Trace(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Trace move(Line line) {
        if (line.isMoveableToLeft(currentPosition)) {
            currentPosition -= 1;
            return this;
        }
        
        if (line.isMoveableToRight(currentPosition)) {
            currentPosition += 1;
            return this;
        }
        return this;
    }

	public int getCurrentPosition() {
		return currentPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Trace)) {
            return false;
        }
        Trace trace = (Trace) o;
        return currentPosition == trace.currentPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPosition);
    }
}
