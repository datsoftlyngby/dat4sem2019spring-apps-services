package dk.cphbusiness.services

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.util.Log
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import java.time.Duration

class MainActivity : AppCompatActivity() {
    val workManager = WorkManager.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(SmsFilterReceiver(), IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION))
        work_button.onClick {
            toast("Work button clicked")
            // val request = OneTimeWorkRequest.from(WaitWorker::class.java)
            val request = PeriodicWorkRequestBuilder<WaitWorker>(Duration.ofSeconds(30L)).build()
            workManager.enqueue(request)
            }
        service_button.onClick {
            startService(intentFor<WaitingService>())
            }

    }
}

class WaitWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        Log.d("WORK", "Started ...")
        Thread.sleep(2000)
        Log.d("WORK", "... 2s ...")
        Thread.sleep(2000)
        Log.d("WORK", "... 4s ...")
        Thread.sleep(2000)
        Log.d("WORK", "... Done!")
        return Result.success()
        }
    }