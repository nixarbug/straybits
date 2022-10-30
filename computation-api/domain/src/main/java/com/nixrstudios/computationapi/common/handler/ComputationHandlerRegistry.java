package com.nixrstudios.computationapi.common.handler;

import com.nixrstudios.computationapi.common.model.ComputationInput;
import com.nixrstudios.computationapi.common.model.ComputationOutput;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
public class ComputationHandlerRegistry {

    private Map<Class<? extends ComputationInput>, ComputationHandler<?, ? extends ComputationInput>> registryForComputationHandlers;

    public static final ComputationHandlerRegistry INSTANCE = new ComputationHandlerRegistry();

    private ComputationHandlerRegistry() {
        registryForComputationHandlers = new HashMap<>();
    }

    public <R extends ComputationOutput, I extends ComputationInput> void register(Class<I> key, ComputationHandler<R, I> computationHandler) {
        log.info("Computation Input {} is registered to handler {}", key.getSimpleName(), computationHandler.getClass().getSimpleName());
        registryForComputationHandlers.put(key, computationHandler);
    }


    public ComputationHandler<?, ? extends ComputationInput> detectComputationHandlerFrom(Class<? extends ComputationInput> computationInputClass) {
        return registryForComputationHandlers.get(computationInputClass);
    }

}
