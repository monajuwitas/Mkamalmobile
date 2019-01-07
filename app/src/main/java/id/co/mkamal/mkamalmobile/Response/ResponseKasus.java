package id.co.mkamal.mkamalmobile.Response;

import java.util.List;

import id.co.mkamal.mkamalmobile.Model.ModelKasus;

/**
 * Created by monajuwitas on 10/3/2018.
 */

public class ResponseKasus {
    String response_code, status;
    List<ModelKasus> data;

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

    public List<ModelKasus> getData() {
        return data;
    }

    public void setData(List<ModelKasus> data) {
        this.data = data;
    }
}
