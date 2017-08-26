package com.pabji.heroes.domain.base;

import com.hannesdorfmann.mosby.mvp.MvpView;

public interface BaseView extends MvpView {
    void showError(String error);
}
