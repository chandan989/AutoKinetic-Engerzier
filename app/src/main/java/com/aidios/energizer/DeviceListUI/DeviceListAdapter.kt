package com.aidios.energizer.DeviceListUI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.aidios.energizer.R

class DeviceListAdapter(private val context: Context, textViewResourceId: Int) : ArrayAdapter<DeviceListData?>(context, textViewResourceId){

    private lateinit var icon : ImageView
    private lateinit var health_stat : TextView
    private lateinit var location: TextView

    var DeviceDataList: MutableList<DeviceListData> = ArrayList<DeviceListData>()

    override fun add(data: DeviceListData?) {
        DeviceDataList.add(data!!)
        super.add(data)
    }

    override fun getCount(): Int {
        return DeviceDataList.size
    }

    override fun getItem(position: Int): DeviceListData {
        return DeviceDataList[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val Device : DeviceListData = getItem(position)

        var view = convertView
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = inflater.inflate(R.layout.device_list_item, parent, false)

        icon = view.findViewById(R.id.icon)
        health_stat = view.findViewById(R.id.health)
        location = view.findViewById(R.id.location)

        health_stat.text = "Health:"+Device.health
        location.text = "Location:"+Device.location

        if (Device.health<70){
            icon.setImageDrawable(context.resources.getDrawable(R.drawable.chat_bubble_warning, context.theme))
        }else{
            icon.setImageDrawable(context.resources.getDrawable(R.drawable.chat_bubble_check, context.theme))
        }

        return view
    }

}