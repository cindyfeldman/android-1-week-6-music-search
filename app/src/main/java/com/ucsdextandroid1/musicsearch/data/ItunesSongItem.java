package com.ucsdextandroid1.musicsearch.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rjaylward on 2019-05-11
 */
public class ItunesSongItem implements SongItem, Parcelable {

    //TODO add all the members to this class with proper serialized names
    @SerializedName("trackID")
    private int trackID;
    @SerializedName("trackName")
    private String trackName;
    @SerializedName("artistName")
    private String artistName;
    @SerializedName("collectionName")
    private String albumName;
    @SerializedName("artworkUrl100")
    private String artwork;
    @SerializedName("previewUrl")
    private String previewURL;
    @SerializedName("trackTimeMillis")
    private int TrackTime;

    protected ItunesSongItem(Parcel in) {
        trackID = in.readInt();
        trackName = in.readString();
        artistName = in.readString();
        albumName = in.readString();
        artwork = in.readString();
        previewURL = in.readString();
        TrackTime = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(trackID);
        dest.writeString(trackName);
        dest.writeString(artistName);
        dest.writeString(albumName);
        dest.writeString(artwork);
        dest.writeString(previewURL);
        dest.writeInt(TrackTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItunesSongItem> CREATOR = new Creator<ItunesSongItem>() {
        @Override
        public ItunesSongItem createFromParcel(Parcel in) {
            return new ItunesSongItem(in);
        }

        @Override
        public ItunesSongItem[] newArray(int size) {
            return new ItunesSongItem[size];
        }
    };

    @Override
    public long getTrackId() {
        return trackID;
    }

    @Override
    public String getTrackName() {
        return trackName;
    }

    @Override
    public String getArtistName() {
        return artistName;
    }

    @Override
    public String getAlbumName() {
        return albumName;
    }

    @Override
    public String getArtworkUrl() {
        return artwork;
    }

    @Override
    public String getPreviewUrl() {
        return previewURL;
    }

    @Override
    public long getTrackTime() {
        return TrackTime;
    }

}
