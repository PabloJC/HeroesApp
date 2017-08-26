package com.pabji.heroes.domain.features.heroDetail;

import android.content.Context;

import com.pabji.heroes.domain.base.BasePresenter;
import com.pabji.heroes.domain.callbacks.ResultCallback;
import com.pabji.heroes.domain.enums.ResultError;
import com.pabji.heroes.domain.models.SuperHero;
import com.pabji.heroes.presentation.navigation.Router;

import javax.inject.Inject;

public class HeroDetailPresenter extends BasePresenter<HeroDetailView> {

    private Router router;
    private HeroDetailInteractor heroDetailInteractor;

    @Inject
    public HeroDetailPresenter(Router router, HeroDetailInteractor heroDetailIteractor) {
        this.router = router;
        this.heroDetailInteractor = heroDetailIteractor;
    }

    public void init(final Context context) {
        heroDetailInteractor.run(new ResultCallback<SuperHero>() {
            @Override
            public void onSuccess(SuperHero result) {
                showHeroDetail(result);
            }

            @Override
            public void onError(ResultError error) {
                getView().showError("ERROR");
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
