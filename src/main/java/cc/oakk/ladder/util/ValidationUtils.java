package cc.oakk.ladder.util;

import java.util.List;

public class ValidationUtils {

	public static<T> List<T> throwIfOutOfListSize(List<T> list, int index) {
		if (index < 0 || index > list.size() - 1) {
            throw new IllegalArgumentException("범위를 벗어났습니다.");
        }
        return list;
	}
    
}
