package com.nixrstudios.computationapi.common.handler;

import com.nixrstudios.computationapi.common.model.ComputationInput;
import com.nixrstudios.computationapi.common.model.ComputationOutput;

public interface ComputationHandler<R extends ComputationOutput, I extends ComputationInput> {
    R compute(I computation);
}
