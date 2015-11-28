# Mockito-Java8 [![Build Status](https://travis-ci.org/szpak/mockito-java8.svg?branch=master)](https://travis-ci.org/szpak/mockito-java8) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/info.solidsoft.mockito/mockito-java8/badge.svg)](https://maven-badges.herokuapp.com/maven-central/info.solidsoft.mockito/mockito-java8)

Mockito add-ons leveraging Java 8 and lambda expressions to make mocking even more compact.

## Quick start

### Lambda matcher

Allows for stubbing with matcher logic defined within a lambda expression. Useful when working with complex classes pass as an argument.

```
given(ts.findNumberOfShipsInRangeByCriteria(
    argLambda(c -> c.getMinimumRange() > 1000))).willReturn(4);
```

### Argument Captor - Java 8 edition

Allows to use ArgumentCaptor in one line (here with AssertJ):

```
verify(ts).findNumberOfShipsInRangeByCriteria(
    assertArg(sc -> assertThat(sc.getMinimumRange()).isLessThan(2000)));
```

### Mockito API methods available via interfaces (without static imports)

Allows to use methods from Mockito API without the need to use static imports. It is enough to make your test class implement `WithBDDMockito`
interface to have all methods from Mockito API available directly (especially useful for Eclipse users).

```
class SpaceShipTest implements WithBDDMockito {
    //stub and verify as usual without static imports
}
```

