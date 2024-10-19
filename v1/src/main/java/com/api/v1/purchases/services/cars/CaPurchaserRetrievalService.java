package com.api.v1.purchases.services.cars;

import com.api.v1.purchases.dtos.CarPurchaseDto;
import reactor.core.publisher.Flux;

public interface CaPurchaserRetrievalService {

    Flux<CarPurchaseDto> findAll();

}
