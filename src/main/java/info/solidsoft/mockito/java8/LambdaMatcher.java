package info.solidsoft.mockito.java8;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.util.function.Predicate;

public class LambdaMatcher<T> extends BaseMatcher<T> {

    private final Matcher<T> backendMatcher;

    public LambdaMatcher(final Predicate<T> lambda, final String desc) {
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
            public void describeTo(Description description) {
                description.appendText(desc);
            }
        };
    }

    public LambdaMatcher(final Predicate<T> lambda) {
        this(lambda, "Inline lambda expression - add description in code to get more detailed error message");
    }

    @Override
    public boolean matches(Object item) {
        return backendMatcher.matches(item);
    }

    @Override
    public void describeTo(Description description) {
        backendMatcher.describeTo(description);
    }
}
