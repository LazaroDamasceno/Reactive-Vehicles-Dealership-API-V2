package com.api.v1.purchases.services.cars;

import com.api.v1.purchases.domain.PurchaseRepository;
import com.api.v1.purchases.dtos.CarPurchaseDto;
import com.api.v1.purchases.utils.CarPurchaseMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
class CaPurchaseRetrievalServiceImpl implements CaPurchaserRetrievalService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Flux<CarPurchaseDto> findAll() {
        return purchaseRepository
                .findAll()
                .flatMap(purchase -> Flux.just(CarPurchaseMapperUtil.mapToDto(purchase)));
    }

}
