package com.ze.challenge.partner.core.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Partner implements Serializable {
    private String id;
    private String tradingName;
    private String ownerName;
    private String document;
    private CoverageArea coverageArea;
    private Address address;

}
