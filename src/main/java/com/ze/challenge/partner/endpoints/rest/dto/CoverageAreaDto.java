package com.ze.challenge.partner.endpoints.rest.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CoverageAreaDto {
    @NotNull
    @ApiModelProperty(notes = "type", dataType = "String", example = "POINT, LINESTRING, POLYGON, MULTIPOINT, MULTILINESTRING, MULTIPOLYGON, GEOMETRYCOLLECTION", position = 1)
    private GeometryTypeDto type;

    @NotNull
    @ApiModelProperty(notes = "coordinates", dataType = "Array", example = "[\n" +
            "      [[[30, 20], [45, 40], [10, 40], [30, 20]]], \n" +
            "      [[[15, 5], [40, 10], [10, 20], [5, 10], [15, 5]]]\n" +
            "    ]", position = 2)
    private List<List<List<List<Integer>>>>coordinates;

}
