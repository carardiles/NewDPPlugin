package com.percolatestudio.cordova.empty;

import org.apache.cordova.Config;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

public class NewDPPlugin extends CordovaPlugin {

    protected static final String LOG_TAG = "NewDPPlugin";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("conectar")) {
            metodoDummy();
            callbackContext.success();
            return true;
        }
        else if(action.equals("capturar")){
            metodoDummy();
            callbackContext.success();
            return true;
        }
        return false;
    }

    protected void metodoDummy() {
        Log.d(LOG_TAG, "NewDPPlugin");
    }
}
