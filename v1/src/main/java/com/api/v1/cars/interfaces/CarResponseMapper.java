package com.api.v1.cars.interfaces;

import com.api.v1.cars.dtos.CarResponseDto;

public interface CarResponseMapper<T> {

    CarResponseDto map(T vehicle);

}
