package com.github.javachat.morerandom;

import com.google.common.collect.ImmutableList;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIllegalSampleSize() {
        MoreRandomFactory.stable().sample(Collections.emptyList(), 5);
    }

    @Test
    public void testSamplingZeroResults() {
        Collection<Object> result = MoreRandomFactory.stable().sample(Collections.emptyList(), 0);
        assertThat(result).isEmpty();
    }

    @Test
    public void testSimpleValueSelection() {
        Collection<Integer> population = ImmutableList.of(3, 4711, 9, 418, 517910);
        MoreRandom random = MoreRandomFactory.stable();

        Collection<Integer> sample = random.sample(population, 2);

        assertThat(sample).isNotEmpty();
        assertThat(sample).allMatch(population::contains);
    }
}
