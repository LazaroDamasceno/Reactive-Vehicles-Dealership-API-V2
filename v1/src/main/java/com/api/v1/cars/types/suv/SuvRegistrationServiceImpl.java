package com.api.v1.cars.types.suv;

import com.api.v1.cars.domain.CarRepository;
import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.interfaces.CarRegistrationService;
import com.api.v1.cars.interfaces.CarResponseMapper;
import com.api.v1.vehicles.domain.inventory.VehicleInventory;
import com.api.v1.vehicles.domain.inventory.VehicleInventoryRepository;
import com.api.v1.vehicles.domain.vehicle.Vehicle;
import com.api.v1.vehicles.domain.vehicle.VehicleRepository;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class SuvRegistrationServiceImpl implements CarRegistrationService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleInventoryRepository vehicleInventoryRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SuvResponseMapperUtil responseMapper;

    @Override
    public Mono<CarResponseDto> register(@Valid VehicleRegistrationRequestDto requestDto) {
        return vehicleRepository
                .save(Vehicle.of(requestDto))
                .flatMap(vehicle -> vehicleInventoryRepository
                        .findByVehicle(vehicle)
                        .switchIfEmpty(Mono.defer(() -> vehicleInventoryRepository
                                .save(VehicleInventory.of(vehicle))
                        ))
                        .flatMap(inventory -> {
                            inventory.increaseAvailableQuantity();
                            return vehicleInventoryRepository.save(inventory);
                        })
                        .then(Mono.defer(() -> carRepository.save(SUV.of(vehicle))))
                        .flatMap(suv -> Mono.just(responseMapper.map(suv)))

                );
    }

}
