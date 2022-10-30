package com.nixrstudios.computationapi.numbertheory.gcd.model;

import com.nixrstudios.computationapi.common.model.ComputationOutput;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class GCDOutput implements ComputationOutput {
    private Long result;
}
