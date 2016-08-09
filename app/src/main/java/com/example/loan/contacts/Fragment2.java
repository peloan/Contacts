package com.example.loan.contacts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_fragment2,container,false);
        RecyclerView recyclerView=(RecyclerView) rootView.findViewById(R.id.recycleViewvApps);
        recyclerView.setAdapter(new AppsAdapter(getActivity().getPackageManager().getInstalledPackages(0),getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
        //listView.setAdapter(new ListViewAdapterApp(getActivity(), getActivity().getPackageManager().getInstalledPackages(0)));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
