package com.pabji.heroes.domain.features.heroeList;

import android.content.Context;
import android.widget.Toast;

import com.pabji.heroes.domain.base.BasePresenter;
import com.pabji.heroes.domain.callbacks.ResultCallback;
import com.pabji.heroes.domain.enums.ResultError;
import com.pabji.heroes.domain.models.SuperHero;
import com.pabji.heroes.presentation.navigation.Router;

import java.util.List;

import javax.inject.Inject;

public class HeroeListPresenter extends BasePresenter<HeroeListView> {

    @Inject
    Router navigator;

    @Inject
    HeroeListInteractor listInteractor;

    @Inject
    public HeroeListPresenter() {
    }

    public void init(final Context context) {

        listInteractor.run(new ResultCallback<List<SuperHero>>() {
            @Override
            public void onSuccess(List<SuperHero> result) {
                getView().showList(result);
            }

            @Override
            public void onError(ResultError error) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
