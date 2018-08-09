
package com.example.lenovo.imagefinder;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImagePojo implements Parcelable
{

    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("stat")
    @Expose
    private String stat;
    public final static Creator<ImagePojo> CREATOR = new Creator<ImagePojo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ImagePojo createFromParcel(Parcel in) {
            return new ImagePojo(in);
        }

        public ImagePojo[] newArray(int size) {
            return (new ImagePojo[size]);
        }

    }
    ;

    protected ImagePojo(Parcel in) {
        this.photos = ((Photos) in.readValue((Photos.class.getClassLoader())));
        this.stat = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ImagePojo() {
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(photos);
        dest.writeValue(stat);
    }

    public int describeContents() {
        return  0;
    }

}
