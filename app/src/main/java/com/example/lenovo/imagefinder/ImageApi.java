package com.example.lenovo.imagefinder;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ImageApi {

    @GET
        //("rest/?method=flickr.photos.getRecent&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
    Call<ImagePojo> getImages(@Url String url);

}
