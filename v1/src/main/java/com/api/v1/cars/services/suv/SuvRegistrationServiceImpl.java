package com.api.v1.cars.services.suv;

import com.api.v1.cars.domain.CarRepository;
import com.api.v1.cars.domain.SUV;
import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.services.abstracts.CarRegistrationService;
import com.api.v1.cars.utils.CarResponseMapperUtil;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import com.api.v1.vehicles.services.VehicleRegistrationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SuvRegistrationServiceImpl extends CarRegistrationService {

    public SuvRegistrationServiceImpl(
            VehicleRegistrationService vehicleRegistrationService,
            CarRepository carRepository
    ) {
        super(vehicleRegistrationService, carRepository);
    }

    @Override
    public Mono<CarResponseDto> register(@Valid VehicleRegistrationRequestDto requestDto) {
        return vehicleRegistrationService
                .register(requestDto)
                .flatMap(vehicle -> carRepository.save(SUV.of(vehicle)))
                .flatMap(CarResponseMapperUtil::mapToMono);
    }

}
