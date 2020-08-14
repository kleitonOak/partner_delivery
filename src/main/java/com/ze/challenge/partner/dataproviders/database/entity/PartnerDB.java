package com.ze.challenge.partner.dataproviders.database.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "partners")
public class PartnerDB {
    @Id
    private String id;
    private String tradingName;
    private String ownerName;
    private String document;
    private CoverageAreaDB coverageArea;
    private AddressDB address;

}
