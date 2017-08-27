package com.pabji.heroes.domain.features.heroDetail;

import android.content.Context;

import com.pabji.heroes.domain.callbacks.ResultCallback;
import com.pabji.heroes.domain.enums.ResultError;
import com.pabji.heroes.domain.features.heroList.HeroListInteractor;
import com.pabji.heroes.domain.features.heroList.HeroListPresenter;
import com.pabji.heroes.domain.features.heroList.HeroListView;
import com.pabji.heroes.domain.models.SuperHero;
import com.pabji.heroes.presentation.navigation.Router;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by PabloJC on 26/8/17.
 */
public class HeroDetailPresenterTest {

    private HeroDetailPresenter heroDetailPresenter;

    @Mock
    private HeroDetailView mockHeroDetailView;

    @Mock private HeroDetailInteractor mockDetailIteractor;

    @Mock private Context mockContext;

    @Captor
    private ArgumentCaptor<ResultCallback<SuperHero>> loadCaptor;

    private static SuperHero SUPERHERO = new SuperHero("Name1","Photo1","RealName1","Height1","Power1","Abilities1","Groups1");

    private static final String ERROR = "ERROR";


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);

        heroDetailPresenter = new HeroDetailPresenter(mockDetailIteractor);
        heroDetailPresenter.attachView(mockHeroDetailView);
    }

    @Test
    public void initShowDetail() throws Exception {

        heroDetailPresenter.init(mockContext);
        verify(mockDetailIteractor).run(loadCaptor.capture());

        loadCaptor.getValue().onSuccess(SUPERHERO);
        verify(mockHeroDetailView).showName(SUPERHERO.getName());
        verify(mockHeroDetailView).showRealName(SUPERHERO.getRealName());
        verify(mockHeroDetailView).showPower(SUPERHERO.getPower());
        verify(mockHeroDetailView).showHeight(SUPERHERO.getHeight());
        verify(mockHeroDetailView).showPhoto(SUPERHERO.getPhoto());
        verify(mockHeroDetailView).showAbilities(SUPERHERO.getAbilities());
        verify(mockHeroDetailView).showGroups(SUPERHERO.getGroups());
    }

    @Test
    public void initShowError() throws Exception {

        heroDetailPresenter.init(mockContext);

        verify(mockDetailIteractor).run(loadCaptor.capture());
        loadCaptor.getValue().onError(ResultError.API_ERROR);
        verify(mockHeroDetailView).showError(ERROR);
    }



}