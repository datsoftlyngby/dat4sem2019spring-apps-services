package dk.cphbusiness.services

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import org.jetbrains.anko.toast

class WaitingService : IntentService("WaitingService") {
    override fun onHandleIntent(intent: Intent?) {
        Log.d("SERV", "Service handling")
        Thread.sleep(3000)
        }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        this.toast("Service started")
        return super.onStartCommand(intent, flags, startId)
    }
}
