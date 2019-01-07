package id.co.mkamal.mkamalmobile.Response;

import java.util.List;

import id.co.mkamal.mkamalmobile.Model.ModelKegiatan;

/**
 * Created by monajuwitas on 10/4/2018.
 */

public class ResponseKegiatan {
    String response_code,status;
    List<ModelKegiatan> data;

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

    public List<ModelKegiatan> getData() {
        return data;
    }

    public void setData(List<ModelKegiatan> data) {
        this.data = data;
    }
}
