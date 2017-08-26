package com.pabji.heroes.data.repositories.heroe;

import com.pabji.heroes.data.entities.ApiEntity;
import com.pabji.heroes.domain.models.SuperHero;

import rx.Observable;

public interface ApiRepository {
    Observable<ApiEntity> getApiModel();

    void setCurrentHero(SuperHero superHero);

    SuperHero getCurrentHero();
}