/*
 * Copyright (C) 2016 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8.api;

import info.solidsoft.mockito.java8.domain.TacticalStation;
import org.junit.jupiter.api.Test;

import static info.solidsoft.mockito.java8.domain.TacticalStation.TubeStatus.LOADED;
import static org.assertj.core.api.Assertions.assertThat;

class WithMockitoAndAdditionalMatchersTest implements WithBDDMockito, WithAdditionalMatchers {

    @Test
    void shouldAllowToCreateSpyStubAndVerifyWithMatcherWithoutStaticImports() {
        //given
        TacticalStation tsSpy = spy(TacticalStation.class);
        willDoNothing().given(tsSpy).fireTorpedo(lt(3));
        //when
        tsSpy.fireTorpedo(2);
        //then
        verify(tsSpy, atLeastOnce()).fireTorpedo(2);
    }

    @Test
    void shouldAllowToCreateMockAndStubWithoutStaticImports() {
        //given
        TacticalStation tsMock = mock(TacticalStation.class);
        given(tsMock.getTubeStatus(geq(2))).willReturn(LOADED);
        //when
        TacticalStation.TubeStatus numberOfTubes = tsMock.getTubeStatus(2);
        //then
        assertThat(numberOfTubes).isEqualTo(LOADED);
    }

    @Test
    void shouldVerifyMethodExecutionToAdditionalMatcherWithoutStaticImports() {
        //given
        TacticalStation tsSpy = spy(TacticalStation.class);
        willDoNothing().given(tsSpy).fireTorpedo(2);
        //when
        tsSpy.fireTorpedo(2);
        tsSpy.fireTorpedo(2);
        //then
        then(tsSpy).should(times(2)).fireTorpedo(and(gt(1), lt(3)));
    }
}
