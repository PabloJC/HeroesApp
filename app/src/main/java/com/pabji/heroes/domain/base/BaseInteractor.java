package com.pabji.heroes.domain.base;

import com.pabji.heroes.domain.callbacks.ResultCallback;


public interface BaseInteractor<T> {
    void run(ResultCallback<T> resultCallback);
}