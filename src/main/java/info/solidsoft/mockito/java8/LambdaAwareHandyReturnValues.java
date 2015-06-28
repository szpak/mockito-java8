package info.solidsoft.mockito.java8;

import net.jodah.typetools.TypeResolver;
import org.mockito.internal.progress.HandyReturnValues;

import java.util.function.Consumer;

/**
 * Extended version of HandyReturnValues which can resolve safe return type also for Consumer argument.
 *
 * Under the hood it uses TypeTools library which is used to work also for priomitive argument types (to not throw NullPointerException.
 *
 * @author Marcin Zajączkowski
 */
class LambdaAwareHandyReturnValues extends HandyReturnValues {

    @SuppressWarnings("unchecked")
    public <T> T returnForConsumerLambda(Consumer<T> consumer) {
        Class<?>[] typeArgs = TypeResolver.resolveRawArguments(Consumer.class, consumer.getClass());
        return (T) returnFor(typeArgs[0]);
    }
}