Available interfaces: [`WithBDDMockito`](https://github.com/szpak/mockito-java8/blob/master/src/main/java/info/solidsoft/mockito/java8/api/WithBDDMockito.java),
[`WithMockito`](https://github.com/szpak/mockito-java8/blob/master/src/main/java/info/solidsoft/mockito/java8/api/WithMockito.java) and
[`WithAdditionalMatchers`](https://github.com/szpak/mockito-java8/blob/master/src/main/java/info/solidsoft/mockito/java8/api/WithAdditionalMatchers.java).


## Configuration in a project

mockito-java8 jars are available in Maven Central.

### Gradle

```
testCompile 'info.solidsoft.mockito:mockito-java8:2.0.0-beta'
```

### Maven

```
<dependency>
    <groupId>info.solidsoft.mockito</groupId>
    <artifactId>mockito-java8</artifactId>
    <version>2.0.0-beta</version>
    <scope>test</scope>
</dependency>
```

### Other

Click Maven Central badge [![Maven Central](https://maven-badges.herokuapp.com/maven-central/info.solidsoft.mockito/mockito-java8/badge.svg)](https://maven-badges.herokuapp.com/maven-central/info.solidsoft.mockito/mockito-java8) to get configuration snippets for SBT, Ivy and more.

## Mockito compatibility

Mockito-Java8 has two development lines. Versions 1.x (and 0.3.x) should be compatible with Mockito 1.10.12+ and 2.0.x-beta up to 2.0.21-beta.
Versions 2.x supports the new matchers API and should be compatible with Mockito 2.0.22-beta and newer versions.

## Provided add-ons

### Lambda matcher

Allows to define matcher logic within a lambda expression. Useful when working with complex classes pass as an argument.

```
@Immutable
class ShipSearchCriteria {
    int minimumRange;
    int numberOfPhasers;
}
```

```
@Test
public void shouldAllowToUseLambdaInStubbing() {
    //given
    given(ts.findNumberOfShipsInRangeByCriteria(
        argLambda(c -> c.getMinimumRange() > 1000))).willReturn(4);
    //expect
    assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(1500, 2)))
        .isEqualTo(4);
    //expect
    assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(700, 2)))
        .isEqualTo(0);
}
```

In comparison the same logic implemented with a custom Answer in Java 7:

```
@Test
public void stubbingWithCustomAnswerShouldBeLonger() {  //old way
    //given
    given(ts.findNumberOfShipsInRangeByCriteria(any())).willAnswer(new Answer<Integer>() {
        @Override
        public Integer answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments();
            ShipSearchCriteria criteria = (ShipSearchCriteria) args[0];
            if (criteria.getMinimumRange() > 1000) {
                return 4;
            } else {
                return 0;
            }
        }
    });
    //expect
    assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(1500, 2)))
        .isEqualTo(4);
    //expect
    assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(700, 2)))
        .isEqualTo(0);
}
```

Even Java 8 and less readable constructions don't help too much:

```
@Test
public void stubbingWithCustomAnswerShouldBeLongerEvenAsLambda() {  //old way
    //given
    given(ts.findNumberOfShipsInRangeByCriteria(any())).willAnswer(invocation -> {
        ShipSearchCriteria criteria = (ShipSearchCriteria) invocation.getArguments()[0];
        return criteria.getMinimumRange() > 1000 ? 4 : 0;
    });
    //expect
    assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(1500, 2)))
        .isEqualTo(4);
    //expect
    assertThat(ts.findNumberOfShipsInRangeByCriteria(new ShipSearchCriteria(700, 2)))
        .isEqualTo(0);
}
```

### Argument Captor - Java 8 edition

Allows to use ArgumentCaptor in one line:

```
@Test
public void shouldAllowToUseAssertionInLambda() {
    //when
    ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
    //then
    verify(ts).findNumberOfShipsInRangeByCriteria(
        assertArg(sc -> assertThat(sc.getMinimumRange()).isLessThan(2000)));
}
```

In comparison to 3 lines in the classic way:

```
@Test
public void shouldAllowToUseArgumentCaptorInClassicWay() {  //old way
    //when
    ts.findNumberOfShipsInRangeByCriteria(searchCriteria);
    //then
    ArgumentCaptor<ShipSearchCriteria> captor = 
        ArgumentCaptor.forClass(ShipSearchCriteria.class);
    verify(ts).findNumberOfShipsInRangeByCriteria(captor.capture());
    assertThat(captor.getValue().getMinimumRange()).isLessThan(2000);
}
```

### Mockito API methods available via interfaces (without static imports)

Allows to use methods from Mockito API without the need to use static imports. It is enough to make your test class implement `WithBDDMockito`
interface to have all methods from stubbing/mockito Mockito API available directly.

```
//no need to use static imports!

public class SpaceShipTest implements WithBDDMockito {

    @Test
    public void shouldVerifyMethodExecution() {
        //given
        TacticalStation tsSpy = spy(TacticalStation.class);
        willDoNothing().given(tsSpy).fireTorpedo(2);
        //when
        tsSpy.fireTorpedo(2);
        tsSpy.fireTorpedo(2);
        //then
        then(tsSpy).should(times(2)).fireTorpedo(2);
    }
}
```

The same code would work fine with a bunch of static imports. Of course they can be hidden in IDE and usually do not disturb much. Nevertheless
to be able to write just a method name (e.g. `mock(TacticalStation.class)`) without a class is it required to press ALT-ENTER (in IntelliJ IDEA)
to add each static import on the first usage of a given method in a test class. The situation is even worse in Eclipse where it is
[required](http://stackoverflow.com/a/290756/313516) to earlier add `BDDMockito` to "Favorites" in "Content Assist" to make it suggested by IDE.

Mockito methods are provided by 3 base interfaces, being an entry point for given set of methods:
 - [`WithBDDMockito`](https://github.com/szpak/mockito-java8/blob/master/src/main/java/info/solidsoft/mockito/java8/api/WithBDDMockito.java) - stubbing/mocking API in BDD style
 - [`WithMockito`](https://github.com/szpak/mockito-java8/blob/master/src/main/java/info/solidsoft/mockito/java8/api/WithMockito.java) - classic stubbing/mocking API
 - [`WithAdditionalMatchers`](https://github.com/szpak/mockito-java8/blob/master/src/main/java/info/solidsoft/mockito/java8/api/WithAdditionalMatchers.java) - additional matchers


## Rationale

Mockito-Java8 is a side effect of my short presentation [Java 8 brings power to testing!](https://speakerdeck.com/szpak/java-8-brings-power-to-testing)
which I gave at GeeCON TDD 2015 and DevConf.cz 2015. In my speech, using 4 examples, I showed how Java 8 - namely lambda expressions - can simplify testing tools.


## Limitations

Unfortunately there is a set of nice Java 8 related features which cannot be implemented without a non backward compatible changes in Mockito core and
therefore cannot be implemented as an add-on. A good news is that [Mockito 3.0](https://github.com/mockito/mockito/issues/297) is planned to require
Java 8 making it all possible. 


## Additional information 

mockito-java8 has been written by Marcin Zajączkowski. The author can be contacted directly via email: mszpak ATT wp DOTT pl.
There is also Marcin's blog available: [Solid Soft](http://blog.solidsoft.info/) - working code is not enough.

mockito-java8 is a separate project and is NOT supported by The Mockito Core Team.

The library is licensed under the terms of [the Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt).
