package com.pabji.heroes.presentation.activities.heroDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
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
    @BindView(R.id.hero_realname)
    View v_heroRealName;
    @BindView(R.id.hero_power)
    View v_heroPower;
    @BindView(R.id.hero_height)
    View v_heroHeight;
    @BindView(R.id.hero_abilities)
    View v_heroAbilities;
    @BindView(R.id.hero_groups)
    View v_heroGroups;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;


    private Unbinder unbind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);
        unbind = ButterKnife.bind(this);

        setupToolbar(toolbar);

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
        collapsingToolbarLayout.setTitle(name);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }

    @Override
    public void showRealName(String realName) {
        setElemContent(v_heroRealName,R.drawable.ic_name,"Real Name",realName);
    }

    @Override
    public void showPower(String power) {
        setElemContent(v_heroPower,R.drawable.power,"Power",power);
    }

    @Override
    public void showHeight(String height) {
        setElemContent(v_heroHeight,R.drawable.ic_height,"Height",height);
    }

    @Override
    public void showAbilities(String abilities) {
        setElemContent(v_heroAbilities,R.drawable.ic_ability,"Abilities",abilities);
    }

    @Override
    public void showGroups(String groups) {
        setElemContent(v_heroGroups,R.drawable.ic_group,"Groups",groups);
    }

    @Override
    public void showError(String error) {

    }

    private void setElemContent(View view,@DrawableRes int icon, String title, String description){
        ImageView elem_icon = view.findViewById(R.id.ic_elem);
        TextView elem_title = view.findViewById(R.id.tv_elem_title);
        TextView elem_description = view.findViewById(R.id.tv_elem_description);

        Glide.with(this).load(icon).into(elem_icon);
        elem_title.setText(title);
        elem_description.setText(description);
    }
}
