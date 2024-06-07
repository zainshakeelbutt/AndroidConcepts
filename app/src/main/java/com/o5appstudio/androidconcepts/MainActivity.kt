
package com.o5appstudio.androidconcepts
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging
import com.o5appstudio.androidconcepts.R
import com.o5appstudio.androidconcepts.ParsingJSONResponse.ParcingJsonResponseActivity
import com.o5appstudio.androidconcepts.SharedPreferences.SPSplashActivity
import com.o5appstudio.androidconcepts.alarmmanager.AlarmManagerActivity
import com.o5appstudio.androidconcepts.alertdialogs.AlertDialogsActivity
import com.o5appstudio.androidconcepts.androidarchitecture.lifecycleawarecomponents.LifeCycleAwareActivity
import com.o5appstudio.androidconcepts.androidarchitecture.listadapterdiffutils.ListAdapterActivity
import com.o5appstudio.androidconcepts.androidarchitecture.livedata.DataBindingActivity
import com.o5appstudio.androidconcepts.androidarchitecture.livedata.LiveDataMainActivity
import com.o5appstudio.androidconcepts.androidarchitecture.mvvm.MVVMMainActivity
import com.o5appstudio.androidconcepts.androidarchitecture.quotablemvvmretrofit.QuotableMVVMActivity
import com.o5appstudio.androidconcepts.androidarchitecture.quotableretrofit.QuotableActivity
import com.o5appstudio.androidconcepts.androidarchitecture.quotesapp.QuotesAppMainActivity
import com.o5appstudio.androidconcepts.androidarchitecture.roomdatabaseapp.RoomDatabaseAndroidArchitectureActivity
import com.o5appstudio.androidconcepts.androidarchitecture.viewmodel.ViewModelMainActivity
import com.o5appstudio.androidconcepts.animations.AnimationsActivity
import com.o5appstudio.androidconcepts.bmicalculator.BMICalculatorActivity
import com.o5appstudio.androidconcepts.bottomnavigation.BottomNavigationActivity
import com.o5appstudio.androidconcepts.broadcastreceiver.BroadcasrSMSReceiverActivity
import com.o5appstudio.androidconcepts.cardview.CardViewActivity
import com.o5appstudio.androidconcepts.coroutines.CoroutinesMainActivity
import com.o5appstudio.androidconcepts.customdrawablebuttons.CustomDrawableButtons
import com.o5appstudio.androidconcepts.customtoast.CustomToastActivity
import com.o5appstudio.androidconcepts.customtoolbar.CustomToolbarActivity
import com.o5appstudio.androidconcepts.fragments.staticfragments.FragmentsActivity
import com.o5appstudio.androidconcepts.imagefromcamera.ImageFromCameraActivity
import com.o5appstudio.androidconcepts.implicitintents.ImplicitIntentsActivity
import com.o5appstudio.androidconcepts.intents.FirstActivity
import com.o5appstudio.androidconcepts.listviews.ListViewActivity
import com.o5appstudio.androidconcepts.mvvmpractice.albumsapi.AlbumsApiMainActivity
import com.o5appstudio.androidconcepts.mvvmpractice.usersapi.UsersMVVMActivity
import com.o5appstudio.androidconcepts.navigationdrawer.NavigationDrawerActivity
import com.o5appstudio.androidconcepts.newsapp.NewsMainActivity
import com.o5appstudio.androidconcepts.notifications.NotificationsActivity
import com.o5appstudio.androidconcepts.quizapp.activities.LoginIntroActivity
import com.o5appstudio.androidconcepts.recyclerview.RecyclerViewActivity
import com.o5appstudio.androidconcepts.roomdatabase.RoomDatabaseMainActivity
import com.o5appstudio.androidconcepts.services.ServicesActivity
import com.o5appstudio.androidconcepts.sqldatabase.SQLMainActivity
import com.o5appstudio.androidconcepts.tabs.TabsActivity
import com.o5appstudio.androidconcepts.tiktoktoe.TicTacToeMain
import com.o5appstudio.androidconcepts.webview.WebViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val animationScreen : Button = findViewById(R.id.animClass)
        val intentScreen : Button = findViewById(R.id.intentClass)
        val listViewScreen : Button = findViewById(R.id.listViewsClass)
        val ticTakToeScreen : Button = findViewById(R.id.ticTacToeClass)
        val bmiCalculatorScreen : Button = findViewById(R.id.bmiClass)
        val cardViewScreen : Button = findViewById(R.id.cardViewClass)
        val recyclerViewScreen : Button = findViewById(R.id.recyclerViewClass)
        val customToolbarScreen : Button = findViewById(R.id.customToolbarClass)
        val customDrawableButtonsScreen : Button = findViewById(R.id.customDrawableButtonsClass)
        val customToastScreen : Button = findViewById(R.id.customToastClass)
        val alertDialogClass : Button = findViewById(R.id.alertDialogsClass)
        val notificationsClass : Button = findViewById(R.id.notificationsClass)
        val implicitIntentClass : Button = findViewById(R.id.implicitIntentClass)
        val fragmentsClass : Button = findViewById(R.id.fragmentsClass)
        val tabsClass : Button = findViewById(R.id.tabsClass)
        val bottomNavigationClass : Button = findViewById(R.id.bottomNavigationClass)
        val navigationDrawerClass : Button = findViewById(R.id.navigationDraweClass)
        val parcingJsonResponseClass : Button = findViewById(R.id.parcingJsonResponseClass)
        val webViewClass : Button = findViewById(R.id.webViewClass)
        val sharedPrefClass : Button = findViewById(R.id.sharedPrefClass)
        val sqlMainClass : Button = findViewById(R.id.sqlMainClass)
        val roomDBClass : Button = findViewById(R.id.roomDBClass)
        val imageFromCameraClass : Button = findViewById(R.id.imageFromCameraClass)
        val servicesClass : Button = findViewById(R.id.servicesClass)
        val alarmManagerClass : Button = findViewById(R.id.alarmManagerClass)
        val broadcastReceiverClass : Button = findViewById(R.id.broadcastReceiverClass)
        val newsAppClass : Button = findViewById(R.id.newsAppClass)
        val quizAppClass : Button = findViewById(R.id.quizAppClass)
        val androidArchitectureClass : Button = findViewById(R.id.androidArchitectureClass)
        val albumsApiClass : Button = findViewById(R.id.albumsApiClass)
        val usersApiClass : Button = findViewById(R.id.usersApiClass)
        val coroutinesClass : Button = findViewById(R.id.coroutinesClass)
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if(!it.isSuccessful){
                Log.e("TokenDetails","Token failed to receive")
                return@addOnCompleteListener
            } else{
                val task  = it.result
                Log.d("TOKEN",task.toString())
            }
        }


        animationScreen.setOnClickListener {
            val iNext = Intent(applicationContext, AnimationsActivity::class.java)
            startActivity(iNext)
        }
        intentScreen.setOnClickListener {
            val iNext = Intent(applicationContext, FirstActivity::class.java)
            startActivity(iNext)
        }
        listViewScreen.setOnClickListener {
            val iNext = Intent(applicationContext, ListViewActivity::class.java)
            startActivity(iNext)
        }
        ticTakToeScreen.setOnClickListener {
            val iNext = Intent(applicationContext, TicTacToeMain::class.java)
            startActivity(iNext)
        }
        bmiCalculatorScreen.setOnClickListener {
            val iNext = Intent(applicationContext, BMICalculatorActivity::class.java)
            startActivity(iNext)
        }
        cardViewScreen.setOnClickListener {
            val iNext = Intent(applicationContext, CardViewActivity::class.java)
            startActivity(iNext)
        }
        recyclerViewScreen.setOnClickListener {
            val iNext = Intent(applicationContext, RecyclerViewActivity::class.java)
            startActivity(iNext)
        }
        customToolbarScreen.setOnClickListener {
            val iNext = Intent(applicationContext, CustomToolbarActivity::class.java)
            startActivity(iNext)
        }
        customDrawableButtonsScreen.setOnClickListener {
            val iNext = Intent(applicationContext, CustomDrawableButtons::class.java)
            startActivity(iNext)
        }
        customToastScreen.setOnClickListener {
            val iNext = Intent(applicationContext, CustomToastActivity::class.java)
            startActivity(iNext)
        }
        alertDialogClass.setOnClickListener {
            val iNext = Intent(applicationContext, AlertDialogsActivity::class.java)
            startActivity(iNext)
        }
        notificationsClass.setOnClickListener {
            val iNext = Intent(applicationContext, NotificationsActivity::class.java)
            startActivity(iNext)
        }
        implicitIntentClass.setOnClickListener {
            val iNext = Intent(applicationContext, ImplicitIntentsActivity::class.java)
            startActivity(iNext)
        }
        fragmentsClass.setOnClickListener {
            val iNext = Intent(applicationContext, FragmentsActivity::class.java)
            startActivity(iNext)
        }
        tabsClass.setOnClickListener {
            val iNext = Intent(applicationContext, TabsActivity::class.java)
            startActivity(iNext)
        }
        bottomNavigationClass.setOnClickListener {
            val iNext = Intent(applicationContext, BottomNavigationActivity::class.java)
            startActivity(iNext)
        }
        navigationDrawerClass.setOnClickListener {
            val iNext = Intent(applicationContext, NavigationDrawerActivity::class.java)
            startActivity(iNext)
        }
        parcingJsonResponseClass.setOnClickListener {
            val iNext = Intent(applicationContext, ParcingJsonResponseActivity::class.java)
            startActivity(iNext)
        }
        webViewClass.setOnClickListener {
            val iNext = Intent(applicationContext, WebViewActivity::class.java)
            startActivity(iNext)
        }
        sharedPrefClass.setOnClickListener {
            val iNext = Intent(applicationContext, SPSplashActivity::class.java)
            startActivity(iNext)
        }
        sqlMainClass.setOnClickListener {
            val iNext = Intent(applicationContext, SQLMainActivity::class.java)
            startActivity(iNext)
        }
        roomDBClass.setOnClickListener {
            val iNext = Intent(applicationContext, RoomDatabaseMainActivity::class.java)
            startActivity(iNext)
        }
        imageFromCameraClass.setOnClickListener {
            val iNext = Intent(applicationContext, ImageFromCameraActivity::class.java)
            startActivity(iNext)
        }
        servicesClass.setOnClickListener {
            val iNext = Intent(applicationContext, ServicesActivity::class.java)
            startActivity(iNext)
        }
        alarmManagerClass.setOnClickListener {
            val iNext = Intent(applicationContext, AlarmManagerActivity::class.java)
            startActivity(iNext)
        }
        broadcastReceiverClass.setOnClickListener {
            val iNext = Intent(applicationContext, BroadcasrSMSReceiverActivity::class.java)
            startActivity(iNext)
        }
        newsAppClass.setOnClickListener {
            val iNext = Intent(applicationContext, NewsMainActivity::class.java)
            startActivity(iNext)
        }
        quizAppClass.setOnClickListener {
            val iNext = Intent(applicationContext, LoginIntroActivity::class.java)
            startActivity(iNext)
        }
        androidArchitectureClass.setOnClickListener {
            val iNext = Intent(applicationContext, QuotableMVVMActivity::class.java)
            startActivity(iNext)
        }
        albumsApiClass.setOnClickListener {
            val iNext = Intent(applicationContext, AlbumsApiMainActivity::class.java)
            startActivity(iNext)
        }
        usersApiClass.setOnClickListener {
            val iNext = Intent(applicationContext, UsersMVVMActivity::class.java)
            startActivity(iNext)
        }
        coroutinesClass.setOnClickListener {
            val iNext = Intent(applicationContext, CoroutinesMainActivity::class.java)
            startActivity(iNext)
        }

    }

}
