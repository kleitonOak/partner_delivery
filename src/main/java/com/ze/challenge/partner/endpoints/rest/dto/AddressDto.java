package com.ze.challenge.partner.endpoints.rest.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;
@Data
public class AddressDto implements Serializable {
    @NotNull
    private GeometryTypeDto type;

    @NotNull
    private List<Double> coordinates;
}
