/*
 * Copyright (C) 2015 Mockito contributors.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8.api;

import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * An internal interface being an entry point to Mockito basic matchers.
 * <p>
 * Created only to organize internal entry points structure. Basic matchers are transitively available via
 * {@link WithBDDMockito} and {@link WithMockito} interfaces. Additional matcher are available via
 * {@link WithAdditionalMatchers} interface.
 *
 * @see WithAdditionalMatchers
 * @see WithBDDMockito
 * @see WithMockito
 *
 * @author Marcin Zajączkowski
 * @since 1.0.0
 */
interface WithMatchers {

    /**
     * Delegates call to {@link ArgumentMatchers#anyBoolean()}.
     */
    default boolean anyBoolean() {
        return ArgumentMatchers.anyBoolean();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyByte()}.
     */
    default byte anyByte() {
        return ArgumentMatchers.anyByte();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyChar()}.
     */
    default char anyChar() {
        return ArgumentMatchers.anyChar();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyInt()}.
     */
    default int anyInt() {
        return ArgumentMatchers.anyInt();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyLong()}.
     */
    default long anyLong() {
        return ArgumentMatchers.anyLong();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyFloat()}.
     */
    default float anyFloat() {
        return ArgumentMatchers.anyFloat();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyDouble()}.
     */
    default double anyDouble() {
        return ArgumentMatchers.anyDouble();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyShort()}.
     */
    default short anyShort() {
        return ArgumentMatchers.anyShort();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyObject()}.
     *
     * @deprecated This will be removed in Mockito 3.0.
     */
    @Deprecated
    default <T> T anyObject() {
        return ArgumentMatchers.anyObject();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyVararg()}.
     *
     * @deprecated This will be removed in Mockito 3.0.
     */
    @Deprecated
    default <T> T anyVararg() {
        return ArgumentMatchers.anyVararg();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#any(Class)}.
     */
    default <T> T any(Class<T> clazz) {
        return ArgumentMatchers.any(clazz);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#any()}.
     */
    default <T> T any() {
        return ArgumentMatchers.any();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyString()}.
     */
    default String anyString() {
        return ArgumentMatchers.anyString();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyList()}.
     */
    default <T> List<T> anyList() {
        return ArgumentMatchers.anyList();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyListOf(Class)}.
     *
     * @deprecated This will be removed in Mockito 3.0.
     */
    @Deprecated
    default <T> List<T> anyListOf(Class<T> clazz) {
        return ArgumentMatchers.anyListOf(clazz);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anySet()}.
     */
    default <T> Set<T> anySet() {
        return ArgumentMatchers.anySet();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anySetOf(Class)}.
     *
     * @deprecated This will be removed in Mockito 3.0.
     */
    @Deprecated
    default <T> Set<T> anySetOf(Class<T> clazz) {
        return ArgumentMatchers.anySetOf(clazz);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyMap()}.
     */
    default <K, V> Map<K, V> anyMap() {
        return ArgumentMatchers.anyMap();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyMapOf(Class, Class)}.
     *
     * @deprecated This will be removed in Mockito 3.0.
     */
    @Deprecated
    default <K, V>  Map<K, V> anyMapOf(Class<K> keyClazz, Class<V> valueClazz) {
        return ArgumentMatchers.anyMapOf(keyClazz, valueClazz);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyCollection()}.
     */
    default <T> Collection<T> anyCollection() {
        return ArgumentMatchers.anyCollection();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyCollectionOf(Class)}.
     *
     * @deprecated This will be removed in Mockito 3.0.
     */
    @Deprecated
    default <T> Collection<T> anyCollectionOf(Class<T> clazz) {
        return ArgumentMatchers.anyCollectionOf(clazz);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyIterable()}.
     *
     * @since 2.0.0
     */
    default <T> Iterable<T> anyIterable() {
        return ArgumentMatchers.anyIterable();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#anyIterableOf(Class)}.
     *
     * @since 2.0.0
     * @deprecated This will be removed in Mockito 3.0.
     */
    @Deprecated
    default <T> Iterable<T> anyIterableOf(Class<T> clazz) {
        return ArgumentMatchers.anyIterableOf(clazz);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#isA(Class)}.
     */
    default <T> T isA(Class<T> clazz) {
        return ArgumentMatchers.isA(clazz);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#eq(boolean)}.
     */
    default boolean eq(boolean value) {
        return ArgumentMatchers.eq(value);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#eq(byte)}.
     */
    default byte eq(byte value) {
        return ArgumentMatchers.eq(value);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#eq(char)}.
     */
    default char eq(char value) {
        return ArgumentMatchers.eq(value);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#eq(double)}.
     */
    default double eq(double value) {
        return ArgumentMatchers.eq(value);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#eq(float)}.
     */
    default float eq(float value) {
        return ArgumentMatchers.eq(value);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#eq(int)}.
     */
    default int eq(int value) {
        return ArgumentMatchers.eq(value);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#eq(long)}.
     */
    default long eq(long value) {
        return ArgumentMatchers.eq(value);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#eq(short)}.
     */
    default short eq(short value) {
        return ArgumentMatchers.eq(value);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#eq(T)}.
     */
    default <T> T eq(T value) {
        return ArgumentMatchers.eq(value);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#refEq(T, String...)}.
     */
    default <T> T refEq(T value, String... excludeFields) {
        return ArgumentMatchers.refEq(value, excludeFields);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#same(T)}.
     */
    default <T> T same(T value) {
        return ArgumentMatchers.same(value);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#isNull()}.
     */
    default <T> T isNull() {
        return ArgumentMatchers.isNull();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#isNull(Class)}.
     *
     * @deprecated This will be removed in Mockito 3.0.
     */
    @Deprecated
    default <T> T isNull(Class<T> clazz) {
        return ArgumentMatchers.isNull(clazz);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#notNull()}.
     */
    default <T> T notNull() {
        return ArgumentMatchers.notNull();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#notNull(Class)}.
     *
     * @deprecated This will be removed in Mockito 3.0.
     */
    @Deprecated
    default <T> T notNull(Class<T> clazz) {
        return ArgumentMatchers.notNull(clazz);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#isNotNull()}.
     */
    default <T> T isNotNull() {
        return ArgumentMatchers.isNotNull();
    }

    /**
     * Delegates call to {@link ArgumentMatchers#isNotNull(Class)}.
     *
     * @deprecated This will be removed in Mockito 3.0.
     */
    @Deprecated
    default <T> T isNotNull(Class<T> clazz) {
        return ArgumentMatchers.isNotNull(clazz);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#contains(String)}.
     */
    default String contains(String substring) {
        return ArgumentMatchers.contains(substring);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#matches(String)}.
     */
    default String matches(String regex) {
        return ArgumentMatchers.matches(regex);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#endsWith(String)}.
     */
    default String endsWith(String suffix) {
        return ArgumentMatchers.endsWith(suffix);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#startsWith(String)}.
     */
    default String startsWith(String prefix) {
        return ArgumentMatchers.startsWith(prefix);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#argThat(ArgumentMatcher)}.
     */
    default <T> T argThat(ArgumentMatcher<T> matcher) {
        return ArgumentMatchers.argThat(matcher);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#charThat(ArgumentMatcher)}.
     */
    default char charThat(ArgumentMatcher<Character> matcher) {
        return ArgumentMatchers.charThat(matcher);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#booleanThat(ArgumentMatcher)}.
     */
    default boolean booleanThat(ArgumentMatcher<Boolean> matcher) {
        return ArgumentMatchers.booleanThat(matcher);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#byteThat(ArgumentMatcher)}.
     */
    default byte byteThat(ArgumentMatcher<Byte> matcher) {
        return ArgumentMatchers.byteThat(matcher);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#shortThat(ArgumentMatcher)}.
     */
    default short shortThat(ArgumentMatcher<Short> matcher) {
        return ArgumentMatchers.shortThat(matcher);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#intThat(ArgumentMatcher)}.
     */
    default int intThat(ArgumentMatcher<Integer> matcher) {
        return ArgumentMatchers.intThat(matcher);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#longThat(ArgumentMatcher)}.
     */
    default long longThat(ArgumentMatcher<Long> matcher) {
        return ArgumentMatchers.longThat(matcher);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#floatThat(ArgumentMatcher)}.
     */
    default float floatThat(ArgumentMatcher<Float> matcher) {
        return ArgumentMatchers.floatThat(matcher);
    }

    /**
     * Delegates call to {@link ArgumentMatchers#doubleThat(ArgumentMatcher)}.
     */
    default double doubleThat(ArgumentMatcher<Double> matcher) {
        return ArgumentMatchers.doubleThat(matcher);
    }
}
