package info.solidsoft.mockito.java8.internal.stubbing.defaultanswers;

import info.solidsoft.mockito.java8.Mockito8;
import info.solidsoft.mockito.java8.api.WithBDDMockito;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class ReturnsJava8EmptyValuesMockTest implements WithBDDMockito, WithAssertions {

    @Test
    public void shouldDelegateCallForGenericClass() {
        //given
        Java8EmptyValuesTestFixture java8mock = mock(Java8EmptyValuesTestFixture.class, Mockito8.RETURNS_JAVA8_EMPTY_VALUES);
        //when
        List<Integer> result = java8mock.returnGenericClass();
        //then
        assertThat(result)
                .isInstanceOf(List.class)
                .isEmpty();
    }

    @Test
    public void shouldReturnEmptyOptionalWhenUnstubbed() {
        //given
        Java8EmptyValuesTestFixture java8mock = mock(Java8EmptyValuesTestFixture.class, Mockito8.RETURNS_JAVA8_EMPTY_VALUES);
        //when
        Optional<String> result = java8mock.returnOptional();
        //then
        assertThat(result)
                .isInstanceOf(Optional.class)
                .isEmpty();
    }

    static class Java8EmptyValuesTestFixture {
        public List<Integer> returnGenericClass() { return null; }
        public Optional<String> returnOptional() { return null; }
    }
}
