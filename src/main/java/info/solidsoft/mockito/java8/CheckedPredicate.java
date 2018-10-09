/*
 * Copyright (C) 2018 Mockito contributors.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8;

import java.util.function.Predicate;

@FunctionalInterface
public interface CheckedPredicate<T> {

    boolean test(T t) throws Exception;

    default Predicate<T> uncheck() {
        return this::trickCompilerToAcceptLackOfDeclarationOfCheckedException;
    }

    /**
     * A hack to trick the compiler to accept a lack of a declaration of checked exception in a caller.
     *
     * Based on the idea presented by Grzegorz Piwowarek in his presentation: The Dark Side of Java 8.
     */
    @SuppressWarnings("unchecked")
    /*private */ default <E extends Exception> boolean trickCompilerToAcceptLackOfDeclarationOfCheckedException(T t) throws E {
        try {
            return this.test(t);
        } catch (Exception e) {
            throw (E) e;
        }
    }
}
