import com.nixrstudios.computationapi.common.exception.ComputationApiBusinessException;
import com.nixrstudios.computationapi.numbertheory.gcd.handler.GCDComputationHandler;
import com.nixrstudios.computationapi.numbertheory.gcd.model.GCDInput;
import com.nixrstudios.computationapi.numbertheory.gcd.model.GCDOutput;
import com.nixrstudios.computationapi.numbertheory.gcd.service.GCDValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class GCDComputationTest {

    @Test
    void should_calculate_gcd_single_number() {
        // given
        GCDInput gcdInput = GCDInput.builder().numbers(List.of(12L)).build();
        GCDComputationHandler gcdComputationHandler = new GCDComputationHandler(new GCDValidator());

        // when
        GCDOutput gcdOutput = gcdComputationHandler.compute(gcdInput);

        // then
        Assertions.assertEquals(GCDOutput.builder().result(12L).build(), gcdOutput);
    }

    @Test
    void should_calculate_gcd_for_two_numbers() {
        // given
        GCDInput gcdInput = GCDInput.builder().numbers(List.of(12L, 30L)).build();
        GCDComputationHandler gcdComputationHandler = new GCDComputationHandler(new GCDValidator());

        // when
        GCDOutput gcdOutput = gcdComputationHandler.compute(gcdInput);

        // then
        Assertions.assertEquals(GCDOutput.builder().result(6L).build(), gcdOutput);
    }


    @Test
    void should_calculate_gcd_for_more_than_two_numbers() {
        // given
        GCDInput gcdInput = GCDInput.builder().numbers(List.of(12L, 30L, 45L, 93L)).build();
        GCDComputationHandler gcdComputationHandler = new GCDComputationHandler(new GCDValidator());

        // when
        GCDOutput gcdOutput = gcdComputationHandler.compute(gcdInput);

        // then
        Assertions.assertEquals(GCDOutput.builder().result(3L).build(), gcdOutput);
    }

    @Test
    void should_calculate_gcd_for_a_list_of_primary_numbers() {
        // given
        GCDInput gcdInput = GCDInput.builder().numbers(List.of(3L, 5L, 7L, 17L)).build();
        GCDComputationHandler gcdComputationHandler = new GCDComputationHandler(new GCDValidator());

        // when
        GCDOutput gcdOutput = gcdComputationHandler.compute(gcdInput);

        // then
        Assertions.assertEquals(GCDOutput.builder().result(1L).build(), gcdOutput);
    }

    @Test
    void should_throw_exception_when_input_is_null() {
        // given
        GCDInput gcdInput = null;
        GCDComputationHandler gcdComputationHandler = new GCDComputationHandler(new GCDValidator());

        // when
        Throwable throwable = catchThrowable(() -> gcdComputationHandler.compute(gcdInput));

        //then
        assertThat(throwable).isNotNull().isInstanceOf(ComputationApiBusinessException.class);
        assertThat(((ComputationApiBusinessException) throwable).getKey()).isEqualTo("computationApi.gcd.inputNullOrEmpty");
    }

    @Test
    void should_throw_exception_when_number_list_is_null() {
        // given
        GCDInput gcdInput = GCDInput.builder().numbers(null).build();
        GCDComputationHandler gcdComputationHandler = new GCDComputationHandler(new GCDValidator());

        // when
        Throwable throwable = catchThrowable(() -> gcdComputationHandler.compute(gcdInput));

        //then
        assertThat(throwable).isNotNull().isInstanceOf(ComputationApiBusinessException.class);
        assertThat(((ComputationApiBusinessException) throwable).getKey()).isEqualTo("computationApi.gcd.inputNullOrEmpty");
    }

    @Test
    void should_throw_exception_when_number_list_is_empty() {
        // given
        GCDInput gcdInput = GCDInput.builder().numbers(List.of()).build();
        GCDComputationHandler gcdComputationHandler = new GCDComputationHandler(new GCDValidator());

        // when
        Throwable throwable = catchThrowable(() -> gcdComputationHandler.compute(gcdInput));

        //then
        assertThat(throwable).isNotNull().isInstanceOf(ComputationApiBusinessException.class);
        assertThat(((ComputationApiBusinessException) throwable).getKey()).isEqualTo("computationApi.gcd.inputNullOrEmpty");
    }

}
