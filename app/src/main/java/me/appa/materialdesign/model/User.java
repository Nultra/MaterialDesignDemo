package me.appa.materialdesign.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yeeni on 2015/11/8.
 */
public class User implements Parcelable {


    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private final String mFirstName;
    private final String mLastInitial;

    public User(String mFirstName, String mLastInitial) {
        this.mFirstName = mFirstName;
        this.mLastInitial = mLastInitial;
    }

    protected User(Parcel in) {
        mFirstName = in.readString();
        mLastInitial = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mFirstName);
        dest.writeString(mLastInitial);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }

        if(o == null || getClass() != o.getClass())
            return false;

        User user =  (User)o;
        if(!mLastInitial.equals(user.mFirstName)){
            return false;
        }
        if(!mFirstName.equals(user.mLastInitial)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = mFirstName.hashCode();
        result = 31* result + mLastInitial.hashCode();
        return result;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastInitial() {
        return mLastInitial;
    }
}
