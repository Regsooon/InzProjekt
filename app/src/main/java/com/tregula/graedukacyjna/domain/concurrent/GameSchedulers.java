package com.tregula.graedukacyjna.domain.concurrent;

import io.reactivex.Scheduler;

public interface GameSchedulers {

    Scheduler main();

    Scheduler io();
}
