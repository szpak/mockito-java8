/*
 * Copyright (C) 2015 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8;

import net.jodah.typetools.TypeResolver;
import org.mockito.internal.util.Primitives;

import java.util.function.Consumer;

/**
 * Extended version of HandyReturnValues which can resolve safe return type also for Consumer argument.
 *
 * Under the hood it uses TypeTools library which is used to work also for primitive argument types (to not throw NullPointerException).
 *
 * @author Marcin Zajączkowski
 */
class LambdaAwareHandyReturnValues {

    <T> T returnForConsumerLambda(Consumer<T> consumer) {
        return internalReturnForLambda(consumer, Consumer.class);
    }

    <T> T returnForConsumerLambda(CheckedConsumer<T> checkedConsumer) {
        return internalReturnForLambda(checkedConsumer, CheckedConsumer.class);
    }

    @SuppressWarnings("unchecked")
    private <T> T internalReturnForLambda(Object consumer, Class consumerType) {
        Class<?>[] typeArgs = TypeResolver.resolveRawArguments(consumerType, consumer.getClass());
        return (T) Primitives.defaultValue(typeArgs[0]);
    }
}
