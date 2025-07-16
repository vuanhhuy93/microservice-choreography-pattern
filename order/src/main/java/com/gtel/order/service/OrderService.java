package com.gtel.order.service;

import com.gtel.order.grpc.ProductGrpcClient;
import com.gtel.order.models.dto.OrderItem;
import com.gtel.order.models.request.CreateOrderRequest;
import com.gtel.order.models.response.MainResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    @Autowired
    ProductGrpcClient productGrpcClient;

    public MainResponse<String> createOrder(CreateOrderRequest request){

        MainResponse<String> response = new MainResponse<>();

        // STEP 1:: validate request

        // step 2:  call grpc to product service check product is valid ?

        for (OrderItem item : request.getItems()){

            boolean validateProduct = productGrpcClient.validateProduct(item.getProductId());

            if (!validateProduct){

                response.setCode("400");
                response.setMessage("PRODUCT NOT FOUND");
                return response;
            }
        }

        // step  3:  total balance.
          //  SUUM (so luong x price ) -> money

        // step 4: check user balance.

        // step 5: check warehouse

        // step 6: check shipping service

        // step 7: make order with status = 1 (INIT) save to db.


        // step 8: publisher message action new order -> channel (redis / rabbitmq)


        return response;
    }


    // handle event ware house success/fail


    // handle event payment success/fail


    // handle event shipping success/fail
}
