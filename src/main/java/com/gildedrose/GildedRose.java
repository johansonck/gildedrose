package com.gildedrose;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

class GildedRose {

    private final Item[] items;

    private static final Map<String, Consumer<Item>> ITEM_CONSUMERS = ImmutableMap.of(
            "Aged Brie", new AgedBrieConsumer(),
            "Backstage passes to a TAFKAL80ETC concert", new BackstagePassesConsumer(),
            "Sulfuras, Hand of Ragnaros", item -> {},
            "Conjured Mana Cake", new ConjuredManaCakeConsumer()
    );

    private static final Consumer<Item> DEFAULT_CONSUMER = new DefaultItemConsumer();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::updateQuality);
    }

    private void updateQuality(Item item) {
        Optional.ofNullable(ITEM_CONSUMERS.get(item.name))
                .orElse(DEFAULT_CONSUMER)
                .accept(item);
    }
}