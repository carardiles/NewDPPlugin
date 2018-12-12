package cl.entel.plugins.huellero;

import android.util.Log;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Bitmap;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;

import com.digitalpersona.uareu.ReaderCollection;
import com.digitalpersona.uareu.UareUException;

import android.content.Context;
import android.content.Intent;


public class NewDPActivity extends Activity {

    private static final String TAG = "NewDPActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Intent intent = getIntent();
        String action = intent.getStringExtra("action");

        if(action != null && action.equalsIgnoreCase("conectar")){
            contectar();
        }
        else if(action != null && action.equalsIgnoreCase("capturar")){
            capturar();
        }
        else{
            //retornar error de Action no Encontrada
            Log.i(TAG,"No Action Found");
        }
    }

    private void conectar(){
        //manejo del metodo conectar
        Log.i(TAG,"Conectar Start");
    }

    private void capturar() {
        //manejo del metodo capturar
        Log.i(TAG,"Capturar Start");

        /*Intent returnIntent = new Intent();
        returnIntent.putExtra("result",imgFP);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();      */       
    }
}
























