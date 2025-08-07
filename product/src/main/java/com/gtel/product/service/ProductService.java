package com.gtel.product.service;

import com.gtel.product.domain.ProductDomain;
import com.gtel.product.entity.ProductEntity;
import com.gtel.product.grpc.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductDomain productDomain;
//    GetProductInfoRequest request, StreamObserver<GetProductResponse>


    public GetProductsResponse getProductInfo(GetProductsInfoRequest request) {
        GetProductsResponse.Builder builder = GetProductsResponse.newBuilder();

        List<ProductInfo> productInfos = new ArrayList<>();


        for (long id : request.getProductIdList()){

            Optional<ProductEntity> productOpt = productDomain.findByIdProduct(id);

            if (productOpt.isEmpty())
                continue;

            ProductEntity productEntity = productOpt.get();
            ProductInfo.Builder productInfoBuilder = ProductInfo.newBuilder();

            productInfoBuilder
                    .setProductId(id)
                    .setName(productEntity.getName())
                    .setStatus(productEntity.getStatus())
                    .setPrice(productEntity.getPrice() == null ? 0L : productEntity.getPrice());

            productInfos.add(productInfoBuilder.build());
        }


        builder.setCode(200)
                .setMessage("SUCCESS")
                .addAllProduct(productInfos);

        return builder.build();

    }

    public GetProductResponse getProductInfo(GetProductInfoRequest request) {
        GetProductResponse.Builder responseBuilder = GetProductResponse.newBuilder();


        long productId = request.getProductId();

        Optional<ProductEntity> productOpt = productDomain.findByIdProduct(productId);


        if (productOpt.isEmpty()) {
            responseBuilder.setCode(404)
                    .setMessage("product not found");
            return responseBuilder.build();
        }

        ProductEntity productEntity = productOpt.get();
        ProductInfo.Builder productInfoBuilder = ProductInfo.newBuilder();

        productInfoBuilder
                .setProductId(productId)
                .setName(productEntity.getName())
                .setStatus(productEntity.getStatus())
                .setPrice(productEntity.getPrice() == null ? 0L : productEntity.getPrice());


        responseBuilder.setCode(200)
                .setMessage("SUCCESS")
                .setProduct(productInfoBuilder.build());
        return responseBuilder.build();
    }
}
