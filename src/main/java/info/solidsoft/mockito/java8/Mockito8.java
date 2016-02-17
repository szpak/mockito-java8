package info.solidsoft.mockito.java8;

import info.solidsoft.mockito.java8.internal.stubbing.defaultanswers.ReturnsJava8EmptyValues;
import org.mockito.Answers;
import org.mockito.Incubating;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.internal.stubbing.defaultanswers.ReturnsMoreEmptyValues;
import org.mockito.stubbing.Answer;

@Incubating
public class Mockito8 {

    /**
     * Optional <code>Answer</code> to be used with {@link Mockito#mock(Class, Answer)}
     * <p>
     * {@link Answer} can be used to define the return values of unstubbed invocations.
     * <p>
     * This implementation is useful when working with Java 8 specific classes (like Optional).
     * <p>
     * ReturnsJava8EmptyValues first tries to return ordinary return values (see {@link ReturnsMoreEmptyValues})
     * then it tries to return predefined return values for Java 8+ specific classes. In other case null is returned.
     * <p>
     * Due to immutable specifics of enum, {@link Answers} cannot be extended from the 3rd-party library and
     * ReturnsJava8EmptyValues cannot be used with {@link Mock} annotation. As a workaround ReturnsJava8EmptyValues
     * can be set as a default answer for unstubbed calls for the whole project. See {@link IMockitoConfiguration} or
     * <a href="https://solidsoft.wordpress.com/2012/07/02/beyond-the-mockito-refcard-part-1-a-better-error-message-on-npe-with-globally-configured-smartnull/">
     * this blog entry</a>.
     */
    public static final Answer<Object> RETURNS_JAVA8_EMPTY_VALUES = new ReturnsJava8EmptyValues();
}
