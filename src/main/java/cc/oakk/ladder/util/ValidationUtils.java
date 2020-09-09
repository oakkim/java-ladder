package cc.oakk.ladder.util;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ValidationUtils {
    private ValidationUtils() {
        //no instance
    }

    public static<T> T throwIfNull(T obj) {
        if (Objects.isNull(obj)) {
            throw new IllegalArgumentException("주어진 객체가 null 입니다.");
        }
        return obj;
    }

    public static<T> List<T> throwIfEmptyList(List<T> obj) {
        if (throwIfNull(obj).isEmpty()) {
            throw new IllegalArgumentException("주어진 리스트가 비어있습니다.");
        }
        return obj;
    }

	public static<T> List<T> throwIfOutOfListSize(List<T> list, int index) {
		if (index < 0 || index > list.size() - 1) {
            throw new IllegalArgumentException("범위를 벗어났습니다.");
        }
        return list;
	}

    public static<T> T tryUntilSuccess(Supplier<T> supplier, Consumer<Throwable> onError) {
        try {
            return supplier.get();
        } catch (Exception e) {
            onError.accept(e);
            return tryUntilSuccess(supplier, onError);
        }
    }

}
