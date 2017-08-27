package com.pabji.heroes.domain.features.heroList;

import com.pabji.heroes.domain.models.SuperHero;
import com.pabji.heroes.domain.base.BaseView;

import java.util.ArrayList;
import java.util.List;

public interface HeroListView extends BaseView {

    void showList(List<SuperHero> superHeros);

    void showLoading();

    void dismissLoading();
}
