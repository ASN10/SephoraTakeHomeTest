package com.sephora.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sephora.activity.ProductsListActivity;
import com.sephora.adapter.CategoryAdapter;
import com.sephora.app.Extras;
import com.sephora.app.R;
import com.sephora.model.NavigationDrawerItem;

import java.util.ArrayList;

/**
 * Created by nivedhitha.a on 26-Apr-16.
 */
public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView categoryListView;
    private ArrayList<NavigationDrawerItem> categoryList;
    private CategoryAdapter categoryAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        setDataSource();
        setAdapter();
        return view;
    }

    /**
     * bind views
     * @param view
     */
    private void initViews(View view) {
        categoryListView = (ListView) view.findViewById(R.id.categories_listview);
        categoryListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        Intent intent = new Intent(getActivity(), ProductsListActivity.class);
        intent.putExtra(Extras.EXTRAS_CATEGORY, categoryList.get(position).getCategoryKey());
        intent.putExtra(Extras.EXTRAS_CATEGORY_NAME, categoryList.get(position).getCategoryName());
        startActivity(intent);
    }

    /**
     * create data source to adapter
     */
    private void setDataSource() {
        categoryList = new ArrayList<>();
        String[] categoryKeys = getResources().getStringArray(R.array.category_keys);
        NavigationDrawerItem itemMakeUp = new NavigationDrawerItem();
        itemMakeUp.setCategoryName(getString(R.string.make_up_title));
        itemMakeUp.setIcon(R.drawable.makeup_edit);
        itemMakeUp.setIsCategory(false);
        itemMakeUp.setCategoryKey(categoryKeys[0]);
        categoryList.add(itemMakeUp);

        NavigationDrawerItem itemSkincare = new NavigationDrawerItem();
        itemSkincare.setCategoryName(getString(R.string.skin_care_title));
        itemSkincare.setIcon(R.drawable.skin_care_edit);
        itemSkincare.setIsCategory(false);
        itemSkincare.setCategoryKey(categoryKeys[1]);
        categoryList.add(itemSkincare);

        NavigationDrawerItem itemHair = new NavigationDrawerItem();
        itemHair.setCategoryName(getString(R.string.hair_title));
        itemHair.setIcon(R.drawable.hair_do);
        itemHair.setIsCategory(false);
        itemHair.setCategoryKey(categoryKeys[2]);
        categoryList.add(itemHair);

        NavigationDrawerItem itemTools = new NavigationDrawerItem();
        itemTools.setCategoryName(getString(R.string.tools_title));
        itemTools.setIcon(R.drawable.tools_brushes_edit);
        itemTools.setIsCategory(false);
        itemTools.setCategoryKey(categoryKeys[3]);
        categoryList.add(itemTools);


        NavigationDrawerItem itemNails = new NavigationDrawerItem();
        itemNails.setCategoryName(getString(R.string.nails_title));
        itemNails.setIcon(R.drawable.nails);
        itemNails.setIsCategory(false);
        itemNails.setCategoryKey(categoryKeys[4]);
        categoryList.add(itemNails);

        NavigationDrawerItem itemBath = new NavigationDrawerItem();
        itemBath.setCategoryName(getString(R.string.bath_body));
        itemBath.setIcon(R.drawable.bath_body);
        itemBath.setIsCategory(false);
        itemBath.setCategoryKey(categoryKeys[5]);
        categoryList.add(itemBath);

    }


    private void setAdapter() {
        categoryAdapter = new CategoryAdapter(getActivity(), R.layout.listitem_category, categoryList);
        categoryListView.setAdapter(categoryAdapter);
    }

}
