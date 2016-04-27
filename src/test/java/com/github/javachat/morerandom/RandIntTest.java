package com.github.javachat.morerandom;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandIntTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIllegalParameters() {
        MoreRandomFactory.stable().randint(2, 0);
    }

    @Test
    public void testValidParameters() {
        MoreRandom random = MoreRandomFactory.stable();
        int r = random.randint(0, 100);

        assertThat(r).isGreaterThanOrEqualTo(0);
        assertThat(r).isLessThan(100);
    }
}
