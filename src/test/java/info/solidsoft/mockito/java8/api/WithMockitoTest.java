/*
 * Copyright (C) 2016 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8.api;

import info.solidsoft.mockito.java8.domain.TacticalStation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WithMockitoTest implements WithMockito {

    @Test
    void shouldVerifyMethodExecution() {
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
    void shouldAllowToCreateMockAndStubWithAnswerInClassicStyleWithoutStaticImports() {
        //arrange
        TacticalStation tsMock = mock(TacticalStation.class);
        when(tsMock.getNumberOfTubes()).thenAnswer(i -> 3);
        //act
        int numberOfTubes = tsMock.getNumberOfTubes();
        //assert
        assertThat(numberOfTubes).isEqualTo(3);
    }
}
