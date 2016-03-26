/**
 * Copyright (C) 2015 Mockito contributors.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8.api;

import org.mockito.InOrder;
import org.mockito.Incubating;
import org.mockito.MockSettings;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.DeprecatedOngoingStubbing;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;
import org.mockito.verification.VerificationAfterDelay;
import org.mockito.verification.VerificationMode;
import org.mockito.verification.VerificationWithTimeout;

/**
 * An entry point to classic Mockito stubbing/mocking API with basic matchers.
 * <p>
 * Created as an alternative approach to static imports. A test class can implement that interface to make all
 * the methods from {@link Mockito} class directly available.
 *
 * <p>
 * Sample test in Arrange-Act-Assert style:
 *
 * <pre class="code"><code class="java">
 * //no static Mockito imports needed!
 *
 * class ShopTest implements WithMockito {
 *
 *   private Seller seller = mock(Seller.class);
 *   private Shop shop = new Shop(seller);
 *
 *   public void shouldBuyBread() {
 *     //arrange
 *     when(seller.askForBread()).thenReturn(new Bread());
 *     //act
 *     Goods goods = shop.buyBread();
 *     //assert
 *     assertThat(goods.containBread()).isTrue();
 *   }
 * }
 * </code></pre>
 *
 * Mock verification can be then performed with {@link Mockito#verify(Object)} method:
 *
 * <pre class="code"><code class="java">
 *   person.ride(bike);
 *   person.ride(bike);
 *
 *   verify(person, times(2)).ride(bike);
 *   verifyNoMoreInteractions(police);
 * </code></pre>
 * <p>
 * In many cases Behavior-driven development style may be preferred. See {@link WithBDDMockito} how it can be used
 * with Mockito.
 * <p>
 * If more sophisticated matchers are needed see {@link WithAdditionalMatchers} interface.
 * <p>
 * Based on an idea proposed by David Gageot:
 * http://blog.javabien.net/2014/04/23/what-if-assertj-used-java-8/
 *
 * @see WithBDDMockito
 * @see WithAdditionalMatchers
 *
 * @author Marcin Zajączkowski
 * @since 1.0.0
 */
@Incubating
public interface WithMockito extends WithMatchers {

    /**
     * Delegates call to {@link Mockito#mock(Class)}.
     */
    default <T> T mock(Class<T> classToMock) {
        return Mockito.mock(classToMock);
    }

    /**
     * Delegates call to {@link Mockito#mock(Class, String)}.
     */
    default <T> T mock(Class<T> classToMock, String name) {
        return Mockito.mock(classToMock, name);
    }

    /**
     * Delegates call to {@link Mockito#mockingDetails(Object)}.
     */
    default MockingDetails mockingDetails(Object toInspect) {
        return Mockito.mockingDetails(toInspect);
    }

    /**
     * Delegates call to {@link Mockito#mock(Class, Answer)}.
     */
    default <T> T mock(Class<T> classToMock, Answer defaultAnswer) {
        return Mockito.mock(classToMock, defaultAnswer);
    }

    /**
     * Delegates call to {@link Mockito#mock(Class, MockSettings)}.
     */
    default <T> T mock(Class<T> classToMock, MockSettings mockSettings) {
        return Mockito.mock(classToMock, mockSettings);
    }

    /**
     * Delegates call to {@link Mockito#spy(Object)}.
     */
    default <T> T spy(T object) {
        return Mockito.spy(object);
    }

    /**
     * Delegates call to {@link Mockito#spy(Class)}.
     */
    @Incubating
    default <T> T spy(Class<T> classToSpy) {
        return Mockito.spy(classToSpy);
    }

    /**
     * Delegates call to {@link Mockito#stub(Object)}.
     */
    default <T> DeprecatedOngoingStubbing<T> stub(T methodCall) {
        return Mockito.stub(methodCall);
    }

    /**
     * Delegates call to {@link Mockito#when(Object)}.
     */
    default <T> OngoingStubbing<T> when(T methodCall) {
        return Mockito.when(methodCall);
    }

    /**
     * Delegates call to {@link Mockito#verify(Object)}.
     */
    default <T> T verify(T mock) {
        return Mockito.verify(mock, times(1));
    }

    /**
     * Delegates call to {@link Mockito#verify(Object, VerificationMode)}.
     */
    default <T> T verify(T mock, VerificationMode mode) {
        return Mockito.verify(mock, mode);
    }

    /**
     * Delegates call to {@link Mockito#reset(Object[])}.
     */
    default <T> void reset(T ... mocks) {
        Mockito.reset(mocks);
    }

