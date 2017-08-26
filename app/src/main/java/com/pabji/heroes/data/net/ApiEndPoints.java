package com.pabji.heroes.data.net;

import com.pabji.heroes.data.entities.ApiEntity;

import retrofit2.http.GET;
import rx.Observable;

public interface ApiEndPoints {
    @GET("bvyob")
    Observable<ApiEntity> getApiModel();
}