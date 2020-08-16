package com.ze.challenge.partner.core.usercase.find;

import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.core.usercase.commons.CleanInputData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindUseCase {
    private Find find;

    public Partner find(String id){
        return find.find(id);
    }

    public Partner findByDocument(String document){

        return find.findByDocument(CleanInputData.prepareInputDocument(document));
    }
}
