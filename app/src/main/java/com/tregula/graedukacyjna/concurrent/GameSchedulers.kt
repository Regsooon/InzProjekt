package com.tregula.graedukacyjna.concurrent

import io.reactivex.Scheduler

interface GameSchedulers {

    fun main(): Scheduler

    fun io(): Scheduler
}
