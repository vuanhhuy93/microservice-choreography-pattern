package com.gtel.payment.repository;

import com.gtel.payment.entity.UserBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBalanceRepository extends JpaRepository<UserBalanceEntity, String> {
}
