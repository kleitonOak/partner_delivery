package com.ze.challenge.partner.endpoints.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

import java.util.List;

public class AddressDto {
    @NotNull
    @ApiModelProperty(notes = "type", dataType = "String", example = "POINT", position = 1)
    private GeometryTypeDto type;

    @NotNull
    @ApiModelProperty(notes = "coordinates", dataType = "Array", example = "[-46.57421, -21.785741]", position = 2)
    private List<Double> coordinates;
}
