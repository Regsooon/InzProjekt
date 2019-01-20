package com.tregula.graedukacyjna.base.converter

interface Converter<Input, Output> {

    fun convert(input: Input): Output
}
