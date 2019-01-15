package com.tregula.graedukacyjna.utils;

import androidx.annotation.NonNull;

public class DoubleParser {

    public Double parse(@NonNull String parsable) {
        try {
            return Double.parseDouble(parsable);
        } catch (NumberFormatException ex) {
            return 0D;
        }
    }
}
