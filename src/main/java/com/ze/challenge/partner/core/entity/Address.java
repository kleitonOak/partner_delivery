package com.ze.challenge.partner.core.entity;

import lombok.Data;

import java.util.List;
@Data
public class Address {
    private GeometryType type;
    private List<Double> coordinates;
}
