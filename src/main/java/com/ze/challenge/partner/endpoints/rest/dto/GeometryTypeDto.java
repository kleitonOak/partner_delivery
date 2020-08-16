package com.ze.challenge.partner.endpoints.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

public enum GeometryTypeDto implements Serializable {
    POINT("Point"),
    LINESTRING("LineString"),
    POLYGON("Polygon"),
    MULTIPOINT("MultiPoint"),
    MULTILINESTRING("MultiLineString"),
    MULTIPOLYGON("MultiPolygon"),
    GEOMETRYCOLLECTION("GeometryCollection");


    private String type;

    GeometryTypeDto(String type){
        this.type = type;
    }

    @JsonCreator
    public static GeometryTypeDto forValues(@JsonProperty("type") String type) {
        Optional<GeometryTypeDto> parseElement = Arrays.stream(GeometryTypeDto.values()).filter(e->{ return e.type.equalsIgnoreCase(type);}).findFirst();
        return parseElement.orElseGet(null);
    }

}
