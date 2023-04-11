package com.oracle.jp.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import jakarta.inject.Inject;

@HelidonTest
public class ItemServiceTest {

    private ItemService itemService;

    @Inject
    public ItemServiceTest(ItemService itemService) {
        this.itemService = itemService;
    }

    @Test
    void testGetItemBy1() {
        var item = itemService.getItemById(1);
        var expected = "Item [id=" + 1 + ", name=" + "2015 Star 36v golf cart...barely used" + ", desc="
                + "Features include:" + ", date=" + "2015-07-09 00:00:00" + ", postedBy=" + "2"
                + ", boughtBy=" + null + ", price=" + 5650 + ", status=" + "available" + "]";
        assertEquals(expected, item.toString());
    }

    @Test
    void testGetAllItems() {
        var items = itemService.getAllItem();
        var expected = 17;
        assertEquals(expected, items.size());
    }

}
