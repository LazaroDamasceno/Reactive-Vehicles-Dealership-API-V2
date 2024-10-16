package com.api.v1.cars.types.suv;

import com.api.v1.cars.domain.CarRepository;
import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.interfaces.CarRegistrationService;
import com.api.v1.vehicles.domain.vehicle.Vehicle;
import com.api.v1.vehicles.domain.vehicle.VehicleRepository;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import com.api.v1.vehicles.services.VehicleInventoryingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SuvRegistrationServiceImpl implements CarRegistrationService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleInventoryingService vehicleInventoryingService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SuvResponseMapperUtil responseMapper;

    @Override
    public Mono<CarResponseDto> register(@Valid VehicleRegistrationRequestDto requestDto) {
        return vehicleRepository
                .save(Vehicle.of(requestDto))
                .flatMap(vehicle -> vehicleInventoryingService.addToTheInventory(vehicle)
                        .then(Mono.defer(() -> carRepository.save(SUV.of(vehicle))))
                        .flatMap(suv -> Mono.just(responseMapper.map(suv)))
                );
    }

}
