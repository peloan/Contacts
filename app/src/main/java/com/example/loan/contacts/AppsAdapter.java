package com.example.loan.contacts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by LOAN on 8/7/2016.
 */
public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.AppViewHolder>
{
    //class viewholder
    public static class AppViewHolder extends RecyclerView.ViewHolder
    {
        private Context mContext;
        ImageView mIconApps;
        TextView mNameApps;
        TextView mPackge;
        View mView;
        public AppViewHolder(View itemView, Context context) {
            super(itemView);
            this.mContext=context;
            //get id
            mIconApps=(ImageView) itemView.findViewById(R.id.iconApp);
            mNameApps=(TextView) itemView.findViewById(R.id.appName);
            mPackge=(TextView) itemView.findViewById(R.id.appPackge);
            this.mView=itemView;
        }
        public void setData(final PackageInfo packageInfo)
        {
            mNameApps.setText(packageInfo.applicationInfo.loadLabel(mContext.getPackageManager()).toString());
            mPackge.setText(packageInfo.packageName);
            mIconApps.setImageDrawable(packageInfo.applicationInfo.loadIcon(mContext.getPackageManager()));
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PackageManager packageManager=mContext.getPackageManager();
                    Intent intent=packageManager.getLaunchIntentForPackage(packageInfo.packageName);
                    if(intent!=null)
                    {
                        intent.addCategory(Intent.CATEGORY_LAUNCHER);
                        mContext.startActivity(intent);

                    }
                    else
                        Toast.makeText(mContext,"Cant'n Open this app",Toast.LENGTH_LONG).show();

                }
            });

        }
    }
    private List<PackageInfo> appList;
    private Context mContext;

    public AppsAdapter(List<PackageInfo> appList, Context mContext) {
        super();
        this.appList = appList;
        this.mContext = mContext;
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public AppsAdapter.AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view;
        final AppViewHolder viewHolder;
        Context context=parent.getContext();
        view=LayoutInflater.from(context).inflate(R.layout.recycleview_app,parent,false);
        viewHolder=new AppViewHolder(view,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AppsAdapter.AppViewHolder holder, int position) {
        if(holder!=null)
        {
            holder.setData(appList.get(position));
        }
    }
}
