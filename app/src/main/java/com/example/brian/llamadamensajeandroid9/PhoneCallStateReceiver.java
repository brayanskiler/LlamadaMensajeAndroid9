package com.example.brian.llamadamensajeandroid9;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class PhoneCallStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {

        TelephonyManager tm = (TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);


        switch (tm.getCallState()) {

            case TelephonyManager.CALL_STATE_RINGING:

                String numero =MainActivity.intent.getExtras().getString("NumeroTelefonico");
                String mensaje = MainActivity.intent.getExtras().getString("MensajeTexto");
                SmsManager sms = SmsManager.getDefault();

                //Toast.makeText(context, "numero del intent "+numero, Toast.LENGTH_LONG).show();



                if (numero.equals(intent.getStringExtra("incoming_number"))) {
                    sms.sendTextMessage(numero, null,mensaje, null, null);
                    Toast.makeText(context, "Mensaje enviado a: " + numero, Toast.LENGTH_SHORT).show();
                }break;
        }
    }


}
