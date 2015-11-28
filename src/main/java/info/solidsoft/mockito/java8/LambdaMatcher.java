/**
 * Copyright (C) 2015 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8;

import org.mockito.ArgumentMatcher;

import java.util.function.Predicate;

import static org.mockito.Matchers.argThat;

/**
 * Allows creating inlined argument matcher with a lambda expression.
 * <p>
 * With Java 8 and lambda expressions ArgumentCaptor can be expressed inline:
 *
 * <pre class="code"><code class="java">
 *{@literal @}Test
 * public void shouldAllowToUseLambdaInStubbing() {
 *     //given
 *     given(ts.findNumberOfShipsInRangeByCriteria(argLambda(c -> c.getMinimumRange() > 1000))).willReturn(4);
 *     //expect
 *     assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(1500, 2))).isEqualTo(4);
 *     //expect
 *     assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(700, 2))).isEqualTo(0);
 * }
 * </code></pre>
 * <p>
 * In comparison the same logic implemented with a custom Answer in Java 7:
 *
 * <pre class="code"><code class="java">
 *{@literal @}Test
 * public void stubbingWithCustomAsnwerShouldBeLonger() {  //old way
 *     //given
 *     given(ts.findNumberOfShipsInRangeByCriteria(any())).willAnswer(new Answer<Integer>() {
 *        {@literal @}Override
 *         public Integer answer(InvocationOnMock invocation) throws Throwable {
 *             Object[] args = invocation.getArguments();
 *             ShipSearchCriteria criteria = (ShipSearchCriteria) args[0];
 *             if (criteria.getMinimumRange() > 1000) {
 *                 return 4;
 *             } else {
 *                 return 0;
 *             }
 *         }
 *     });
 *     //expect
 *     assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(1500, 2))).isEqualTo(4);
 *     //expect
 *     assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(700, 2))).isEqualTo(0);
 * }
 * </code></pre>
 * <p>
 * Even Java 8 alone and using less readable constructions produce less compact code:
 *
 * <pre class="code"><code class="java">
 *{@literal @}Test
 * public void stubbingWithCustomAsnwerShouldBeLongerEvenAsLambda() {  //old way
 *     //given
 *     given(ts.findNumberOfShipsInRangeByCriteria(any())).willAnswer(invocation -> {
 *         ShipSearchCriteria criteria = (ShipSearchCriteria) invocation.getArguments()[0];
 *         return criteria.getMinimumRange() > 1000 ? 4 : 0;
 *     });
 *     //expect
 *     assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(1500, 2))).isEqualTo(4);
 *     //expect
 *     assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(700, 2))).isEqualTo(0);
 * }
 * </code></pre>
 *
 * @param <T> type of argument
 *
 * @author Marcin Zajączkowski
 */
public class LambdaMatcher<T> implements ArgumentMatcher<T> {

    private final ArgumentMatcher<T> backendMatcher;    //TODO: Could it be done with just one matcher?

    private LambdaMatcher(Predicate<T> lambda, String description) {
        this.backendMatcher = new ArgumentMatcher<T>() {
            @SuppressWarnings("unchecked")
            @Override
            public boolean matches(Object item) {
                try {
                    return lambda.test((T)item);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public String toString() {
                return description;
            }
        };
    }

    @Override
    public boolean matches(Object item) {
        return backendMatcher.matches(item);
    }

    @Override
    public String toString() {
        return backendMatcher.toString();
    }

    public static <T> T argLambda(Predicate<T> lambda) {
        return argLambda(lambda, "Inline lambda expression - add description in code to get more detailed error message");
    }

    public static <T> T argLambda(Predicate<T> lambda, String description) {
        return argThat(new LambdaMatcher<>(lambda, description));
    }
}
