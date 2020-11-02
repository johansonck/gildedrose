package com.gildedrose;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void foo() throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 30;

        for (int i = 0; i < days; i++) {
            printWriter.println("-------- day " + i + " --------");
            printWriter.println("name, sellIn, quality");
            for (Item item : items) {
                printWriter.println(item);
            }
            printWriter.println();
            app.updateQuality();
        }

        String goldenMaster = IOUtils.toString(getClass().getResourceAsStream("/newgoldenmaster.txt"), Charset.defaultCharset());

        assertThat(stringWriter.toString()).isEqualToIgnoringNewLines(goldenMaster);
    }
}
