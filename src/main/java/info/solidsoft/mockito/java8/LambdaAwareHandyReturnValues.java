/*
 * Copyright (C) 2015 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8;

import net.jodah.typetools.TypeResolver;
import org.mockito.internal.util.Primitives;

/**
 * Extended version of HandyReturnValues which can resolve safe return type also for Consumer argument.
 *
 * Under the hood it uses TypeTools library which is used to work also for primitive argument types (to not throw NullPointerException).
 *
 * @author Marcin Zajączkowski
 */
class LambdaAwareHandyReturnValues {

    @SuppressWarnings("unchecked")
    <T> T returnForConsumerLambda(CheckedConsumer<T> consumer) {
        Class<?>[] typeArgs = TypeResolver.resolveRawArguments(CheckedConsumer.class, consumer.getClass());
        return (T) Primitives.defaultValue(typeArgs[0]);
    }
}
