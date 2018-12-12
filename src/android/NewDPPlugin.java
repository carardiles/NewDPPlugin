package cl.entel.plugins.NewDPPlugin;

// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;

import android.graphics.Bitmap;
import android.util.Log;
import android.app.Activity;

import android.content.Context;
import android.content.Intent;

import java.io.ByteArrayOutputStream;
import android.util.Base64;

public class NewDPPlugin extends CordovaPlugin {

    private static final String TAG = "NEWDPPLUGIN";

    private CallbackContext callbackContext = null;
    
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext newCallbackContext) {
        Log.i(TAG, "execute");

        Context context = cordova.getActivity().getApplicationContext();
        if ("contectar".equals(action)) {
            Log.i(TAG, "contectar Action");

            callbackContext = newCallbackContext;
            cordova.setActivityResultCallback(this);

            Intent intent = new Intent(context, NewActivity.class);
            intent.putExtra("action",action);
            this.cordova.getActivity().startActivityForResult(intent, 1);

            return true;
        }
        else if("capturar".equals(action)){
            Log.i(TAG, "capturar Action");
            
            callbackContext = newCallbackContext;
            cordova.setActivityResultCallback(this);

            Intent intent = new Intent(context, NewActivity.class);
            intent.putExtra("action",action);
            this.cordova.getActivity().startActivityForResult(intent, 1);

            return true;
        }
        callbackContext.error("No existe metodo: " + action);
        Log.i(TAG, "error");
        return false;
    }

    @Override
    public  void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.i(TAG, "Activity Result");

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){

                Log.i(TAG, "Activity Result OK");
               
                String msg = "OK";
                
                PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, msg);
                pluginResult.setKeepCallback(true);
                callbackContext.sendPluginResult(pluginResult);

            }
            if (resultCode == Activity.RESULT_CANCELED) {

                Log.i(TAG, "Activity Result FAILED");

                String msg = "NOK";

                PluginResult pluginResult = new PluginResult(PluginResult.Status.ERROR, msg);
                callbackContext.sendPluginResult(pluginResult);
            }
        }
    }

}