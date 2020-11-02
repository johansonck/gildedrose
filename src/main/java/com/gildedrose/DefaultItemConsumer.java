package com.gildedrose;

import java.util.function.Consumer;

public class DefaultItemConsumer implements Consumer<Item> {
    @Override
    public final void accept(Item item) {
        updateQuality(item);

        item.sellIn--;

        if (item.sellIn < 0) {
            updateQuality(item);
        }
    }

    protected void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
