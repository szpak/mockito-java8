package info.solidsoft.mockito.java8;

@FunctionalInterface
public interface CheckedPredicate<T> {
    boolean test(T var1) throws Exception;
}
