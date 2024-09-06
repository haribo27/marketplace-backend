package ru.zubtsov.marketplace.item.model;

import lombok.Data;

@Data
public class Item {

    private long id;
    private String name;
    private String description;
    private int price;
    private boolean available;
    private long rating;
    private long shopId;
    private long createdByUserId;
}
