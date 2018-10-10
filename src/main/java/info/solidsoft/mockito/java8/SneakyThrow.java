/*
 * Copyright (C) 2018 Mockito contributors.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8;

class SneakyThrow {

    /**
     * A hack to trick the compiler to accept a lack of a declaration of checked exception in a caller.
     *
     * Based on the idea presented by Grzegorz Piwowarek in his presentation: The Dark Side of Java 8.
     */
    @SuppressWarnings("unchecked")
    static <R, E extends Exception> R sneakyRethrow(Exception e) throws E {
        throw (E) e;
    }
}
