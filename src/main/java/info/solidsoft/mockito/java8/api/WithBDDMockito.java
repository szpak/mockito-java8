/**
 * Copyright (C) 2015 Mockito contributors.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8.api;

import org.mockito.BDDMockito;
import org.mockito.Incubating;
import org.mockito.stubbing.Answer;

/**
 * An entry point to Mockito stubbing/mocking API in BDD style with basic matchers.
 * <p>
 * Created as an alternative approach to static imports. A test class can implement that interface to make all
 * the methods from {@link BDDMockito} class directly available.
 * <p>
 * Sample test in Behavior-driven development style:
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
 *     //given
 *     given(seller.askForBread()).willReturn(new Bread());
 *     //when
 *     Goods goods = shop.buyBread();
 *     //then
 *     assertThat(goods.containBread()).isTrue();
 *   }
 * }
 * </code></pre>
 * <p>
 *
 * For BDD style mock verification {@link BDDMockito.Then} can be used:
 * <pre class="code"><code class="java">
 *   person.ride(bike);
 *   person.ride(bike);
 *
 *   then(person).should(times(2)).ride(bike);
 *   then(police).shouldHaveZeroInteractions();
 * </code></pre>
 *
 * See {@link WithMockito} if Arrange-Act-Assert approach is preferred over BDD.
 * <p>
 * If more sophisticated matchers are needed see {@link WithAdditionalMatchers} interface.
 * <p>
 * Based on an idea proposed by David Gageot:
 * http://blog.javabien.net/2014/04/23/what-if-assertj-used-java-8/
 *
 * @see WithMockito
 * @see WithAdditionalMatchers
 *
 * @author Marcin Zajączkowski
 * @since 1.0.0
 */
@Incubating
public interface WithBDDMockito extends WithMockito {

    /**
     * Delegates call to {@link BDDMockito#given(Object)}
     */
    default <T> BDDMockito.BDDMyOngoingStubbing<T> given(T methodCall) {
        return BDDMockito.given(methodCall);
    }

    /**
     * Delegates call to {@link BDDMockito#then(Object)}
     */
    default <T> BDDMockito.Then<T> then(T mock) {
        return BDDMockito.then(mock);
    }

    /**
     * Delegates call to {@link BDDMockito#willThrow(Throwable)}
     */
    default BDDMockito.BDDStubber willThrow(Throwable toBeThrown) {
        return BDDMockito.willThrow(toBeThrown);
    }

    /**
     * Delegates call to {@link BDDMockito#doThrow(Throwable)}
     */
    default BDDMockito.BDDStubber willThrow(Class<? extends Throwable> toBeThrown) {
        return BDDMockito.willThrow(toBeThrown);
    }

    /**
     * Delegates call to {@link BDDMockito#doAnswer(Answer)}
     */
    default BDDMockito.BDDStubber willAnswer(Answer answer) {
        return BDDMockito.willAnswer(answer);
    }

    /**
     * Delegates call to {@link BDDMockito#doNothing()}
     */
    default BDDMockito.BDDStubber willDoNothing() {
        return BDDMockito.willDoNothing();
    }

    /**
     * Delegates call to {@link BDDMockito#doReturn(Object)}
     */
    default BDDMockito.BDDStubber willReturn(Object toBeReturned) {
        return BDDMockito.willReturn(toBeReturned);
    }

    /**
     * Delegates call to {@link BDDMockito#doCallRealMethod()}
     */
    default BDDMockito.BDDStubber willCallRealMethod() {
        return BDDMockito.willCallRealMethod();
    }
}
