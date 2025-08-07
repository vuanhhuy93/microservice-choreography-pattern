package com.gtel.payment.grpc;

import com.gtel.payment.service.UserBalanceService;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import com.gtel.payment.grpc.*;

@GrpcService
@Slf4j
@AllArgsConstructor
public class UserBalanceGrpc extends PaymentGrpcServiceGrpc.PaymentGrpcServiceImplBase{
    private final UserBalanceService userBalanceService;

    @Override
    public void getUserBalance(GetUserBalanceInfoRequest request, StreamObserver<GetUserBalanceResponse> responseObserver) {
        try {
            GetUserBalanceResponse response = userBalanceService.getUserBalance(request);
            responseObserver.onNext(response);
        } catch (Exception e){
            GetUserBalanceResponse exResponse = GetUserBalanceResponse.newBuilder()
                    .setCode(500)
                    .setMessage("INTERNAL SERVER ERROR")
                    .build();
            responseObserver.onNext(exResponse);
        }
        responseObserver.onCompleted();
    }
}
