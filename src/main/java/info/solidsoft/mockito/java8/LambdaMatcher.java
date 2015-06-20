package info.solidsoft.mockito.java8;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.util.function.Predicate;

import static org.mockito.Matchers.argThat;

public class LambdaMatcher<T> extends BaseMatcher<T> {

    private final Matcher<T> backendMatcher;

    private LambdaMatcher(Predicate<T> lambda, String description) {
        this.backendMatcher = new BaseMatcher<T>() {
            @SuppressWarnings("unchecked")
            @Override
            public boolean matches(Object item) {
                try {
                    return lambda.test((T)item);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void describeTo(Description hamcrestDesc) {
                hamcrestDesc.appendText(description);
            }
        };
    }

    @Override
    public boolean matches(Object item) {
        return backendMatcher.matches(item);
    }

    @Override
    public void describeTo(Description description) {
        backendMatcher.describeTo(description);
    }

    public static <T> T argLambda(Predicate<T> lambda) {
        return argLambda(lambda, "Inline lambda expression - add description in code to get more detailed error message");
    }

    public static <T> T argLambda(Predicate<T> lambda, String description) {
        return argThat(new LambdaMatcher<>(lambda, description));
    }
}
