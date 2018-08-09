package com.example.lenovo.imagefinder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    RecyclerView rev;
    EditText editText;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rV=inflater.inflate(R.layout.fragment_search,null);
        rev=rV.findViewById(R.id.recycler1);
        editText=rV.findViewById(R.id.ed);
        button=rV.findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=editText.getText().toString();
                Toast.makeText(rV.getContext(), s, Toast.LENGTH_SHORT).show();
                // Inflate the layout for this fragment
                getImagenames(s);
            }
        });
        return rV;
    }

    private void getImagenames(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
        List<ImagePojo> images;
        final String BASE_URL = "https://api.flickr.com/services/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ImageApi retrofitClass = retrofit.create(ImageApi.class);
        //rest/?method=flickr.photos.search&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s&text=cat
        //Call<ImagePojo> call = retrofitClass.getImages("rest/?method=flickr.photos.getRecent&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s&text="+s);
        Call<ImagePojo> call = retrofitClass.getImages("rest/?method=flickr.photos.search&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s&text="+s);
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
                Toast.makeText(getActivity(), "onFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
