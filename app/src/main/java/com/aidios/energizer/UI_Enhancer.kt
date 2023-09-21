package com.aidios.energizer

import android.animation.ValueAnimator
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.icu.text.DecimalFormat
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.graphics.ColorUtils
import com.aidios.energizer.R

class UI_Enhancer {

    companion object{


        fun hasPermissions(context: Context?, vararg permissions: String?): Boolean {
            if (context != null && permissions != null) {
                for (permission in permissions) {
                    if (ActivityCompat.checkSelfPermission(
                            context,
                            permission!!
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        return false
                    }
                }
            }
            return true
        }

        fun hideSystemUI(activity: Activity) {
            activity.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                    or View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                    or View.SYSTEM_UI_FLAG_IMMERSIVE)
        }

        fun setImageDrawableWithAnimation(imageView: ImageView, drawable: Drawable?, duration: Int) {
            val currentDrawable = imageView.drawable
            if (currentDrawable == null) {
                imageView.setImageDrawable(drawable)
                return
            }
            val transitionDrawable = TransitionDrawable(
                arrayOf(
                    currentDrawable,
                    drawable
                )
            )
            imageView.setImageDrawable(transitionDrawable)
            transitionDrawable.startTransition(duration)
        }

        fun isDark(color: Int): Boolean {
            return ColorUtils.calculateLuminance(color) < 0.5
        }

        fun prettyCount(number: Number): String {
            val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
            val numValue = number.toLong()
            val value = Math.floor(Math.log10(numValue.toDouble())).toInt()
            val base = value / 3
            return if (value >= 3 && base < suffix.size) {
                DecimalFormat("#0.0").format(
                    numValue / Math.pow(
                        10.0,
                        (base * 3).toDouble()
                    )
                ) + suffix[base]
            } else {
                DecimalFormat("#,##0").format(numValue)
            }
        }

        fun count_anim(view: TextView, num : Int){

            val animator = ValueAnimator()
            animator.setObjectValues(0, num)
            animator.addUpdateListener {
                    animation -> view.setText(
                UI_Enhancer.prettyCount(animation.animatedValue as Number)
            )
            }
            animator.duration = 1000 // here you set the duration of the anim

            animator.start()

        }

    }


}