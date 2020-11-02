package com.gildedrose;

public class ConjuredManaCakeConsumer extends DefaultItemConsumer {

    @Override
    protected void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }

        if (item.quality > 0) {
            item.quality--;
        }
    }
}
