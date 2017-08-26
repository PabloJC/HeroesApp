package com.pabji.heroes.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pabji.heroes.R;
import com.pabji.heroes.domain.models.SuperHero;
import com.pabji.heroes.domain.features.heroeList.HeroeListPresenter;
import com.pabji.heroes.domain.features.heroeList.HeroeListView;
import com.pabji.heroes.presentation.activities.main.MainActivity;
import com.pabji.heroes.presentation.base.BaseMVPFragment;

import java.util.List;

public class HeroeListFragment extends BaseMVPFragment<HeroeListPresenter,HeroeListView> implements HeroeListView{

    public static HeroeListFragment newInstance() {
        return new HeroeListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_heroeslist, viewGroup, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.init(getContext());
    }

    @NonNull
    @Override
    public HeroeListPresenter createPresenter() {
        return ((MainActivity)this.getActivity()).getComponent().heroeListPresenter();
    }

    @Override
    public void showList(List<SuperHero> superHeros) {
        Log.d("Heroes",superHeros.toString());
    }
}

