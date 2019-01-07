package id.co.mkamal.mkamalmobile.Response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;



/**
 * Created by monajuwitas on 10/5/2018.
 */

public class ResponseLogin implements Parcelable {

   String response_code,status,idamin,namalengkap,level;

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdamin() {
        return idamin;
    }

    public void setIdamin(String idamin) {
        this.idamin = idamin;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.response_code);
        dest.writeString(this.status);
        dest.writeString(this.idamin);
        dest.writeString(this.namalengkap);
        dest.writeString(this.level);
    }

    public ResponseLogin() {
    }

    protected ResponseLogin(Parcel in) {
        this.response_code = in.readString();
        this.status = in.readString();
        this.idamin = in.readString();
        this.namalengkap = in.readString();
        this.level = in.readString();
    }

    public static final Parcelable.Creator<ResponseLogin> CREATOR = new Parcelable.Creator<ResponseLogin>() {
        @Override
        public ResponseLogin createFromParcel(Parcel source) {
            return new ResponseLogin(source);
        }

        @Override
        public ResponseLogin[] newArray(int size) {
            return new ResponseLogin[size];
        }
    };
}
