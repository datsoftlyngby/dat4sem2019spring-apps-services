package dk.cphbusiness.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class SmsFilterReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("SMS", "SMS received")
        context.longToast("SMS received")
        }
    }