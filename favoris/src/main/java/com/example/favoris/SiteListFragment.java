package com.example.favoris;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class SiteListFragment extends Fragment implements AdapterView.OnItemClickListener {
    ListView linksList;
    ArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_site_list,
                container, false);
        linksList= view.findViewById(R.id.listview1);
        adapter=new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,new BookmarkedSites().getdata(getContext()));
        linksList.setAdapter(adapter);
        linksList.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(getContext(),(String)adapter.getItem(position),Toast.LENGTH_LONG).show();
        WebSiteFragment webSiteFragment= new WebSiteFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, webSiteFragment.newInstance((String)adapter
                        .getItem(position)),(String)adapter.getItem(position))
                .addToBackStack(null)
                .commit();

    }



}