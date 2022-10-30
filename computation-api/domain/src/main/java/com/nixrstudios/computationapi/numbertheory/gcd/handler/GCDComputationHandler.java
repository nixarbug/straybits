package com.nixrstudios.computationapi.numbertheory.gcd.handler;

import com.nixrstudios.computationapi.common.handler.ComputationHandler;
import com.nixrstudios.computationapi.common.handler.ComputationHandlerRegistry;
import com.nixrstudios.computationapi.numbertheory.gcd.model.*;
import com.nixrstudios.computationapi.numbertheory.gcd.service.GCDValidator;

public class GCDComputationHandler implements ComputationHandler<GCDOutput, GCDInput> {

    private final GCDValidator gcdValidator;

    public GCDComputationHandler(GCDValidator gcdValidator) {
        this.gcdValidator = gcdValidator;
        ComputationHandlerRegistry.INSTANCE.register(GCDInput.class, this);
    }

    @Override
    public GCDOutput compute(GCDInput computation) {
        gcdValidator.validate(computation);
        Long gcd;
        if (computation.getNumbers().size() == 1) {
            return GCDOutput.builder().result(computation.getNumbers().get(0)).build();
        } else {
            int i = 1;
            gcd = computation.getNumbers().get(0);
            while (i < computation.getNumbers().size()) {
                gcd = gcdForTwoNumbers(gcd, computation.getNumbers().get(i));
                i++;
            }
        }
        return GCDOutput.builder().result(gcd).build();
    }

    private Long gcdForTwoNumbers(Long number1, Long number2) {
        long remainder = number1 % number2;
        if (remainder == 0) {
            return number2;
        } else {
            number1 = number2;
            number2 = remainder;
            return gcdForTwoNumbers(number1, number2);
        }
    }
}
