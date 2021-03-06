package com.drainey.popularmovies.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by david-rainey on 5/7/18.
 */
@Entity(tableName = "movie")
public class Movie implements Parcelable{
    private String title;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movie_id")
    private String movieId;
    @ColumnInfo(name = "image_url")
    private String imageUrl;
    private String overview;
    @ColumnInfo(name = "backdrop_path")
    private String backdropPath;
    @ColumnInfo(name = "movie_rating")
    private String movieRating;
    @ColumnInfo(name = "release_date")
    private String releaseDate;
    @ColumnInfo(name = "original_title")
    private String originalTitle;

    @Ignore
    public Movie(){
        // no-arg default constructor
    }

    @Ignore
    public Movie(Parcel in){
        ReadFromParcel(in);
    }

    public Movie(String title, String movieId, String imageUrl, String overview, String backdropPath, String movieRating, String releaseDate, String originalTitle) {
        this.title = title;
        this.movieId = movieId;
        this.imageUrl = imageUrl;
        this.overview = overview;
        this.backdropPath = backdropPath;
        this.movieRating = movieRating;
        this.releaseDate = releaseDate;
        this.originalTitle = originalTitle;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Movie createFromParcel(Parcel in ) {
            return new Movie( in );
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    private void ReadFromParcel(Parcel in){
        title = in.readString();
        movieId = in.readString();
        imageUrl = in.readString();
        overview = in.readString();
        backdropPath = in.readString();
        movieRating = in.readString();
        releaseDate = in.readString();
        originalTitle = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(movieId);
        parcel.writeString(imageUrl);
        parcel.writeString(overview);
        parcel.writeString(backdropPath);
        parcel.writeString(movieRating);
        parcel.writeString(releaseDate);
        parcel.writeString(originalTitle);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    @Override
    public String toString() {
        return "Movie{" +
                " title='" + title + '\'' +
                ", movieId='" + movieId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", overview='" + overview + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", movieRating='" + movieRating + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
