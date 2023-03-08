package com.example.brodcastrecieversdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AriplaneModeChangedReciever : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isEnabled = intent?.getBooleanExtra("state",false)?:return
        //if isEnabled null then onReceive simply returns and code below that doesn't run..

        if(isEnabled){
            Toast.makeText(context,"Airplane Mode Enabled!",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Airplane Mode Disabled!",Toast.LENGTH_LONG).show()
        }
    }

}