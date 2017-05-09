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
    private String[] movie_name=new String[3];
    private String[] image_url=new String[3];
    private String[] release_date=new String[3];
    private String[] prediction=new String[3];




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

        //receiving the data from database and populating it to the adapter
            DataReceiver data= new DataReceiver(getContext());
            movie_name=data.getMovie_name();
        DataReceiver data1= new DataReceiver(getContext());
            image_url=data1.getImagelink();
        DataReceiver data2= new DataReceiver(getContext());

        release_date=data2.getRelease_date();
        DataReceiver data3= new DataReceiver(getContext());

        prediction=data3.getPrediction();
        CustomAdapter adapter = new CustomAdapter(getActivity(), movie_name, image_url,release_date);
        grid=(GridView)view.findViewById(R.id.gridview);
        grid.setAdapter(adapter);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

        Intent intent = new Intent(getActivity(), ShowResult.class);
                Bundle extras = new Bundle();

                extras.putString("name",movie_name[position]);
                extras.putString("image_url",image_url[position]);
                extras.putString("release_date",release_date[position]);
                extras.putString("prediciton",prediction[position]);
                intent.putExtras(extras);

                startActivity(intent);
            }
        });
        return view;
    }

}
