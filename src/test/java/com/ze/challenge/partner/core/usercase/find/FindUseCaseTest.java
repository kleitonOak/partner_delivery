package com.ze.challenge.partner.core.usercase.find;

import com.ze.challenge.partner.core.usercase.mocks.Mocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class FindUseCaseTest {

    @MockBean
    private Find find;

    private FindUseCase findUseCase;

    @BeforeEach
    void setUp() {
        findUseCase = new FindUseCase(find);
    }

    @Test
    void find() {
        Mockito.when(find.find(Mockito.anyString())).thenReturn(Mocks.createPartnet());
        assertThat(findUseCase.find("1224")).isNotNull();
    }

    @Test
    void findByDocument() {
        Mockito.when(find.findByDocument(Mockito.anyString())).thenReturn(Mocks.createPartnet());
        assertThat(findUseCase.findByDocument("1224")).isNotNull();
    }
}