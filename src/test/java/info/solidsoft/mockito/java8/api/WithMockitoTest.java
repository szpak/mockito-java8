package info.solidsoft.mockito.java8.api;

import info.solidsoft.mockito.java8.domain.TacticalStation;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WithMockitoTest implements WithMockito {

    @Test
    public void shouldVerifyMethodExecution() {
        //arrange
        TacticalStation tsSpy = spy(TacticalStation.class);
        doNothing().when(tsSpy).fireTorpedo(2);
        //act
        tsSpy.fireTorpedo(2);
        tsSpy.fireTorpedo(2);
        //assert
        verify(tsSpy, times(2)).fireTorpedo(2);
    }

    @Test
    public void shouldAllowToCreateMockAndStubWithAnswerInClassicStyleWithoutStaticImports() {
        //arrange
        TacticalStation tsMock = mock(TacticalStation.class);
        when(tsMock.getNumberOfTubes()).thenAnswer(i -> 3);
        //act
        int numberOfTubes = tsMock.getNumberOfTubes();
        //assert
        assertThat(numberOfTubes).isEqualTo(3);
    }
}
