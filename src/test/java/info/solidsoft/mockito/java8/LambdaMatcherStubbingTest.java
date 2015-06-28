/**
 * Copyright (C) 2015 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8;

import info.solidsoft.mockito.java8.domain.ShipSearchCriteria;
import info.solidsoft.mockito.java8.domain.TacticalStation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static info.solidsoft.mockito.java8.LambdaMatcher.argLambda;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class LambdaMatcherStubbingTest {

    @Mock
    private TacticalStation ts;

    @Test
    public void shouldAllowToUseLambdaInStubbing() {
        //given
        given(ts.findNumberOfShipsInRangeByCriteria(argLambda(c -> c.getMinimumRange() > 1000))).willReturn(4);
        //expect
        assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(1500, 2))).isEqualTo(4);
        //expect
        assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(700, 2))).isEqualTo(0);
    }

    @Test
    public void stubbingWithCustomAnswerShouldBeLonger() {
        //given
        given(ts.findNumberOfShipsInRangeByCriteria(any())).willAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                ShipSearchCriteria criteria = (ShipSearchCriteria) args[0];
                if (criteria.getMinimumRange() > 1000) {
                    return 4;
                } else {
                    return 0;
                }
            }
        });
        //expect
        assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(1500, 2))).isEqualTo(4);
        //expect
        assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(700, 2))).isEqualTo(0);
    }

    @Test
    public void stubbingWithCustomAnswerShouldBeLongerEvenAsLambda() {
        //given
        given(ts.findNumberOfShipsInRangeByCriteria(any())).willAnswer(invocation -> {
            ShipSearchCriteria criteria = (ShipSearchCriteria) invocation.getArguments()[0];
            return criteria.getMinimumRange() > 1000 ? 4 : 0;
        });
        //expect
        assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(1500, 2))).isEqualTo(4);
        //expect
        assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(700, 2))).isEqualTo(0);
    }
}
