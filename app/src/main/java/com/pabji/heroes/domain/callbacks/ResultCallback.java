package com.pabji.heroes.domain.callbacks;

import com.pabji.heroes.domain.enums.ResultError;

/**
 * Created by PabloJC on 26/8/17.
 */

public interface ResultCallback<T> {
    void onSuccess(T result);
    void onError(ResultError error);
}
