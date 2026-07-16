package com.enterProject.enterProject.hexagonalexample;

import com.enterProject.enterProject.hexagonalexample.application.port.in.TestUseCase;
import com.enterProject.enterProject.hexagonalexample.domain.TestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.enterProject.enterProject.hexagonalexample.adapter.out.persistence.TestPersistenceAdapter;
import com.enterProject.enterProject.hexagonalexample.application.service.TestService;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@Import({TestService.class, TestPersistenceAdapter.class})
@Transactional
class TestUseCaseIntegrationTest {

    @Autowired
    private TestUseCase testUseCase;

    @Test
    void crud() {
        TestData created = testUseCase.create("first");

        assertThat(created.id()).isNotNull();
        assertThat(testUseCase.get(created.id()).value()).isEqualTo("first");

        TestData updated = testUseCase.update(created.id(), "second");
        assertThat(updated.value()).isEqualTo("second");

        testUseCase.delete(created.id());
        assertThatThrownBy(() -> testUseCase.get(created.id()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("TEST_ENTITY_NOT_FOUND");
    }
}
