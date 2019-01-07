package id.co.mkamal.mkamalmobile.API;

import java.awt.font.TextAttribute;

import id.co.mkamal.mkamalmobile.Response.ResponseKasus;
import id.co.mkamal.mkamalmobile.Response.ResponseKegiatan;
import id.co.mkamal.mkamalmobile.Response.ResponseLogin;
import id.co.mkamal.mkamalmobile.Response.ResponseProfil;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by monajuwitas on 10/3/2018.
 */

public interface MobileAPI {
    @Headers({
            "Content-Type:application/x-www-form-urlencoded"
    })

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseLogin> login(@Field("username") String username,
                              @Field("password") String password);

    @GET("daftarkasus.php")
    Call<ResponseKasus> list_kasus();

    @GET("daftarkegiatan.php")
    Call<ResponseKegiatan> list_kegiatan();

    @GET("profil.php")
    Call<ResponseProfil> dataprofil(@Query("idadmin") String idadmin);

}
