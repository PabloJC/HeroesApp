package com.pabji.heroes.presentation.base;

import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.pabji.heroes.presentation.di.HasComponent;
import com.pabji.heroes.domain.base.BasePresenter;
import com.pabji.heroes.domain.base.BaseView;

public abstract class BaseMVPFragment<P extends BasePresenter<V>, V extends BaseView> extends MvpFragment<V, P> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
