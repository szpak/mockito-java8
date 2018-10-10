/*
 * Copyright (C) 2018 Mockito contributors.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8;

import java.util.function.Consumer;

import static info.solidsoft.mockito.java8.SneakyThrow.sneakyRethrow;

@FunctionalInterface
public interface CheckedConsumer<T> {

    void accept(T t) throws Exception;

    default Consumer<T> uncheck() {
        return t -> {
            try {
                this.accept(t);
            } catch (Exception e) {
                sneakyRethrow(e);
            }
        };
    }
}
