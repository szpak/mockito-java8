/**
 * Copyright (C) 2015 Mockito contributors.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8.api;

import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;

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
     * Delegates call to {@link Matchers#anyBoolean())}.
     */
    default boolean anyBoolean() {
        return Matchers.anyBoolean();
    }

    /**
     * Delegates call to {@link Matchers#anyByte())}.
     */
    default byte anyByte() {
        return Matchers.anyByte();
    }

    /**
     * Delegates call to {@link Matchers#anyChar())}.
     */
    default char anyChar() {
        return Matchers.anyChar();
    }

    /**
     * Delegates call to {@link Matchers#anyInt())}.
     */
    default int anyInt() {
        return Matchers.anyInt();
    }

    /**
     * Delegates call to {@link Matchers#anyLong())}.
     */
    default long anyLong() {
        return Matchers.anyLong();
    }

    /**
     * Delegates call to {@link Matchers#anyFloat())}.
     */
    default float anyFloat() {
        return Matchers.anyFloat();
    }

    /**
     * Delegates call to {@link Matchers#anyDouble())}.
     */
    default double anyDouble() {
        return Matchers.anyDouble();
    }

    /**
     * Delegates call to {@link Matchers#anyShort())}.
     */
    default short anyShort() {
        return Matchers.anyShort();
    }

    /**
     * Delegates call to {@link Matchers#anyObject())}.
     */
    default <T> T anyObject() {
        return Matchers.anyObject();
    }

    /**
     * Delegates call to {@link Matchers#anyVararg())}.
     */
    default <T> T anyVararg() {
        return Matchers.anyVararg();
    }

    /**
     * Delegates call to {@link Matchers#any(Class)}.
     */
    default <T> T any(Class<T> clazz) {
        return Matchers.any(clazz);
    }

    /**
     * Delegates call to {@link Matchers#any())}.
     */
    default <T> T any() {
        return Matchers.any();
    }

    /**
     * Delegates call to {@link Matchers#anyString())}.
     */
    default String anyString() {
        return Matchers.anyString();
    }

    /**
     * Delegates call to {@link Matchers#anyList())}.
     */
    default List anyList() {
        return Matchers.anyList();
    }

    /**
     * Delegates call to {@link Matchers#anyListOf(Class)}.
     */
    default <T> List<T> anyListOf(Class<T> clazz) {
        return Matchers.anyListOf(clazz);
    }

    /**
     * Delegates call to {@link Matchers#anySet())}.
     */
    default Set anySet() {
        return Matchers.anySet();
    }

    /**
     * Delegates call to {@link Matchers#anySetOf(Class)}.
     */
    default <T> Set<T> anySetOf(Class<T> clazz) {
        return Matchers.anySetOf(clazz);
    }

    /**
     * Delegates call to {@link Matchers#anyMap())}.
     */
    default Map anyMap() {
        return Matchers.anyMap();
    }

    /**
     * Delegates call to {@link Matchers#anyMapOf(Class, Class)}.
     */
    default <K, V>  Map<K, V> anyMapOf(Class<K> keyClazz, Class<V> valueClazz) {
        return Matchers.anyMapOf(keyClazz, valueClazz);
    }

    /**
     * Delegates call to {@link Matchers#anyCollection())}.
     */
    default Collection anyCollection() {
        return Matchers.anyCollection();
    }

    /**
     * Delegates call to {@link Matchers#anyCollectionOf(Class)}.
     */
    default <T> Collection<T> anyCollectionOf(Class<T> clazz) {
        return Matchers.anyCollectionOf(clazz);
    }

    /**
     * Delegates call to {@link Matchers#isA(Class)}.
     */
    default <T> T isA(Class<T> clazz) {
        return Matchers.isA(clazz);
    }

    /**
     * Delegates call to {@link Matchers#eq(boolean)}.
     */
    default boolean eq(boolean value) {
        return Matchers.eq(value);
    }

    /**
     * Delegates call to {@link Matchers#eq(byte)}.
     */
    default byte eq(byte value) {
        return Matchers.eq(value);
    }

    /**
     * Delegates call to {@link Matchers#eq(char)}.
     */
    default char eq(char value) {
        return Matchers.eq(value);
    }

    /**
     * Delegates call to {@link Matchers#eq(double)}.
     */
    default double eq(double value) {
        return Matchers.eq(value);
    }

    /**
     * Delegates call to {@link Matchers#eq(float)}.
     */
    default float eq(float value) {
        return Matchers.eq(value);
    }

    /**
     * Delegates call to {@link Matchers#eq(int)}.
     */
    default int eq(int value) {
        return Matchers.eq(value);
    }

    /**
     * Delegates call to {@link Matchers#eq(long)}.
     */
    default long eq(long value) {
        return Matchers.eq(value);
    }

    /**
     * Delegates call to {@link Matchers#eq(short)}.
     */
    default short eq(short value) {
        return Matchers.eq(value);
    }

    /**
     * Delegates call to {@link Matchers#eq(T)}.
     */
    default <T> T eq(T value) {
        return Matchers.eq(value);
    }

    /**
     * Delegates call to {@link Matchers#refEq(T, String...))}.
     */
    default <T> T refEq(T value, String... excludeFields) {
        return Matchers.refEq(value, excludeFields);
    }

    /**
     * Delegates call to {@link Matchers#same(T)}.
     */
    default <T> T same(T value) {
        return Matchers.same(value);
    }

    /**
     * Delegates call to {@link Matchers#isNull())}.
     */
    default Object isNull() {
        return Matchers.isNull();
    }

    /**
     * Delegates call to {@link Matchers#isNull(Class)}.
     */
    default <T> T isNull(Class<T> clazz) {
        return Matchers.isNull(clazz);
    }

    /**
     * Delegates call to {@link Matchers#notNull())}.
     */
    default Object notNull() {
        return Matchers.notNull();
    }

    /**
     * Delegates call to {@link Matchers#notNull(Class)}.
     */
    default <T> T notNull(Class<T> clazz) {
        return Matchers.notNull(clazz);
    }

    /**
     * Delegates call to {@link Matchers#isNotNull())}.
     */
    default Object isNotNull() {
        return Matchers.isNotNull();
    }

    /**
     * Delegates call to {@link Matchers#isNotNull(Class)}.
     */
    default <T> T isNotNull(Class<T> clazz) {
        return Matchers.isNotNull(clazz);
    }

    /**
     * Delegates call to {@link Matchers#contains(String)}.
     */
    default String contains(String substring) {
        return Matchers.contains(substring);
    }

    /**
     * Delegates call to {@link Matchers#matches(String)}.
     */
    default String matches(String regex) {
        return Matchers.matches(regex);
    }

    /**
     * Delegates call to {@link Matchers#endsWith(String)}.
     */
    default String endsWith(String suffix) {
        return Matchers.endsWith(suffix);
    }

    /**
     * Delegates call to {@link Matchers#startsWith(String)}.
     */
    default String startsWith(String prefix) {
        return Matchers.startsWith(prefix);
    }

    /**
     * Delegates call to {@link Matchers#argThat(ArgumentMatcher)}.
     */
    default <T> T argThat(ArgumentMatcher<T> matcher) {
        return Matchers.argThat(matcher);
    }

    /**
     * Delegates call to {@link Matchers#charThat(ArgumentMatcher)}.
     */
    default char charThat(ArgumentMatcher<Character> matcher) {
        return Matchers.charThat(matcher);
    }

    /**
     * Delegates call to {@link Matchers#booleanThat(ArgumentMatcher)}.
     */
    default boolean booleanThat(ArgumentMatcher<Boolean> matcher) {
        return Matchers.booleanThat(matcher);
    }

    /**
     * Delegates call to {@link Matchers#byteThat(ArgumentMatcher)}.
     */
    default byte byteThat(ArgumentMatcher<Byte> matcher) {
        return Matchers.byteThat(matcher);
    }

    /**
     * Delegates call to {@link Matchers#shortThat(ArgumentMatcher)}.
     */
    default short shortThat(ArgumentMatcher<Short> matcher) {
        return Matchers.shortThat(matcher);
    }

    /**
     * Delegates call to {@link Matchers#intThat(ArgumentMatcher)}.
     */
    default int intThat(ArgumentMatcher<Integer> matcher) {
        return Matchers.intThat(matcher);
    }

    /**
     * Delegates call to {@link Matchers#longThat(ArgumentMatcher)}.
     */
    default long longThat(ArgumentMatcher<Long> matcher) {
        return Matchers.longThat(matcher);
    }

    /**
     * Delegates call to {@link Matchers#floatThat(ArgumentMatcher)}.
     */
    default float floatThat(ArgumentMatcher<Float> matcher) {
        return Matchers.floatThat(matcher);
    }

    /**
     * Delegates call to {@link Matchers#doubleThat(ArgumentMatcher)}.
     */
    default double doubleThat(ArgumentMatcher<Double> matcher) {
        return Matchers.doubleThat(matcher);
    }
}