    /**
     * Delegates call to {@link Mockito#verifyNoMoreInteractions(Object...)}.
     */
    default void verifyNoMoreInteractions(Object... mocks) {
        Mockito.verifyNoMoreInteractions(mocks);
    }

    /**
     * Delegates call to {@link Mockito#verifyZeroInteractions(Object...)}.
     */
    default void verifyZeroInteractions(Object... mocks) {
        Mockito.verifyNoMoreInteractions(mocks);
    }

    /**
     * Delegates call to {@link Mockito#doThrow(Throwable...)}.
     */
    default Stubber doThrow(Throwable... toBeThrown) {
        return Mockito.doThrow(toBeThrown);
    }

    /**
     * Delegates call to {@link Mockito#doThrow(Class)}.
     */
    default Stubber doThrow(Class<? extends Throwable> toBeThrown) {
        return Mockito.doThrow(toBeThrown);
    }

    /**
     * Delegates call to {@link Mockito#doCallRealMethod()}.
     */
    default Stubber doCallRealMethod() {
        return Mockito.doCallRealMethod();
    }

    /**
     * Delegates call to {@link Mockito#doAnswer(Answer)}.
     */
    default Stubber doAnswer(Answer answer) {
        return Mockito.doAnswer(answer);
    }

    /**
     * Delegates call to {@link Mockito#doNothing()}.
     */
    default Stubber doNothing() {
        return Mockito.doNothing();
    }

    /**
     * Delegates call to {@link Mockito#doReturn(Object)}.
     */
    default Stubber doReturn(Object toBeReturned) {
        return Mockito.doReturn(toBeReturned);
    }

    /**
     * Delegates call to {@link Mockito#doReturn(Object, Object...)}.
     */
    default Stubber doReturn(Object toBeReturned, Object... toBeReturnedNext) {
        return Mockito.doReturn(toBeReturned, toBeReturnedNext);
    }

    /**
     * Delegates call to {@link Mockito#inOrder(Object...)}.
     */
    default InOrder inOrder(Object... mocks) {
        return Mockito.inOrder(mocks);
    }

    /**
     * Delegates call to {@link Mockito#ignoreStubs(Object...)}.
     */
    default Object[] ignoreStubs(Object... mocks) {
        return Mockito.ignoreStubs(mocks);
    }

    /**
     * Delegates call to {@link Mockito#times(int)}.
     */
    default VerificationMode times(int wantedNumberOfInvocations) {
        return Mockito.times(wantedNumberOfInvocations);
    }

    /**
     * Delegates call to {@link Mockito#never()}.
     */
    default VerificationMode never() {
        return Mockito.never();
    }

    /**
     * Delegates call to {@link Mockito#atLeastOnce()}.
     */
    default VerificationMode atLeastOnce() {
        return Mockito.atLeastOnce();
    }

    /**
     * Delegates call to {@link Mockito#atLeast(int)}.
     */
    default VerificationMode atLeast(int minNumberOfInvocations) {
        return Mockito.atLeast(minNumberOfInvocations);
    }

    /**
     * Delegates call to {@link Mockito#atMost(int)}.
     */
    default VerificationMode atMost(int maxNumberOfInvocations) {
        return Mockito.atMost(maxNumberOfInvocations);
    }

    /**
     * Delegates call to {@link Mockito#calls(int)}.
     */
    default VerificationMode calls(int wantedNumberOfInvocations){
        return Mockito.calls(wantedNumberOfInvocations);
    }

    /**
     * Delegates call to {@link Mockito#only()}.
     */
    default VerificationMode only() {
    	return Mockito.only();
    }

    /**
     * Delegates call to {@link Mockito#timeout(long)}.
     */
    default VerificationWithTimeout timeout(long millis) {
        return Mockito.timeout(millis);
    }

    /**
     * Delegates call to {@link Mockito#after(long)}.
     */
    default VerificationAfterDelay after(long millis) {
        return Mockito.after(millis);
    }

    /**
     * Delegates call to {@link Mockito#validateMockitoUsage()}.
     */
    default void validateMockitoUsage() {
        Mockito.validateMockitoUsage();
    }

    /**
     * Delegates call to {@link Mockito#withSettings()}.
     */
    default MockSettings withSettings() {
        return Mockito.withSettings();
    }

    /**
     * Delegates call to {@link Mockito#description(String)}.
     *
     * @since 2.0.0
     */
    default VerificationMode description(String description) {
        return Mockito.description(description);
    }
}
