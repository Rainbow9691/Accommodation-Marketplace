package com.dcl.accommodate.dto.wrapper;

import java.util.List;
import java.util.Objects;

public record FieldErrors(
        String rejectedField,
        Object rejectedValue,
        String message
) {
}
