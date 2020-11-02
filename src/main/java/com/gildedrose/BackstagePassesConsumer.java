package com.gildedrose;

import java.util.function.Consumer;

public class BackstagePassesConsumer implements Consumer<Item> {
    @Override
    public void accept(Item item) {
        if (item.quality < 50) {
            item.quality++;

            if (item.sellIn < 11) {
                updateQuality(item);
            }

            if (item.sellIn < 6) {
                updateQuality(item);
            }
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
