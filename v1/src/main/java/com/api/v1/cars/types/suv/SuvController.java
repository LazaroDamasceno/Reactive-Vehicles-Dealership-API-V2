package com.api.v1.cars.types.suv;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/suv")
public class SuvController {

    @Autowired
    SuvRegistrationServiceImpl registrationService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CarResponseDto> register(@Valid @RequestBody VehicleRegistrationRequestDto requestDto) {
        return registrationService.register(requestDto);
    }

}
