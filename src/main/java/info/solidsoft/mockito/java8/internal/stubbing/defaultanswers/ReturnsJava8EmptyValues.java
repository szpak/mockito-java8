package info.solidsoft.mockito.java8.internal.stubbing.defaultanswers;

import info.solidsoft.mockito.java8.Mockito8;
import org.mockito.internal.stubbing.defaultanswers.ReturnsMoreEmptyValues;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.Serializable;
import java.util.Optional;

/**
 * Internal class. Use {@link Mockito8#RETURNS_JAVA8_EMPTY_VALUES} to get an instance.
 */
public class ReturnsJava8EmptyValues implements Answer<Object>, Serializable {

    private static final long serialVersionUID = 6593724319711234347L;

    private final Answer<Object> delegate = new ReturnsMoreEmptyValues();

    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        Object defaultReturnValue = delegate.answer(invocation);
        if (defaultReturnValue != null) {
            return defaultReturnValue;
        }

        Class<?> returnType = invocation.getMethod().getReturnType();
        return returnValueFor(returnType);
    }

    //TODO: Is it worth to implement it as pluggable links in a chain of responsibility pattern?
    private Object returnValueFor(Class<?> type) {
        if (type == Optional.class) {
            return Optional.empty();
        }
        return null;
    }
}
