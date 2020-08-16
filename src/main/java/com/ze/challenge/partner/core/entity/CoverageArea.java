package com.ze.challenge.partner.core.entity;

import lombok.Data;

import java.util.List;

@Data
public class CoverageArea {
    private GeometryType type;
    private List<List<List<List<Integer>>>>coordinates;

}
