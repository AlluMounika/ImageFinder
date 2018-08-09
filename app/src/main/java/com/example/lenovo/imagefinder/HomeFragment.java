package com.example.lenovo.imagefinder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {
    RecyclerView rev;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_home, container,false);
        // Inflate the layout for this fragment
        rev=rootview.findViewById(R.id.recycler);
        getImagenames();
        return rootview;
    }
    private void getImagenames() {
        List<ImagePojo> images;
        final String BASE_URL = "https://api.flickr.com/services/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ImageApi retrofitClass = retrofit.create(ImageApi.class);
        Call<ImagePojo> call = retrofitClass.getImages("https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s");
        call.enqueue(new Callback<ImagePojo>() {
            @Override
            public void onResponse(Call<ImagePojo> call, Response<ImagePojo> response) {
                ImagePojo List = response.body();
                Log.i("list", List.getStat());
                rev.setLayoutManager(new GridLayoutManager(getActivity(), 1));
                rev.setAdapter(new ImageAdapter(getActivity(), List.getPhotos().getPhoto()));
            }

            @Override
            public void onFailure(Call<ImagePojo> call, Throwable t) {
                Log.i("response", t.getMessage());
                Toast.makeText(getContext(), "onFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
