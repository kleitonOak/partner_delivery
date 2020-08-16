package com.ze.challenge.partner.core.usercase.find;

import com.ze.challenge.partner.core.entity.Partner;

public interface Find {

    public Partner find(String id);
    public Partner findByDocument(String document);
}
