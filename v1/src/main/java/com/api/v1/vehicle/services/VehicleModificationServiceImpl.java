package com.api.v1.vehicle.services;

import com.api.v1.vehicle.domain.Vehicle;
import com.api.v1.vehicle.domain.VehicleAuditTrail;
import com.api.v1.vehicle.domain.VehicleAuditTrailRepository;
import com.api.v1.vehicle.domain.VehicleRepository;
import com.api.v1.vehicle.dtos.VehicleModificationRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class VehicleModificationServiceImpl implements VehicleModificationService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleAuditTrailRepository auditTrailRepository;

    @Override
    public Mono<Vehicle> modify(@NotNull Vehicle vehicle, @Valid VehicleModificationRequestDto requestDto) {
        return auditTrailRepository
                .save(VehicleAuditTrail.of(vehicle))
                .then(Mono.defer(() -> {
                    vehicle.modify(requestDto);
                    return vehicleRepository.save(vehicle);
                }));
    }

}
