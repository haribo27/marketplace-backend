package ru.zubtsov.marketplace.user.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends AbstractUser {

    private long balance;
    private String address;
}
