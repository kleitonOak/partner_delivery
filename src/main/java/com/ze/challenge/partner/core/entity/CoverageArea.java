package com.ze.challenge.partner.core.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CoverageArea implements Serializable {
    private GeometryType type;
    private List<List<List<List<Integer>>>>coordinates;

}
