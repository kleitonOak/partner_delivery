package com.ze.challenge.partner.core.usercase.search;

import com.ze.challenge.partner.core.entity.Partner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchUseCase {
    private static final int MAX_RECORD_LIST = 1;
    private Search search;

    public List<Partner> search(Double longitude, Double latitude){
        return search.search(longitude,latitude, MAX_RECORD_LIST);
    }
}
