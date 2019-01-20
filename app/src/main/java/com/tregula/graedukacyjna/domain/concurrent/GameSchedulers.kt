package com.tregula.graedukacyjna.domain.concurrent

import io.reactivex.Scheduler

interface GameSchedulers {

    fun main(): Scheduler

    fun io(): Scheduler
}
