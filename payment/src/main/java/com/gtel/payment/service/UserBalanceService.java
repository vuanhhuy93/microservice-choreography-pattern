package com.gtel.payment.service;

import com.gtel.payment.domain.UserBalanceDomain;
import com.gtel.payment.entity.UserBalanceEntity;
import com.gtel.payment.grpc.GetUserBalanceInfoRequest;
import com.gtel.payment.grpc.GetUserBalanceResponse;
import com.gtel.payment.grpc.UserBalanceInfo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserBalanceService {

    private final UserBalanceDomain userBalanceDomain;

    public GetUserBalanceResponse getUserBalance(GetUserBalanceInfoRequest request){
        log.info("get user balance with userName {}" , request.getUsername());
        GetUserBalanceResponse.Builder responseBuilder = GetUserBalanceResponse.newBuilder();
        if (StringUtils.isBlank(request.getUsername())){
            responseBuilder.setCode(400)
                    .setMessage("param is invalid, user is blank");
            return responseBuilder.build();
        }



        UserBalanceEntity userBalanceEntity = userBalanceDomain.getUserBalance(request.getUsername());

        UserBalanceInfo userBalanceInfo = UserBalanceInfo
                .newBuilder()
                .setBalance(userBalanceEntity.getBalance())
                .setUsername(request.getUsername())
                .build();
        log.info("get user balance with userName {} DONE" , request.getUsername());
        responseBuilder.setCode(200)
                .setMessage("SUCCESS").setUserbalance(userBalanceInfo);
        return responseBuilder.build();
    }
}
