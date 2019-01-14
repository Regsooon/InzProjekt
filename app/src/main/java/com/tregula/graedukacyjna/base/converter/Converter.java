package com.tregula.graedukacyjna.base.converter;

public interface Converter<Input, Output> {

    Output convert(Input input);
}
