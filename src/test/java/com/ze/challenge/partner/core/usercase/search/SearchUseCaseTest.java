package com.ze.challenge.partner.core.usercase.search;

import com.ze.challenge.partner.core.usercase.mocks.Mocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

@ExtendWith(SpringExtension.class)
class SearchUseCaseTest {

    @MockBean
    private Search search;
    private SearchUseCase searchUseCase;

    @BeforeEach
    void setUp() {
        searchUseCase = new SearchUseCase(search);
    }

    @Test
    void search() {
        Mockito.when(search.search(Mockito.anyDouble(), Mockito.anyDouble(), Mockito.anyInt())).thenReturn(Arrays.asList(Mocks.createPartnet()));
        searchUseCase.search(23.00, 45.00);
    }
}