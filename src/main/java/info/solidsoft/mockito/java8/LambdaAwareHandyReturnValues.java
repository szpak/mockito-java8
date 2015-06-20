package info.solidsoft.mockito.java8;

import net.jodah.typetools.TypeResolver;
import org.mockito.internal.progress.HandyReturnValues;

import java.util.function.Consumer;

public class LambdaAwareHandyReturnValues extends HandyReturnValues {

    @SuppressWarnings("unchecked")
    public <T> T returnForConsumerLambda(Consumer<T> consumer) {
        Class<?>[] typeArgs = TypeResolver.resolveRawArguments(Consumer.class, consumer.getClass());
        return (T) returnFor(typeArgs[0]);
    }
}
