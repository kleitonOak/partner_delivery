package com.ze.challenge.partner.core.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class Address implements Serializable {
    private GeometryType type;
    private List<Double> coordinates;
}
