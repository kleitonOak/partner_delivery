package com.ze.challenge.partner.core.usercase.create;

import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.core.exceptions.CoreBusinessException;
import com.ze.challenge.partner.core.exceptions.CoreIntegrationException;
import com.ze.challenge.partner.core.usercase.commons.CleanInputData;
import com.ze.challenge.partner.core.usercase.find.FindUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CreateUseCase {
    private Create create;
    private FindUseCase findUseCase;

    public Partner create(Partner partner) throws CoreBusinessException, CoreIntegrationException {
        try {
            CleanInputData.prepareInputPartner(partner);
            Partner partnerDocument = findUseCase.findByDocument(partner.getDocument());
            if(Objects.nonNull(partnerDocument)){
                throw new CoreBusinessException("This Document exists on Database");
            }
            partner.setId(null);
            return create.create(partner);
        }catch (RuntimeException e){
            throw new CoreIntegrationException("Fail in CreateUseCase, please check Input Data ",e);
        }
    }

}
