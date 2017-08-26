package com.pabji.heroes.presentation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pabji.heroes.R;
import com.pabji.heroes.domain.models.SuperHero;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroeListItemHolder> {

    private List<SuperHero> listItem = new ArrayList<>();

    private static final int TYPE1 = 0;
    private static final int TYPE2 = 1;
    private HeroListListener listener;

    public interface HeroListListener {
        void openDetail(SuperHero superHero);
    }

    @Inject
    public HeroListAdapter(){}

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return  TYPE1;
        }
        return TYPE2;
    }

    @Override
    public HeroListAdapter.HeroeListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero_list_1, parent, false);

        if(viewType == TYPE2){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero_list_2, parent, false);
        }

        return new HeroeListItemHolder(view);
    }

    @Override
    public void onBindViewHolder(HeroListAdapter.HeroeListItemHolder holder, int position) {
        holder.bindItem(listItem.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listItem.size();
    }


    public void setData(List<SuperHero> heroList, HeroListListener listener) {
        this.listItem = heroList;
        this.listener = listener;
        this.notifyDataSetChanged();
    }


    public class HeroeListItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_hero_name)
        TextView tv_heroName;

        @BindView(R.id.iv_hero_photo)
        ImageView iv_heroPhoto;
        private SuperHero superHero;


        public HeroeListItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(SuperHero superHero) {
            this.superHero = superHero;

            tv_heroName.setText(superHero.getName());
            Glide.with(itemView.getContext()).load(superHero.getPhoto()).centerCrop().into(iv_heroPhoto);
        }

        @OnClick(R.id.item)
        public void clickItem(){
            listener.openDetail(superHero);
        }
    }
}
