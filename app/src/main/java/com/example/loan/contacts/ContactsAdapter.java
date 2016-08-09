package com.example.loan.contacts;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LOAN on 8/7/2016.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.RecycleViewHolder>
{
    //class ViewHolder
    public static class RecycleViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mPhoneNumber;
        public TextView mName;
        public ImageView mImagePeople;
        public ImageView mImageCall;
        private Context mContext;
        public RecycleViewHolder(View itemView, Context context) {
            super(itemView);

            //get id
            mPhoneNumber=(TextView)itemView.findViewById(R.id.textViewPhone);
            mName=(TextView)itemView.findViewById(R.id.textViewName);
            mImagePeople=(ImageView)itemView.findViewById(R.id.imagePeople);
            mImageCall=(ImageView)itemView.findViewById(R.id.imageIconCall);
            this.mContext=context;
            //call
            mImageCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try
                    {
                        Intent intent=new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel: "+mPhoneNumber.getText()));
                        mContext.startActivity(intent);
                    }
                    catch (ActivityNotFoundException e)
                    {
                        Log.i("Sorry","Call faile",e);
                    }

                }
            });
        }
        public void setData(Phone phone)
        {
            mPhoneNumber.setText(phone.getNumber());
            mName.setText(phone.getName());
            //show icon call
            if(phone.getIcon()==null)
                mImageCall.setImageResource(R.mipmap.call);
            //get photo from contacts
            if(phone.getIcon()!=null)
                mImagePeople.setImageURI(phone.getIcon());
            else
                mImagePeople.setImageResource(R.mipmap.people);
        }
        //call
    }
    private List<Phone> mPhoneList;
    private Context mContext;
    public ContactsAdapter(List<Phone> phones, Context context) {
        super();
        this.mPhoneList=phones;
        this.mContext=context;
    }
    @Override
    public int getItemCount() {
        return mPhoneList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public ContactsAdapter.RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        final RecycleViewHolder viewHolder;
        Context context=parent.getContext();
        view=LayoutInflater.from(context).inflate(R.layout.recycleview_contacts,parent,false);
        viewHolder=new RecycleViewHolder(view,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.RecycleViewHolder holder, int position)
    {
        if(holder!=null)
        {
            holder.setData(mPhoneList.get(position));
        }
    }
}
