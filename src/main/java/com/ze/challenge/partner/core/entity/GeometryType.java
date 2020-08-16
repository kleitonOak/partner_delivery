package com.ze.challenge.partner.core.entity;

import lombok.ToString;

import java.io.Serializable;
@ToString
public enum GeometryType implements Serializable {
    POINT("Point"),
    LINESTRING("LineString"),
    POLYGON("Polygon"),
    MULTIPOINT("MultiPoint"),
    MULTILINESTRING("MultiLineString"),
    MULTIPOLYGON("MultiPolygon"),
    GEOMETRYCOLLECTION("GeometryCollection");


    private String type;

    GeometryType(String type){
        this.type = type;
    }

//    @JsonCreator
//    public static GeometryTypeDto forValues(@JsonProperty("type") String type) {
//        Optional<GeometryTypeDto> parseElement = Arrays.stream(GeometryTypeDto.values()).filter(e->{ return e.type.equalsIgnoreCase(type);}).findFirst();
//        return parseElement.orElseGet(null);
//    }

}
