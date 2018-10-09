/*
 * Copyright (C) 2015 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8;

import info.solidsoft.mockito.java8.domain.ShipSearchCriteria;
import info.solidsoft.mockito.java8.domain.TacticalStation;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static info.solidsoft.mockito.java8.AssertionMatcher.assertArg;
import static info.solidsoft.mockito.java8.AssertionMatcher.assertArgChecked;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)  //MockitoRule is not used to build also Mockito version before 1.10.17
public class AssertionMatcherTest {

    @Mock
    private TacticalStation ts;

    private ShipSearchCriteria searchCriteria = new ShipSearchCriteria(1000, 4);

    @Test
    public void shouldAllowToUseArgumentCaptorInClassicWay() {
        //when
        ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        ArgumentCaptor<ShipSearchCriteria> captor = ArgumentCaptor.forClass(ShipSearchCriteria.class);
        verify(ts).findNumberOfShipsInRangeByCriteria(captor.capture());
        assertThat(captor.getValue().getMinimumRange()).isLessThan(2000);
    }

    @Test
    public void shouldAllowToUseAssertionInLambda() {
        //when
        ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        verify(ts).findNumberOfShipsInRangeByCriteria(assertArg(sc -> assertThat(sc.getMinimumRange()).isLessThan(2000)));
    }

    @Test
    public void shouldAllowToUseAssertionInLambdaWithPrimitiveAsArgument() {
        //when
        ts.fireTorpedo(2);
        //then
        verify(ts).fireTorpedo(assertArg(i -> assertThat(i).isEqualTo(2)));
    }

    @Test
    public void shouldHaveMeaningfulErrorMessage() {
        //when
        ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        ThrowableAssert.ThrowingCallable verifyLambda = () -> {
            verify(ts).findNumberOfShipsInRangeByCriteria(assertArg(sc -> assertThat(sc.getMinimumRange()).isLessThan(50)));
        };
        assertThatThrownBy(verifyLambda)
                .isInstanceOf(AssertionError.class)
                .hasMessageContaining("Argument(s) are different! Wanted:\n" +
                        "ts.findNumberOfShipsInRangeByCriteria(\n" +
                        "    AssertionMatcher reported: \n" +
                        "Expecting:\n" +
                        " <1000>\n" +
                        "to be less than:\n" +
                        " <50> ")
                .hasMessageContaining("Actual invocation has different arguments:\n" +
                        "ts.findNumberOfShipsInRangeByCriteria(\n" +
                        "    ShipSearchCriteria{minimumRange=1000, numberOfPhasers=4}\n" +
                        ");");
    }

    @Test(expected = RuntimeException.class)
    public void shouldWrapAnyExceptionAsRuntimeException() {
        //when
        ts.fireTorpedo(2);
        //then
        verify(ts).fireTorpedo(assertArgChecked(i -> { throw new Exception("assertion failed"); }));
    }
}
