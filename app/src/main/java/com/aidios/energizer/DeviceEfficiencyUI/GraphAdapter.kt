package com.aidios.energizer.DeviceEfficiencyUI

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aidios.energizer.R
import kotlin.math.roundToInt


class GraphAdapter(graphlist: List<GraphData>) : RecyclerView.Adapter<GraphAdapter.MyViewHolder>() {

    private val graphlist: List<GraphData>

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var GraphBar: TextView
        var GraphLabel: TextView

        init {
            GraphBar = view.findViewById<TextView>(R.id.graph_bar)
            GraphLabel = view.findViewById<TextView>(R.id.label)
        }
    }

    init {
        this.graphlist = graphlist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.graph, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val graph: GraphData = graphlist[position]
        if (graph.percentage < 75) {
            holder.GraphBar.setBackgroundResource(R.drawable.graph_bar_black)
        }
        holder.GraphBar.layoutParams.height = 0
        holder.GraphBar.layoutParams.height = ((graph.percentage * 4.7).roundToInt())
        slideUp(holder.GraphBar)
        holder.GraphLabel.setText(graph.label)
    }

    override fun getItemCount(): Int {
        return graphlist.size
    }

    companion object {
        fun slideUp(view: View) {
            view.visibility = View.VISIBLE
            view.alpha = 0f
            if (view.height > 0) {
                slideUpNow(view)
            } else {
                // wait till height is measured
                view.post { slideUpNow(view) }
            }
        }

        fun slideDown(view: View) {
            view.animate()
                .translationY(view.height.toFloat())
                .alpha(0f)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        // superfluous restoration
                        view.visibility = View.GONE
                        view.alpha = 1f
                        view.translationY = 0f
                    }
                })
        }

        private fun slideUpNow(view: View) {
            view.translationY = view.height.toFloat()
            view.animate()
                .translationY(0f)
                .alpha(1f)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        view.visibility = View.VISIBLE
                        view.alpha = 1f
                    }
                })
        }
    }
}
