package com.api.v1.cars.services;

import com.api.v1.cars.domain.repository.CarRepository;
import com.api.v1.cars.domain.subclasses.CrossoverCar;
import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.utils.CarResponseMapperUtil;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import com.api.v1.vehicles.services.VehicleRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CrossoverRegistrationServiceImpl implements CrossoverRegistrationService {

    @Autowired
    private VehicleRegistrationService vehicleRegistrationService;

    @Autowired
    private CarRepository carRepository;

    @Override
    public Mono<CarResponseDto> register(@Valid VehicleRegistrationRequestDto requestDto) {
        return vehicleRegistrationService
                .register(requestDto)
                .flatMap(vehicle -> carRepository.save(CrossoverCar.of(vehicle)))
                .flatMap(CarResponseMapperUtil::mapToMono);
    }

}
