package com.ze.challenge.partner.core.usercase.create;

import com.ze.challenge.partner.core.entity.Partner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUseCase {
    private Create create;

    public Partner create(Partner partner){
        partner.setId(null);
        return create.create(partner);
    }
}
