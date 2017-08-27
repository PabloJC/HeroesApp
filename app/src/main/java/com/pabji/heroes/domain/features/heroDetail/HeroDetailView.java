package com.pabji.heroes.domain.features.heroDetail;

import com.pabji.heroes.domain.base.BaseView;
import com.pabji.heroes.domain.models.SuperHero;

import java.util.List;

public interface HeroDetailView extends BaseView {

    void showPhoto(String photo);

    void showName(String name);

    void showRealName(String realName);

    void showPower(String power);

    void showHeight(String height);

    void showAbilities(String abilities);

    void showGroups(String groups);


}
