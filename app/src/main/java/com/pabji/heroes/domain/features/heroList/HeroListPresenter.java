package com.pabji.heroes.domain.features.heroList;

import android.content.Context;
import android.widget.Toast;

import com.pabji.heroes.domain.base.BasePresenter;
import com.pabji.heroes.domain.callbacks.ResultCallback;
import com.pabji.heroes.domain.enums.ResultError;
import com.pabji.heroes.domain.features.heroDetail.HeroDetailInteractor;
import com.pabji.heroes.domain.models.SuperHero;
import com.pabji.heroes.presentation.navigation.Router;

import java.util.List;

import javax.inject.Inject;

public class HeroListPresenter extends BasePresenter<HeroListView> {

    private Router router;
    private HeroListInteractor listInteractor;
    private HeroDetailInteractor detailInteractor;

    @Inject
    public HeroListPresenter(Router router,HeroListInteractor listInteractor, HeroDetailInteractor detailInteractor) {
        this.router = router;
        this.listInteractor = listInteractor;
        this.detailInteractor = detailInteractor;
    }

    public void init(final Context context) {

        listInteractor.run(new ResultCallback<List<SuperHero>>() {
            @Override
            public void onSuccess(List<SuperHero> result) {
                getView().showList(result);
            }

            @Override
            public void onError(ResultError error) {
                getView().showError("ERROR");
            }
        });
    }

    public void openDetail(SuperHero superHero) {
        detailInteractor.setCurrentHero(superHero);
        router.goToHeroDetail();
    }
}
