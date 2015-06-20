package info.solidsoft.mockito.java8;

import info.solidsoft.mockito.java8.domain.ShipSearchCriteria;
import info.solidsoft.mockito.java8.domain.TacticalStation;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static info.solidsoft.mockito.java8.AssertionMatcher.assertArg;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.verify;

public class AssertionMatcherTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private TacticalStation ts;

    @Test
    public void shouldAllowToUseArgumentCaptorInClassicWay() {
        //given
        ShipSearchCriteria searchCriteria = new ShipSearchCriteria(1000, 4);
        //when
        ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        ArgumentCaptor<ShipSearchCriteria> captor = ArgumentCaptor.forClass(ShipSearchCriteria.class);
        verify(ts).findNumberOfShipsInRangeByCriteria(captor.capture());
        assertThat(captor.getValue().getMinimumRange()).isLessThan(2000);
    }

    @Test
    public void shouldAllowToUseAssertionInLambda() {
        //given
        ShipSearchCriteria searchCriteria = new ShipSearchCriteria(1000, 4);
        //when
        ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        verify(ts).findNumberOfShipsInRangeByCriteria(assertArg(sc -> assertThat(sc.getMinimumRange()).isLessThan(2000)));
    }

    @Test
    @Ignore //TODO: Implement it with https://github.com/jhalterman/typetools
    public void shouldAllowToUseAssertionInLambdaWithPrimitiveAsArgument() {
        //when
        ts.fireTorpedo(2);
        //then
        verify(ts).fireTorpedo(assertArg(i -> assertThat(i).isEqualTo(2)));
    }
}
