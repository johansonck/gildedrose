package com.gildedrose;

public class AgedBrieConsumer extends DefaultItemConsumer {

    @Override
    protected void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
