package com.aidios.energizer

import android.animation.ValueAnimator
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aidios.energizer.DeviceEfficiencyUI.GraphAdapter
import com.aidios.energizer.DeviceEfficiencyUI.GraphData


class DeviceInfo : AppCompatActivity() {

    private lateinit var weekbtn : TextView
    private lateinit var monthbtn : TextView
    private lateinit var yearbtn : TextView

    private lateinit var graph : RecyclerView
    private lateinit var graphAdapter: GraphAdapter
    private var datalist : MutableList<GraphData> = ArrayList<GraphData>()

    override fun onCreate(savedInstanceState: Bundle?) {

        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_info)

        UI_Enhancer.hideSystemUI(this)

        weekbtn = findViewById(R.id.week)
        monthbtn = findViewById(R.id.month)
        yearbtn = findViewById(R.id.year)
        graph = findViewById(R.id.graph)

        datalist.add(GraphData(100,"1"))
        datalist.add(GraphData(100,"2"))
        datalist.add(GraphData(100,"3"))
        datalist.add(GraphData(70,"4"))
        datalist.add(GraphData(99,"5"))
        datalist.add(GraphData(90,"6"))

        val gLayerManager = LinearLayoutManager(applicationContext)
        gLayerManager.setOrientation(LinearLayoutManager.HORIZONTAL)

        graphAdapter = GraphAdapter(datalist)
        graph.adapter = graphAdapter

        graph.layoutManager = gLayerManager
        graph.itemAnimator = DefaultItemAnimator()
        graph.adapter = graphAdapter

        UI_Enhancer.count_anim(findViewById(R.id.energen),100000)

        weekbtn.setOnClickListener {
            weekbtn.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.electric_blue,theme))
            weekbtn.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.white,theme)))

            monthbtn.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.back_grey,theme))
            monthbtn.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.black,theme)))

            yearbtn.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.back_grey,theme))
            yearbtn.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.black,theme)))

            UI_Enhancer.count_anim(findViewById(R.id.energen),1000)

            datalist.add(GraphData(100,"1"))
            datalist.add(GraphData(100,"2"))
            datalist.add(GraphData(100,"3"))
            datalist.add(GraphData(70,"4"))
            datalist.add(GraphData(99,"5"))
            datalist.add(GraphData(90,"6"))

            graphAdapter = GraphAdapter(datalist)
            graph.adapter = graphAdapter

        }

        monthbtn.setOnClickListener {
            monthbtn.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.electric_blue,theme))
            monthbtn.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.white,theme)))

            weekbtn.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.back_grey,theme))
            weekbtn.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.black,theme)))

            yearbtn.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.back_grey,theme))
            yearbtn.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.black,theme)))

            UI_Enhancer.count_anim(findViewById(R.id.energen),100000)

            datalist.add(GraphData(100,"1"))
            datalist.add(GraphData(100,"2"))
            datalist.add(GraphData(100,"3"))
            datalist.add(GraphData(70,"4"))
            datalist.add(GraphData(99,"5"))
            datalist.add(GraphData(90,"6"))

            graphAdapter = GraphAdapter(datalist)
            graph.adapter = graphAdapter

        }

        yearbtn.setOnClickListener {
            yearbtn.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.electric_blue,theme))
            yearbtn.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.white,theme)))

            monthbtn.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.back_grey,theme))
            monthbtn.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.black,theme)))

            weekbtn.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.back_grey,theme))
            weekbtn.setTextColor(ColorStateList.valueOf(resources.getColor(R.color.black,theme)))

            UI_Enhancer.count_anim(findViewById(R.id.energen),5000000)

            datalist.add(GraphData(90,"1"))
            datalist.add(GraphData(100,"2"))
            datalist.add(GraphData(100,"3"))
            datalist.add(GraphData(70,"4"))
            datalist.add(GraphData(99,"5"))
            datalist.add(GraphData(90,"6"))

            graphAdapter = GraphAdapter(datalist)
            graph.adapter = graphAdapter

        }

        findViewById<LinearLayout>(R.id.service).setOnClickListener {
            Toast.makeText(this,"Service Request Recorded!",Toast.LENGTH_SHORT).show()
        }

        findViewById<LinearLayout>(R.id.locate).setOnClickListener {
            Toast.makeText(this,"Locating Device...",Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.back).setOnClickListener {

            val intent = Intent(this, home::class.java)
            startActivity(intent)
            finish()

        }

    }
}