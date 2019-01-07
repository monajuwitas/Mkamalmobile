package id.co.mkamal.mkamalmobile.Utils;

import android.content.Context;

/**
 * Created by monajuwitas on 10/6/2018.
 */

public class LoginSession {
    private static LoginSession instance = null;
    public String sessionId, nama, level;
    private  Context context;
    private LoginSession(Context context) {
        this.context = context;
    }

    public static LoginSession getInstance(Context context) {
        if (instance == null) {
            instance = new LoginSession(context);
        }
        return instance;
    }

    public void setParam(String sessionId, String nama, String level) {
        if (sessionId != null) {
            setSessionId(sessionId, nama, level);
        }
    }


    public String getSessionId() {
        if (sessionId == null) {
            sessionId = "";
        }
        return sessionId;
    }
    public String getNama() {
        if (nama == null) {
            nama = "";
        }
        return nama;
    }

    public String getLevel() {
        if (level == null) {
            level = "";
        }
        return level;
    }


    public void setSessionId(String sessionId,  String nama, String level) {
        this.sessionId = sessionId;
        this.nama = nama;
        this.level = level;
    }


    public void clear() {
        if (instance != null) {
            setSessionId(null,null,null);
        }
    }


}
