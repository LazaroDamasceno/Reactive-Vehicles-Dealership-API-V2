package com.api.v1.cars.types.minivan.services;

import com.api.v1.cars.domain.CarRepository;
import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.types.minivan.utils.MinivanResponseMapperUtil;
import com.api.v1.cars.types.minivan.domain.Minivan;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import com.api.v1.vehicles.services.VehicleRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MinivanRegistrationServiceImpl implements MinivanRegistrationService {

    @Autowired
    private VehicleRegistrationService vehicleRegistrationService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private MinivanResponseMapperUtil responseMapperUtil;

    @Override
    public Mono<CarResponseDto> register(@Valid VehicleRegistrationRequestDto requestDto) {
        return vehicleRegistrationService
                .register(requestDto)
                .flatMap(vehicle -> carRepository.save(Minivan.of(vehicle)))
                .flatMap(minivan -> Mono.just(responseMapperUtil.map(minivan)));
    }

}
