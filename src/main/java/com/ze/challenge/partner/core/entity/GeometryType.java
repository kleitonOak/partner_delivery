package com.ze.challenge.partner.core.entity;

import lombok.ToString;

import java.io.Serializable;
public enum GeometryType implements Serializable {
    Point("Point"),
    LineString("LineString"),
    Polygon("Polygon"),
    MultiPoint("MultiPoint"),
    MultiLineString("MultiLineString"),
    MultiPolygon("MultiPolygon"),
    GeometryCollection("GeometryCollection");


    private String type;

    GeometryType(String type){
        this.type = type;
    }
}
