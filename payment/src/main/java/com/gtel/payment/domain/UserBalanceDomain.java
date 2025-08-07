package com.gtel.payment.domain;

import com.gtel.payment.entity.UserBalanceEntity;
import com.gtel.payment.repository.UserBalanceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class UserBalanceDomain {

   private final UserBalanceRepository userBalanceRepository;


   public UserBalanceEntity getUserBalance(String username){
    log.info("get user balance with username {}" , username);
       Optional<UserBalanceEntity> otp = userBalanceRepository.findById(username);


       if (otp.isEmpty()){

           UserBalanceEntity entity = new UserBalanceEntity();
           entity.setBalance(0L);
           entity.setUsername(username);

           userBalanceRepository.save(entity);
           return entity;
       }

       log.info("get user balance with username {} DONE" , username);
       return otp.get();
   }
}
