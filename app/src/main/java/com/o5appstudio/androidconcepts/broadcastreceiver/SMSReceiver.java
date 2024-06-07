package com.o5appstudio.androidconcepts.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Bundle bundle = intent.getExtras();
        Object[] smsObjects = (Object[]) bundle.get("pdus");

        for(Object object : smsObjects){
            SmsMessage smsMsg = SmsMessage.createFromPdu( (byte[]) object,"3gpp");

            String mobileNo = smsMsg.getDisplayOriginatingAddress();
            String msg = smsMsg.getDisplayMessageBody();

            Log.d("Message Details","Mobile No is : "+mobileNo+" Message is : "+msg);

        }

    }
}
