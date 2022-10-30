package com.nixrstudios.computationapi.numbertheory.gcd.service;

import com.nixrstudios.computationapi.common.DomainComponent;
import com.nixrstudios.computationapi.common.exception.ComputationApiBusinessException;
import com.nixrstudios.computationapi.numbertheory.gcd.model.GCDInput;

@DomainComponent
public class GCDValidator {
    public void validate(GCDInput gcdInput) {
        if (gcdInput == null || gcdInput.getNumbers() == null || gcdInput.getNumbers().isEmpty()) {
            throw new ComputationApiBusinessException("computationApi.gcd.inputNullOrEmpty");
        }
        if (gcdInput.getNumbers().contains(0L)) {
            throw new ComputationApiBusinessException("computationApi.gcd.inputContainsZero");
        }
    }
}
