package com.gtel.payment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_balance")
public class UserBalanceEntity {

    @Id
    private String username;

    private Long balance;
}
