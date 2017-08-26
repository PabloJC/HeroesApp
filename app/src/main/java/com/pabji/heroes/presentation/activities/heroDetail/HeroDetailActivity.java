package com.pabji.heroes.presentation.activities.heroDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pabji.heroes.R;
import com.pabji.heroes.domain.features.heroDetail.HeroDetailPresenter;
import com.pabji.heroes.domain.features.heroDetail.HeroDetailView;
import com.pabji.heroes.presentation.base.BaseMVPActivity;
import com.pabji.heroes.presentation.di.HasComponent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HeroDetailActivity  extends BaseMVPActivity<HeroDetailPresenter,HeroDetailView> implements HasComponent<HeroDetailComponent>, HeroDetailView {

    private HeroDetailComponent component;

    @BindView(R.id.iv_hero_photo)
    ImageView iv_heroPhoto;
    @BindView(R.id.tv_hero_name)
    TextView tv_heroName;
    @BindView(R.id.tv_hero_realname)
    TextView tv_heroRealName;
    @BindView(R.id.tv_hero_power)
    TextView tv_heroPower;
    @BindView(R.id.tv_hero_height)
    TextView tv_heroHeight;
    @BindView(R.id.tv_hero_abilities)
    TextView tv_heroAbilities;
    @BindView(R.id.tv_hero_groups)
    TextView tv_heroGroups;
    private Unbinder unbind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);
        unbind = ButterKnife.bind(this);
        presenter.init(this);

    }


    @Override
    protected void initInjector() {
        this.component = DaggerHeroDetailComponent.builder().appComponent(getInjector()).build();
    }

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, HeroDetailActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbind.unbind();
    }

    @Override
    public HeroDetailComponent getComponent() {
        return component;
    }

    @NonNull
    @Override
    public HeroDetailPresenter createPresenter() {
        return component.heroeDetailPresenter();
    }

    @Override
    public void showPhoto(String photo) {
        Glide.with(this).load(photo).centerCrop().into(iv_heroPhoto);
    }

    @Override
    public void showName(String name) {
        tv_heroName.setText(name);
    }

    @Override
    public void showRealName(String realName) {
        tv_heroRealName.setText(realName);
    }

    @Override
    public void showPower(String power) {
        tv_heroPower.setText(power);
    }

    @Override
    public void showHeight(String height) {
        tv_heroHeight.setText(height);
    }

    @Override
    public void showAbilities(String abilities) {
        tv_heroAbilities.setText(abilities);
    }

    @Override
    public void showGroups(String groups) {
        tv_heroGroups.setText(groups);
    }
}
