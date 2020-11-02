package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConjuredManaCakeConsumerTest {

    @Test
    public void test() {
        Item item = new Item("Conjured Mana Cake", 3, 6);
        assertThat(item.quality).isEqualTo(6);

        ConjuredManaCakeConsumer consumer = new ConjuredManaCakeConsumer();

        consumer.accept(item);
        assertThat(item.quality).isEqualTo(4);

        consumer.accept(item);
        assertThat(item.quality).isEqualTo(2);

        consumer.accept(item);
        assertThat(item.quality).isEqualTo(0);

        consumer.accept(item);
        assertThat(item.quality).isEqualTo(0);
    }
}