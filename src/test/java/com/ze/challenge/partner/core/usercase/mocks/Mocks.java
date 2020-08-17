package com.ze.challenge.partner.core.usercase.mocks;

import com.ze.challenge.partner.core.entity.Address;
import com.ze.challenge.partner.core.entity.CoverageArea;
import com.ze.challenge.partner.core.entity.GeometryType;
import com.ze.challenge.partner.core.entity.Partner;

import java.util.Arrays;
import java.util.List;

public class Mocks {
    public static Partner createPartnet(){
        Partner partner = new Partner();
        partner.setId("1");
        partner.setTradingName("Adega da Cerveja - Pinheiros");
        partner.setOwnerName("Zé da Silva");
        partner.setDocument("1432132123891/0001");

        CoverageArea coverageArea = new CoverageArea();
        coverageArea.setType(GeometryType.MultiPolygon);
        coverageArea.setCoordinates(Arrays.asList(Arrays.asList(Arrays.asList(Arrays.asList()))));
        partner.setCoverageArea(coverageArea);

        Address address = new Address();
        address.setType(GeometryType.Point);
        address.setCoordinates(Arrays.asList(-46.57421, -21.785741));
        partner.setAddress(address);

        return partner;
    }
}
