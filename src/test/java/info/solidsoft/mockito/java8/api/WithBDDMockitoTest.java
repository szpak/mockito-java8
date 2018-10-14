/*
 * Copyright (C) 2016 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8.api;

import info.solidsoft.mockito.java8.domain.TacticalStation;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WithBDDMockitoTest implements WithBDDMockito {

    @Test
    void shouldAllowToCreateMockAndStubWithAnswerInClassicStyleWithoutStaticImports() {
        //given
        TacticalStation tsMock = mock(TacticalStation.class);
        given(tsMock.getNumberOfTubes()).willAnswer(i -> 3);
        //when
        int numberOfTubes = tsMock.getNumberOfTubes();
        //then
        assertThat(numberOfTubes).isEqualTo(3);
    }

    @Test
    void shouldVerifyMethodExecutionWithBasicMatcherWithoutStaticImports() {
        //given
        TacticalStation tsSpy = spy(TacticalStation.class);
        willDoNothing().given(tsSpy).fireTorpedo(anyInt());
        //when
        tsSpy.fireTorpedo(2);
        tsSpy.fireTorpedo(2);
        //then
        then(tsSpy).should(times(2)).fireTorpedo(2);
    }

    @Test //Issue #7
    void shouldProperlyCallVarargsMethod() throws IOException {
        //given
        BufferedWriter writerMock = mock(BufferedWriter.class);
        //when
        willThrow(new IOException()).given(writerMock).write(anyString());
        //then
        assertThatThrownBy(() -> writerMock.write("should throw IOException"))
                .isInstanceOf(IOException.class);
    }
}
