
package com.example.lenovo.imagefinder;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos implements Parcelable
{

    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("pages")
    @Expose
    private int pages;
    @SerializedName("perpage")
    @Expose
    private int perpage;
    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("photo")
    @Expose
    private List<Photo> photo = null;
    public final static Creator<Photos> CREATOR = new Creator<Photos>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Photos createFromParcel(Parcel in) {
            return new Photos(in);
        }

        public Photos[] newArray(int size) {
            return (new Photos[size]);
        }

    }
    ;

    protected Photos(Parcel in) {
        this.page = ((int) in.readValue((int.class.getClassLoader())));
        this.pages = ((int) in.readValue((int.class.getClassLoader())));
        this.perpage = ((int) in.readValue((int.class.getClassLoader())));
        this.total = ((int) in.readValue((int.class.getClassLoader())));
        in.readList(this.photo, (Photo.class.getClassLoader()));
    }

    public Photos() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeValue(pages);
        dest.writeValue(perpage);
        dest.writeValue(total);
        dest.writeList(photo);
    }

    public int describeContents() {
        return  0;
    }

}
