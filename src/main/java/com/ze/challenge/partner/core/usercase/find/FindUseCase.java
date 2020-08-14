package com.ze.challenge.partner.core.usercase.find;

import com.ze.challenge.partner.core.entity.Partner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindUseCase {
    private Find find;

    public Partner find(String id){
        return find.find(id);
    }
}
