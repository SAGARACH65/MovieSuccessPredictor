package com.example.sagar.moviesuccesspredictor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Sagar on 5/7/2017.
 */

public class CustomAdapter extends BaseAdapter {


    private Context mContext;
    private final String[] web;//text
    private final String[] Imagelink;//image
    public CustomAdapter(Context c,String[] web,String[] Imagelink ) {
        mContext = c;
        this.Imagelink = Imagelink;
        this.web = web;
    }
    @Override
    public int getCount() {
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.fragment_item_list, null);
            TextView textView = (TextView) grid.findViewById(R.id.textViewa);
            ImageView imageView = (ImageView)grid.findViewById(R.id.imageView1);
            textView.setText(web[position]);

            //get image from web and set
            //Context c = getActivity().getApplicationContext();
            Picasso.with(mContext)
                    .load(Imagelink[position]).fit().
                    placeholder(R.drawable.aa).error(R.drawable.ab)
                    .into(imageView);

        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
