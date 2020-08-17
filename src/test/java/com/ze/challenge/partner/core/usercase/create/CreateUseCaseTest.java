package com.ze.challenge.partner.core.usercase.create;

import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.core.exceptions.CoreBusinessException;
import com.ze.challenge.partner.core.exceptions.CoreIntegrationException;
import com.ze.challenge.partner.core.usercase.find.FindUseCase;
import com.ze.challenge.partner.core.usercase.mocks.Mocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class CreateUseCaseTest {

    @MockBean
    private Create create;
    @MockBean
    private FindUseCase findUseCase;

    private CreateUseCase createUseCase;

    @BeforeEach
    void setUp() {
        createUseCase = new CreateUseCase(create, findUseCase);
    }

    @Test
    void createSuccessfully() throws CoreIntegrationException, CoreBusinessException {
        Mockito.when(create.create(Mockito.any(Partner.class))).thenReturn(Mocks.createPartnet());
        Mockito.when(findUseCase.findByDocument(Mockito.anyString())).thenReturn(null);
        assertThat(createUseCase.create(Mocks.createPartnet())).isNotNull();
    }

    @Test
    void tryCreateWithExistingDocument() throws CoreIntegrationException, CoreBusinessException {
        CoreBusinessException exception = assertThrows(CoreBusinessException.class, () -> {
            Mockito.when(create.create(Mockito.any(Partner.class))).thenReturn(Mocks.createPartnet());
            Mockito.when(findUseCase.findByDocument(Mockito.anyString())).thenReturn(Mocks.createPartnet());
            createUseCase.create(Mocks.createPartnet());
        });

        String expectedMessage = "This Document exists on Database";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void tryCreateWithException() throws CoreIntegrationException, CoreBusinessException {
        CoreIntegrationException exception = assertThrows(CoreIntegrationException.class, () -> {
            Mockito.when(create.create(Mockito.any(Partner.class))).thenThrow(new DataIntegrityViolationException("Can't extract Geo Data"));
            Mockito.when(findUseCase.findByDocument(Mockito.anyString())).thenReturn(null);
            createUseCase.create(Mocks.createPartnet());
        });

        String expectedMessage = "Fail in CreateUseCase, please check Input Data";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}