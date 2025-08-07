package com.gtel.order.grpc;

import com.gtel.order.utils.ApplicationException;
import com.gtel.order.utils.ERROR_CODE;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.apache.logging.log4j.util.Strings;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Component;
import com.gtel.product.grpc.*;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ProductGrpcClient {

    @GrpcClient("product")
    com.gtel.product.grpc.ProductGrpcServiceGrpc.ProductGrpcServiceBlockingStub stub;

    public boolean validateProduct(long productId){
            GetProductInfoRequest request = GetProductInfoRequest
                    .newBuilder()
                    .setProductId(productId).build();

            GetProductResponse response = stub.getProductInfo(request);

            if (response.getCode() != 200){
                log.info("get product info error");
                return false;
            }

        return true;
    }


    public List<ProductInfo> getListProductInfo(List<Long> productIds) throws ApplicationException {
        GetProductsInfoRequest request = GetProductsInfoRequest
                .newBuilder()
                .addAllProductId(productIds).build();

        GetProductsResponse response = stub.getProductsInfo(request);

        if (response.getCode() != 200){
            log.info("get product info error");
            throw new ApplicationException(ERROR_CODE.INTERNAL_SERVER_ERROR , "product system is error");
        }

        List<Long> productValid = response.getProductList()
                .stream()
                .map(item->item.getProductId())
                .toList();

        if (productIds.size() != productValid.size()){
            // co loi

            // tim thang nao loi

            for (Long id : productValid){
                productIds.remove(id);
            }

            String message = "productId not found : " + productIds;

            throw new ApplicationException(ERROR_CODE.INVALID_PARAMETER, message);
        }


        return response.getProductList();


    }

}
