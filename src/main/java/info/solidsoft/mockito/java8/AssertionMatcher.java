package info.solidsoft.mockito.java8;

import org.hamcrest.Description;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import java.util.function.Consumer;

public class AssertionMatcher<T> extends ArgumentMatcher<T> {

    private static final LambdaAwareHandyReturnValues handyReturnValues = new LambdaAwareHandyReturnValues();

    private final Consumer<T> consumer;
    private String errorMessage;

    public AssertionMatcher(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean matches(Object argument) {
        try {
            consumer.accept((T) argument);
            return true;
        } catch (AssertionError e) {
            errorMessage = e.getMessage();
            return false;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("AssertionMatcher reported: " + errorMessage);
    }

    public static <T> T assertArg(Consumer<T> consumer) {
        Mockito.argThat(new AssertionMatcher<>(consumer));
        return handyReturnValues.returnForConsumerLambda(consumer);
    }
}
