package com.github.javachat.morerandom;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * A wrapper around {@link java.util.Random} that adds some convenience methods.
 */
public class MoreRandom extends Random {
    private Random delegate;

    public MoreRandom() {
        this(new Random());
    }

    public MoreRandom(long seed) {
        this(new Random(seed));
    }

    public MoreRandom(Random delegate) {
        this.delegate = delegate;
    }

    /**
     * Selects a single value out of the given collection.
     * <p>
     * This can be regarded as a special case of {@link #sample(Collection, int)} with sample size <code>1</code>.
     */
    public <T> Optional<T> choice(Collection<T> population) {
        if (population.isEmpty()) {
            return Optional.empty();
        } else {
            Collection<T> sample = sample(population, 1);
            return Optional.of(sample.iterator().next()); // if/else case guarantees a non-empty iterator
        }
    }

    /**
     * Chooses a specified number of items from the given collection.
     *
     * @throws IllegalArgumentException when the sample size exceeds the size of the population.
     */
    public <T> Collection<T> sample(Collection<T> population, int sampleSize) {
        if (sampleSize > population.size()) {
            throw new IllegalArgumentException("Sample size needs to be smaller than population size");
        }

        if (sampleSize == 0) {
            return Collections.emptySet();
        }

        List<T> populationAsList = new ArrayList<>(population);
        return delegate.ints(0, population.size())
                .distinct()
                .limit(sampleSize)
                .mapToObj(populationAsList::get)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Produces a random int within the given lower and upper bound
     */
    public int randint(int lowerBound, int upperBound) {
        return delegate.ints(lowerBound, upperBound)
                .findFirst()
                .getAsInt();
    }

    @Override
    public void nextBytes(byte[] bytes) {
        delegate.nextBytes(bytes);
    }

    @Override
    public int nextInt() {
        return delegate.nextInt();
    }

    @Override
    public int nextInt(int bound) {
        return delegate.nextInt(bound);
    }

    @Override
    public long nextLong() {
        return delegate.nextLong();
    }

    @Override
    public boolean nextBoolean() {
        return delegate.nextBoolean();
    }

    @Override
    public float nextFloat() {
        return delegate.nextFloat();
    }

    @Override
    public double nextDouble() {
        return delegate.nextDouble();
    }

    @Override
    public IntStream ints(long streamSize) {
        return delegate.ints(streamSize);
    }

    @Override
    public synchronized double nextGaussian() {
        return delegate.nextGaussian();
    }

    @Override
    public IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        return delegate.ints(streamSize, randomNumberOrigin, randomNumberBound);
    }

    @Override
    public IntStream ints() {
        return delegate.ints();
    }

    @Override
    public LongStream longs(long streamSize) {
        return delegate.longs(streamSize);
    }

    @Override
    public IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        return delegate.ints(randomNumberOrigin, randomNumberBound);
    }

    @Override
    public LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        return delegate.longs(streamSize, randomNumberOrigin, randomNumberBound);
    }

    @Override
    public LongStream longs() {
        return delegate.longs();
    }

    @Override
    public DoubleStream doubles(long streamSize) {
        return delegate.doubles(streamSize);
    }

    @Override
    public LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        return delegate.longs(randomNumberOrigin, randomNumberBound);
    }

    @Override
    public DoubleStream doubles() {
        return delegate.doubles();
    }

    @Override
    public DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        return delegate.doubles(streamSize, randomNumberOrigin, randomNumberBound);
    }

    @Override
    public DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        return delegate.doubles(randomNumberOrigin, randomNumberBound);
    }
}
