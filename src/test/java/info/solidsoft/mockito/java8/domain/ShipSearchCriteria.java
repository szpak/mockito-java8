/*
 * Copyright (C) 2015 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.mockito.java8.domain;

/**
 * Test domain classes.
 */
public class ShipSearchCriteria {

    private final int minimumRange;
    private final int numberOfPhasers;

    public ShipSearchCriteria(int minimumRange, int numberOfPhasers) {
        this.minimumRange = minimumRange;
        this.numberOfPhasers = numberOfPhasers;
    }

    public int getMinimumRange() {
        return minimumRange;
    }

    public int getNumberOfPhasers() {
        return numberOfPhasers;
    }

    @Override
    public String toString() {
        return "ShipSearchCriteria{" +
                "minimumRange=" + minimumRange +
                ", numberOfPhasers=" + numberOfPhasers +
                '}';
    }
}
