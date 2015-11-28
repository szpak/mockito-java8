/**
 * Copyright (C) 2015 Mockito contributors.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8.api;

import org.mockito.AdditionalMatchers;
import org.mockito.Incubating;

/**
 * An entry point to Mockito additional matchers.
 * <p>
 * Created as an alternative approach to static imports. A test class can implement that interface to make methods from
 * {@link AdditionalMatchers} class directly available.
 * <p>
 * Should be used with {@link WithBDDMockito} or {@link WithMockito}.
 *
 * @see WithBDDMockito
 * @see WithMockito
 *
 * @author Marcin Zajączkowski
 * @since 1.0.0
 */
@Incubating
public interface WithAdditionalMatchers {

    /**
     * Delegates call to {@link AdditionalMatchers#geq(Comparable)}.
     */
    default <T extends Comparable<T>> T geq(Comparable<T> value) {
        return AdditionalMatchers.geq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#geq(byte)}.
     */
    default byte geq(byte value) {
        return AdditionalMatchers.geq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#geq(double)}.
     */
    default double geq(double value) {
        return AdditionalMatchers.geq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#geq(float)}.
     */
    default float geq(float value) {
        return AdditionalMatchers.geq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#geq(int)}.
     */
    default int geq(int value) {
        return AdditionalMatchers.geq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#geq(long)}.
     */
    default long geq(long value) {
        return AdditionalMatchers.geq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#geq(short)}.
     */
    default short geq(short value) {
        return AdditionalMatchers.geq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#leq(Comparable)}.
     */
    default <T extends Comparable<T>> T leq(Comparable<T> value) {
        return AdditionalMatchers.leq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#leq(byte)}.
     */
    default byte leq(byte value) {
        return AdditionalMatchers.leq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#leq(double)}.
     */
    default double leq(double value) {
        return AdditionalMatchers.leq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#leq(float)}.
     */
    default float leq(float value) {
        return AdditionalMatchers.leq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#leq(int)}.
     */
    default int leq(int value) {
        return AdditionalMatchers.leq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#leq(long)}.
     */
    default long leq(long value) {
        return AdditionalMatchers.leq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#leq(short)}.
     */
    default short leq(short value) {
        return AdditionalMatchers.leq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#gt(Comparable)}.
     */
    default <T extends Comparable<T>> T gt(Comparable<T> value) {
        return AdditionalMatchers.gt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#gt(byte)}.
     */
    default byte gt(byte value) {
        return AdditionalMatchers.gt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#gt(double)}.
     */
    default double gt(double value) {
        return AdditionalMatchers.gt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#gt(float)}.
     */
    default float gt(float value) {
        return AdditionalMatchers.gt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#gt(int)}.
     */
    default int gt(int value) {
        return AdditionalMatchers.gt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#gt(long)}.
     */
    default long gt(long value) {
        return AdditionalMatchers.gt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#gt(short)}.
     */
    default short gt(short value) {
        return AdditionalMatchers.gt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#lt(Comparable)}.
     */
    default <T extends Comparable<T>> T lt(Comparable<T> value) {
        return AdditionalMatchers.lt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#lt(byte)}.
     */
    default byte lt(byte value) {
        return AdditionalMatchers.lt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#lt(double)}.
     */
    default double lt(double value) {
        return AdditionalMatchers.lt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#lt(float)}.
     */
    default float lt(float value) {
        return AdditionalMatchers.lt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#lt(int)}.
     */
    default int lt(int value) {
        return AdditionalMatchers.lt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#lt(long)}.
     */
    default long lt(long value) {
        return AdditionalMatchers.lt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#lt(short)}.
     */
    default short lt(short value) {
        return AdditionalMatchers.lt(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#cmpEq(Comparable)}.
     */
    default <T extends Comparable<T>> T cmpEq(Comparable<T> value) {
        return AdditionalMatchers.cmpEq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#find(String)}.
     */
    default String find(String regex) {
        return AdditionalMatchers.find(regex);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#aryEq(T[])}.
     */
    default <T> T[] aryEq(T[] value) {
        return AdditionalMatchers.aryEq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#aryEq(short[])}.
     */
    default short[] aryEq(short[] value) {
        return AdditionalMatchers.aryEq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#aryEq(long[])}.
     */
    default long[] aryEq(long[] value) {
        return AdditionalMatchers.aryEq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#aryEq(int[])}.
     */
    default int[] aryEq(int[] value) {
        return AdditionalMatchers.aryEq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#aryEq(float[])}.
     */
    default float[] aryEq(float[] value) {
        return AdditionalMatchers.aryEq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#aryEq(double[])}.
     */
    default double[] aryEq(double[] value) {
        return AdditionalMatchers.aryEq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#aryEq(char[])}.
     */
    default char[] aryEq(char[] value) {
        return AdditionalMatchers.aryEq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#aryEq(byte[])}.
     */
    default byte[] aryEq(byte[] value) {
        return AdditionalMatchers.aryEq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#aryEq(boolean[])}.
     */
    default boolean[] aryEq(boolean[] value) {
        return AdditionalMatchers.aryEq(value);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#and(boolean, boolean)}.
     */
    default boolean and(boolean first, boolean second) {
        return AdditionalMatchers.and(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#and(byte, byte)}.
     */
    default byte and(byte first, byte second) {
        return AdditionalMatchers.and(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#and(char, char)}.
     */
    default char and(char first, char second) {
        return AdditionalMatchers.and(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#and(double, double)}.
     */
    default double and(double first, double second) {
        return AdditionalMatchers.and(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#and(float, float)}.
     */
    default float and(float first, float second) {
        return AdditionalMatchers.and(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#and(int, int)}.
     */
    default int and(int first, int second) {
        return AdditionalMatchers.and(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#and(long, long)}.
     */
    default long and(long first, long second) {
        return AdditionalMatchers.and(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#and(short, short)}.
     */
    default short and(short first, short second) {
        return AdditionalMatchers.and(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#and(T, T)}.
     */
    default <T> T and(T first, T second) {
        return AdditionalMatchers.and(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#or(boolean, boolean)}.
     */
    default boolean or(boolean first, boolean second) {
        return AdditionalMatchers.or(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#or(T, T)}.
     */
    default <T> T or(T first, T second) {
        return AdditionalMatchers.or(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#or(short, short)}.
     */
    default short or(short first, short second) {
        return AdditionalMatchers.or(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#or(long, long)}.
     */
    default long or(long first, long second) {
        return AdditionalMatchers.or(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#or(int, int)}.
     */
    default int or(int first, int second) {
        return AdditionalMatchers.or(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#or(float, float)}.
     */
    default float or(float first, float second) {
        return AdditionalMatchers.or(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#or(double, double)}.
     */
    default double or(double first, double second) {
        return AdditionalMatchers.or(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#or(char, char)}.
     */
    default char or(char first, char second) {
        return AdditionalMatchers.or(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#or(byte, byte)}.
     */
    default byte or(byte first, byte second) {
        return AdditionalMatchers.or(first, second);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#not(T)}.
     */
    default <T> T not(T first) {
        return AdditionalMatchers.not(first);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#not(short)}.
     */
    default short not(short first) {
        return AdditionalMatchers.not(first);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#not(int)}.
     */
    default int not(int first) {
        return AdditionalMatchers.not(first);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#not(long)}.
     */
    default long not(long first) {
        return AdditionalMatchers.not(first);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#not(float)}.
     */
    default float not(float first) {
        return AdditionalMatchers.not(first);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#not(double)}.
     */
    default double not(double first) {
        return AdditionalMatchers.not(first);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#not(char)}.
     */
    default char not(char first) {
        return AdditionalMatchers.not(first);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#not(boolean)}.
     */
    default boolean not(boolean first) {
        return AdditionalMatchers.not(first);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#not(byte)}.
     */
    default byte not(byte first) {
        return AdditionalMatchers.not(first);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#eq(double, double)}.
     */
    default double eq(double value, double delta) {
        return AdditionalMatchers.eq(value, delta);
    }

    /**
     * Delegates call to {@link AdditionalMatchers#eq(float, float)}.
     */
    default float eq(float value, float delta) {
        return AdditionalMatchers.eq(value, delta);
    }
}
