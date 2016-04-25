package com.github.javachat.morerandom;

import com.google.common.collect.ImmutableList;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ChoiceTest {

    public static final ImmutableList<Double> DOUBLES = ImmutableList.of(1.0, 47.11, 246.01);

    @Test
    public void testChoiceForNonEmptyList() {
        MoreRandom random = MoreRandomFactory.stable();
        Optional<Double> actualValue = random.choice(DOUBLES);

        assertThat(actualValue).isNotNull();
        assertThat(actualValue).isPresent();
        assertThat(DOUBLES).contains(actualValue.get());
    }

    @Test
    public void testChoiceForSingletonList() {
        Optional<Double> value = MoreRandomFactory.stable().choice(Collections.singletonList(123.456));

        assertThat(value).isPresent();
        assertThat(value).hasValue(123.456);
    }

    @Test
    public void testChoiceForEmptyList() {
        MoreRandom random = MoreRandomFactory.stable();
        Optional<Double> value = random.choice(Collections.emptyList());

        assertThat(value).isNotPresent();
    }
}
