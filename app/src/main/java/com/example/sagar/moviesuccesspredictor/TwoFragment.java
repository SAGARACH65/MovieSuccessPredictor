package com.example.sagar.moviesuccesspredictor;

/**
 * Created by Sagar on 5/6/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class TwoFragment extends Fragment{
    String[] web = {
            "Bahubali 2",
            "3 idiots",
            "sagar"


    } ;
    String[] imageId = {
            "https://www.desiretrees.in/wp-content/uploads/2016/12/Baahubali-2-Posters.jpg",
            "http://s3.india.com/wp-content/uploads/2016/01/3-idiots-sequel-1.jpg",
            "http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg"

    };
    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        GridView grid;
        View view = inflater.inflate(R.layout.fragment_two, container, false);


        ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);


        CustomAdapter adapter = new CustomAdapter(getActivity(), web, imageId);
        grid=(GridView)view.findViewById(R.id.gridview);
        grid.setAdapter(adapter);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

        Intent intent = new Intent(getActivity(), ShowResult.class);
                intent.putExtra("prediction", "Success");
                startActivity(intent);
            }
        });
        return view;
    }

}
