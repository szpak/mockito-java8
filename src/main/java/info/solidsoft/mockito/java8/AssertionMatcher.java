/*
 * Copyright (C) 2015 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8;

import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

/**
 * Allows creating inlined ArgumentCaptor with a lambda expression.
 * <p>
 * With Java 8 and lambda expressions ArgumentCaptor can be inlined:
 *
 * <pre class="code"><code class="java">
 * {@literal @}Test
 * public void shouldAllowToUseAssertionInLambda() {
 *   //when
 *   ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
 *   //then
 *   verify(ts).findNumberOfShipsInRangeByCriteria(assertArg(sc -> assertThat(sc.getMinimumRange()).isLessThan(2000)));
 * }
 * </code></pre>
 *
 * in comparison to 3 lines in the classic way:
 *
 * <pre class="code"><code class="java">
 * {@literal @}Test
 * public void shouldAllowToUseArgumentCaptorInClassicWay() {  //old way
 *     //when
 *     ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
 *     //then
 *     ArgumentCaptor<ShipSearchCriteria> captor = ArgumentCaptor.forClass(ShipSearchCriteria.class);
 *     verify(ts).findNumberOfShipsInRangeByCriteria(captor.capture());
 *     assertThat(captor.getValue().getMinimumRange()).isLessThan(2000);
 * }
 *
 * AssertJ assertions (assertThat()) used in lambda generate meaningful error messages in face of failure, but any other assertion can be
 * used if needed/preferred.
 *
 * @param <T> type of argument
 *
 * @author Marcin Zajączkowski
 */
public class AssertionMatcher<T> implements ArgumentMatcher<T> {

    private static final LambdaAwareHandyReturnValues handyReturnValues = new LambdaAwareHandyReturnValues();

    private final CheckedConsumer<T> consumer;
    private String errorMessage;

    private AssertionMatcher(CheckedConsumer<T> consumer) {
        this.consumer = consumer;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean matches(T argument) {
        try {
            consumer.accept(argument);
            return true;
        } catch (AssertionError | Exception e) {
            errorMessage = e.getMessage();
            return false;
        }
    }

    @Override
    public String toString() {
        return "AssertionMatcher reported: " + errorMessage;
    }

    public static <T> T assertArg(CheckedConsumer<T> consumer) {
        Mockito.argThat(new AssertionMatcher<>(consumer));
        return handyReturnValues.returnForConsumerLambda(consumer);
    }
}
