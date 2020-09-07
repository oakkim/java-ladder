package cc.oakk.ladder.model;

import cc.oakk.ladder.util.ValidationUtils;

public class MutableLine extends Line {
    public MutableLine(int width) {
        super(width);
    }
    
	public MutableLine connect(int index) {
        ValidationUtils.throwIfOutOfListSize(connections, index);

	    boolean leftConnected = index == 0 ? false : connections.get(index - 1).get();
        boolean rightConnected = index == width.get() - 1 ? false : connections.get(index + 1).get();
        if (leftConnected || rightConnected) {
            throw new IllegalArgumentException("두번 연속해 이을 수 없습니다.");
        }

        connections.get(index).set(true);
        return this;
    }
}
