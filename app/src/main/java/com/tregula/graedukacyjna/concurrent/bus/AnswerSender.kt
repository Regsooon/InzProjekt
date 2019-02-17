package com.tregula.graedukacyjna.concurrent.bus

import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.domain.data.test.Answer

interface AnswerSender {

    fun sendAnswer(currentQuestion: CountryData, answer: Answer)
}