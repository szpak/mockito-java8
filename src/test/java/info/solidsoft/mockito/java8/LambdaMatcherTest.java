package info.solidsoft.mockito.java8;

import info.solidsoft.mockito.java8.domain.ShipSearchCriteria;
import info.solidsoft.mockito.java8.domain.TacticalStation;
import org.hamcrest.BaseMatcher;
import org.hamcrest.CustomMatcher;
import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static info.solidsoft.mockito.java8.LambdaMatcher.argLambda;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.verify;

public class LambdaMatcherTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

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
        verify(ts).findNumberOfShipsInRangeByCriteria(argThat(new BaseMatcher<ShipSearchCriteria>() {
            @Override
            public boolean matches(Object item) {
                ShipSearchCriteria criteria = (ShipSearchCriteria) item;
                return criteria.getMinimumRange() < 2000 && criteria.getNumberOfPhasers() > 2;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("ShipSearchCriteria minimumRange<2000 and numberOfPhasers>2");
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
        verify(ts).findNumberOfShipsInRangeByCriteria(argThat(new CustomMatcher<ShipSearchCriteria>("ShipSearchCriteria minimumRange<2000 and numberOfPhasers>2") {
            @Override
            public boolean matches(Object item) {
                ShipSearchCriteria criteria = (ShipSearchCriteria) item;
                return criteria.getMinimumRange() < 2000 && criteria.getNumberOfPhasers() > 2;
            }
        }));
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
    private static class MoreThan2ShipsCloserThan2000 extends ArgumentMatcher<ShipSearchCriteria> {
        @Override
        public boolean matches(Object item) {
            ShipSearchCriteria criteria = (ShipSearchCriteria) item;
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

    //TODO: Test error messages
    //TODO: Get lambda content?
}
