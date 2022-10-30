package com.nixrstudios.computationapi.numbertheory.gcd.model;

import com.nixrstudios.computationapi.common.model.ComputationInput;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GCDInput implements ComputationInput {
        private List<Long> numbers;
}
