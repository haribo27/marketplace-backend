package ru.zubtsov.marketplace.user.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShopAdmin extends AbstractUser {

    private long shopBalance;
}
