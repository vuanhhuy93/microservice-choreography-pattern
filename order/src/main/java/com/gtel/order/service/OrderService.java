package com.gtel.order.service;

import com.gtel.order.grpc.ProductGrpcClient;
import com.gtel.order.models.dto.OrderItem;
import com.gtel.order.models.request.CreateOrderRequest;
import com.gtel.order.models.response.MainResponse;
import com.gtel.order.utils.ApplicationException;
import com.gtel.order.utils.ERROR_CODE;
import com.gtel.product.grpc.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OrderService  extends BaseService{

    @Autowired
    ProductGrpcClient productGrpcClient;

    public MainResponse<String> createOrder(CreateOrderRequest request){
        this.validateRequest(request);

        log.info("user id {} - created order START" , getUsername());
        MainResponse<String> response = new MainResponse<>();

        // STEP 1:: validate request

        // step 2:  call grpc to product service check product is valid ?

        List<Long> productIds = request.getItems().stream().map(item->item.getProductId()).toList();

        List<ProductInfo> productInfos = productGrpcClient.getListProductInfo(productIds);

        // tinh tien

        Map<Long, ProductInfo> mapProductInfo = new HashMap<>();

        for (ProductInfo productInfo : productInfos){
            mapProductInfo.put(productInfo.getProductId() , productInfo);
        }

        Long amount = 0L;

        for (OrderItem orderItem : request.getItems()){

            ProductInfo productInfo = mapProductInfo.get(orderItem.getProductId());
            amount = amount + orderItem.getTotalItems() * productInfo.getPrice();
        }
        // step 4: check user balance.

        // step 5: check warehouse

        // step 6: check shipping service

        // step 7: make order with status = 1 (INIT) save to db.


        // step 8: publisher message action new order -> channel (redis / rabbitmq)


        log.info("user id {} - created order DONE" , getUsername());
        return response;
    }

    private void validateRequest(CreateOrderRequest request) throws ApplicationException {

        if (CollectionUtils.isEmpty(request.getItems())){
            throw new ApplicationException(ERROR_CODE.INVALID_PARAMETER , "product list is not empty");
        }
    }
    
    // handle event ware house success/fail


    // handle event payment success/fail


    // handle event shipping success/fail
}
