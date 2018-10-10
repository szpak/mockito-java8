/*
 * Copyright (C) 2015 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8;

import info.solidsoft.mockito.java8.domain.ShipSearchCriteria;
import info.solidsoft.mockito.java8.domain.TacticalStation;
import org.assertj.core.api.ThrowableAssert;
import org.hamcrest.CustomMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.internal.hamcrest.HamcrestArgumentMatcher;
import org.mockito.junit.MockitoRule;

import java.io.IOException;

import static info.solidsoft.mockito.java8.LambdaMatcher.argLambda;
import static info.solidsoft.mockito.java8.LambdaMatcher.argLambdaChecked;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.core.Is.isA;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.junit.MockitoJUnit.rule;

public class LambdaMatcherTest {

    private static final String UNEXPECTED_CHECKED_EXCEPTION_MESSAGE = "Unexpected checked exception";

    @Rule
    public MockitoRule rule = rule();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private TacticalStation ts;

    private ShipSearchCriteria searchCriteria = new ShipSearchCriteria(1000, 4);

    @Test
    public void simpleBaseMatcherShouldWork() {
        //when
        int numberOfShips = ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        assertThat(numberOfShips).isZero();
        //and
        verify(ts).findNumberOfShipsInRangeByCriteria(argThat(new ArgumentMatcher<ShipSearchCriteria>() {
            @Override
            public boolean matches(ShipSearchCriteria criteria) {
                return criteria.getMinimumRange() < 2000 && criteria.getNumberOfPhasers() > 2;
            }

            @Override
            public String toString() {
                return "ShipSearchCriteria minimumRange<2000 and numberOfPhasers>2";
            }
        }));
    }

    @Test
    public void customMatcherShouldBeMoreCompact() {
        //when
        int numberOfShips = ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        assertThat(numberOfShips).isZero();
        //and
        verify(ts).findNumberOfShipsInRangeByCriteria(argThat(new HamcrestArgumentMatcher<>(
                new CustomMatcher<ShipSearchCriteria>("ShipSearchCriteria minimumRange<2000 and numberOfPhasers>2") {
                    @Override
                    public boolean matches(Object item) {
                        ShipSearchCriteria criteria = (ShipSearchCriteria) item;
                        return criteria.getMinimumRange() < 2000 && criteria.getNumberOfPhasers() > 2;
                    }
                })));
    }

    @Test
    public void argumentMatcherShouldBeEvenMoreCompact() {
        //when
        int numberOfShips = ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        assertThat(numberOfShips).isZero();
        //and
        verify(ts).findNumberOfShipsInRangeByCriteria(argThat(new MoreThan2ShipsCloserThan2000()));
    }

    //TODO: 2000 -> 2 0 0 0 - useful anywhere? - worth to implement?
    private static class MoreThan2ShipsCloserThan2000 implements ArgumentMatcher<ShipSearchCriteria> {
        @Override
        public boolean matches(ShipSearchCriteria criteria) {
            return criteria.getMinimumRange() < 2000 && criteria.getNumberOfPhasers() > 2;
        }
    }

    @Test
    public void shouldAllowToUseLambdaInMatcher() {
        //when
        int numberOfShips = ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        assertThat(numberOfShips).isZero();
        //and
        verify(ts).findNumberOfShipsInRangeByCriteria(argLambda(c -> c.getMinimumRange() < 2000));
    }

    @Test
    public void shouldAllowToUseLambdaInMatcherWithAdditionalDescription() {
        //when
        int numberOfShips = ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        assertThat(numberOfShips).isZero();
        //and
        verify(ts).findNumberOfShipsInRangeByCriteria(argLambda(c -> c.getMinimumRange() < 2000, "minimum range closer than 2000"));
    }

    @Test
    public void shouldAllowToUseLambdaWithMultipleConditionsInMatcher() {
        //when
        int numberOfShips = ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        assertThat(numberOfShips).isZero();
        //and
        verify(ts).findNumberOfShipsInRangeByCriteria(argLambda(
                c -> c.getMinimumRange() < 2000 && c.getNumberOfPhasers() > 2,
                "ShipSearchCriteria minimumRange<2000 and numberOfPhasers>2"));
    }

    @Test
    public void shouldKeepDescriptionInErrorMessage() {
        //given
        final String DESCRIPTION = "minimum range closer than 100";
        //when
        ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        ThrowableAssert.ThrowingCallable verifyLambda = () -> {
            verify(ts).findNumberOfShipsInRangeByCriteria(argLambda(c -> c.getMinimumRange() < 100, DESCRIPTION));
        };
        assertThatThrownBy(verifyLambda)
                .isInstanceOf(AssertionError.class)
                .hasMessageContaining("Argument(s) are different! Wanted:\n" +
                        "ts.findNumberOfShipsInRangeByCriteria(\n" +
                        "    " + DESCRIPTION + "\n" +
                        ");")
                .hasMessageContaining("Actual invocation has different arguments:\n" +
                        "ts.findNumberOfShipsInRangeByCriteria(\n" +
                        "    ShipSearchCriteria{minimumRange=1000, numberOfPhasers=4}\n" +
                        ");");

    }

    @Test
    public void shouldAcceptLambdaWhichMayThrowCheckedException() throws Exception {
        //when
        int numberOfShips = ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        assertThat(numberOfShips).isZero();
        //and
        verify(ts).findNumberOfShipsInRangeByCriteria(argLambdaChecked(methodDeclaringThrowingCheckedException()));
    }

    @Test
    public void shouldPropagateCheckedExceptionIfThrownInLambda() throws Exception {
        //when
        int numberOfShips = ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        assertThat(numberOfShips).isZero();
        //and
        thrown.expect(RuntimeException.class);  //TODO: Replace with assertThorws() in JUnit 5
        thrown.expectCause(isA(IOException.class));
        thrown.expectMessage(UNEXPECTED_CHECKED_EXCEPTION_MESSAGE);
        verify(ts).findNumberOfShipsInRangeByCriteria(argLambdaChecked(c -> { throw new IOException(UNEXPECTED_CHECKED_EXCEPTION_MESSAGE); }));
    }

    private CheckedPredicate<ShipSearchCriteria> methodDeclaringThrowingCheckedException() throws Exception {
        return c -> c.getMinimumRange() < 2000 && c.getNumberOfPhasers() > 2;
    }
}
