package com.aidios.energizer

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.AbsListView
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.aidios.energizer.DeviceListUI.DeviceListAdapter
import com.aidios.energizer.DeviceListUI.DeviceListData
import com.nabilmh.lottieswiperefreshlayout.LottieSwipeRefreshLayout

class home : AppCompatActivity() {

    private lateinit var AllButton : TextView
    private lateinit var InefficientButton : TextView
    private lateinit var ElementsView : GridView
    private lateinit var swipe_up : LottieSwipeRefreshLayout

    private lateinit var Adapter : DeviceListAdapter

    private var isAll = true

    override fun onCreate(savedInstanceState: Bundle?) {

        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        UI_Enhancer.hideSystemUI(this)

        AllButton = findViewById(R.id.all_btn)
        InefficientButton = findViewById(R.id.ineff_btn)
        ElementsView = findViewById(R.id.device_view)
        swipe_up = findViewById(R.id.swipe_refresh_layout)

        Adapter = DeviceListAdapter(this,R.layout.device_list_item)
        ElementsView.transcriptMode = AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL
        ElementsView.adapter = Adapter

        Adapter.add(DeviceListData(100,"Kharar"))
        Adapter.add(DeviceListData(100,"Kharar"))
        Adapter.add(DeviceListData(50,"Kharar"))
        Adapter.add(DeviceListData(100,"Kharar"))
        Adapter.add(DeviceListData(100,"Kharar"))
        Adapter.add(DeviceListData(100,"Kharar"))

        ElementsView.setOnItemClickListener { adapterView, view, i, l ->

            startActivity(Intent(this,DeviceInfo::class.java))
            finish()

        }

        swipe_up.setOnRefreshListener {
            Handler(Looper.getMainLooper()).postDelayed({
                swipe_up.isRefreshing = false
            }, 1000)

            Toast.makeText(applicationContext,"Data Updation Completed!",Toast.LENGTH_SHORT).show()

        }

        findViewById<ImageView>(R.id.logout).setOnClickListener {
            val mainIntent = Intent(this, Login::class.java)
            startActivity(mainIntent)
            finish()
        }

        AllButton.setOnClickListener {

            if (isAll == false){
                AllButton.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.electric_blue,theme))
                AllButton.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.white,theme)))

                InefficientButton.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.back_grey,theme))
                InefficientButton.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.black,theme)))

                isAll = true

                Adapter = DeviceListAdapter(this,R.layout.device_list_item)
                ElementsView.transcriptMode = AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL
                ElementsView.adapter = Adapter

                Adapter.add(DeviceListData(100,"Kharar"))
                Adapter.add(DeviceListData(100,"Kharar"))
                Adapter.add(DeviceListData(50,"Kharar"))
                Adapter.add(DeviceListData(100,"Kharar"))
                Adapter.add(DeviceListData(100,"Kharar"))
                Adapter.add(DeviceListData(100,"Kharar"))
            }
        }

        InefficientButton.setOnClickListener {
            if (isAll == true){
                AllButton.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.back_grey,theme))
                AllButton.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.black,theme)))

                InefficientButton.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.aidios_red,theme))
                InefficientButton.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.white,theme)))

                isAll = false

                Adapter = DeviceListAdapter(this,R.layout.device_list_item)
                ElementsView.transcriptMode = AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL
                ElementsView.adapter = Adapter

                Adapter.add(DeviceListData(50,"Kharar"))
            }
        }



    }

}