package com.pabji.heroes.domain.base;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

/**
 * BasePresenter with Mosby
 */
public class BasePresenter<T extends BaseView> extends MvpNullObjectBasePresenter<T> {

}
