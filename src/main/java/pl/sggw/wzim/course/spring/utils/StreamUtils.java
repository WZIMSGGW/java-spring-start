package pl.sggw.wzim.course.spring.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUtils {
    private StreamUtils() { }

    public static <T, R> List<R> map(Collection<T> collection, Function<? super T, ? extends R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toList());
    }
}
