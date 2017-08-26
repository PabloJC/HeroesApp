package com.pabji.heroes.domain.features.heroDetail;

import android.content.Context;
import android.widget.Toast;

import com.pabji.heroes.domain.base.BasePresenter;
import com.pabji.heroes.domain.callbacks.ResultCallback;
import com.pabji.heroes.domain.enums.ResultError;
import com.pabji.heroes.domain.models.SuperHero;
import com.pabji.heroes.presentation.navigation.Router;

import java.util.List;

import javax.inject.Inject;

public class HeroDetailPresenter extends BasePresenter<HeroDetailView> {

    @Inject
    Router navigator;

    @Inject
    HeroDetailInteractor heroDetailInteractor;

    @Inject
    public HeroDetailPresenter() {
    }

    public void init(final Context context) {
        heroDetailInteractor.run(new ResultCallback<SuperHero>() {
            @Override
            public void onSuccess(SuperHero result) {
                showHeroDetail(result);
            }

            @Override
            public void onError(ResultError error) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showHeroDetail(SuperHero superHero){
        getView().showPhoto(superHero.getPhoto());
        getView().showName(superHero.getName());
        getView().showRealName(superHero.getRealName());
        getView().showPower(superHero.getPower());
        getView().showHeight(superHero.getHeight());
        getView().showAbilities(superHero.getAbilities());
        getView().showGroups(superHero.getGroups());
    }
}
