package com.ze.challenge.partner.core.usercase.commons;

import com.ze.challenge.partner.core.entity.Partner;
import org.apache.commons.lang3.StringUtils;

public class CleanInputData {
    private CleanInputData(){
        super();
    }

    public static void prepareInputPartner(Partner partner){
        partner.setDocument(prepareInputDocument(partner.getDocument()));
    }

    public static String prepareInputDocument(String document){
        if(StringUtils.isNotBlank(document)) {
            return document.replaceAll("[^\\d]", "");
        }
        return null;
    }
}
