package Homework19_Optional.common.solutions.utils;

import java.util.Collection;
import java.util.Optional;

public final class CollectionUtils {

    private CollectionUtils() {

    }

    public static void printCollection(Collection<?> collection) {
        for (Object obj : collection) {
            Optional.ofNullable(obj).ifPresent(elem -> System.out.println(obj.toString()));
        }
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }

}
