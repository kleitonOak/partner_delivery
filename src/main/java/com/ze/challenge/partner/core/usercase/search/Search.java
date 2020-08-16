package com.ze.challenge.partner.core.usercase.search;

import com.ze.challenge.partner.core.entity.Partner;

import java.util.List;

public interface Search {

    public List<Partner> search(Double longitude, Double latitude, Integer limit);
}
