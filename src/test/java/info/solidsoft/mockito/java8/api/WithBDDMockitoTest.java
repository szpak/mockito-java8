package info.solidsoft.mockito.java8.api;

import info.solidsoft.mockito.java8.domain.TacticalStation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WithBDDMockitoTest implements WithBDDMockito {

    @Test
    public void shouldAllowToCreateMockAndStubWithAnswerInClassicStyleWithoutStaticImports() {
        //given
        TacticalStation tsMock = mock(TacticalStation.class);
        given(tsMock.getNumberOfTubes()).willAnswer(i -> 3);
        //when
        int numberOfTubes = tsMock.getNumberOfTubes();
        //then
        assertThat(numberOfTubes).isEqualTo(3);
    }

    @Test
    public void shouldVerifyMethodExecutionWithBasicMatcherWithoutStaticImports() {
        //given
        TacticalStation tsSpy = spy(TacticalStation.class);
        willDoNothing().given(tsSpy).fireTorpedo(anyInt());
        //when
        tsSpy.fireTorpedo(2);
        tsSpy.fireTorpedo(2);
        //then
        then(tsSpy).should(times(2)).fireTorpedo(2);
    }
}
