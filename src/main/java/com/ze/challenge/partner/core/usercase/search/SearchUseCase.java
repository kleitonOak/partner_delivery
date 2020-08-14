package com.ze.challenge.partner.core.usercase.search;

import com.ze.challenge.partner.core.entity.Partner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchUseCase {

    private Search search;

    public List<Partner> search(Double latitude, Double longitude){
        return search.search(latitude,longitude);
    }
}
