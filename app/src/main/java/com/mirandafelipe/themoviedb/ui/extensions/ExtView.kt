package com.mirandafelipe.themoviedb.ui.extensions

import android.os.SystemClock
import android.view.View
import android.view.animation.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

val View.visible: View
    get() {
        visibility = View.VISIBLE
        return this
    }

val View.invisible: View
    get() {
        visibility = View.INVISIBLE
        return this
    }

val View.gone: View
    get() {
        visibility = View.GONE
        return this
    }


fun View.onSingleClick(
    context: CoroutineContext = Dispatchers.Main,
    handler: suspend CoroutineScope.(v: View?) -> Unit
) {
    var lastClickTime = 0L

    setOnClickListener { v ->
        if (SystemClock.elapsedRealtime() - lastClickTime >= 1500) {
            lastClickTime = SystemClock.elapsedRealtime()

            GlobalScope.launch(context, CoroutineStart.DEFAULT) {
                handler(v)
            }
        }
    }
}

fun RecyclerView.animationEntrance() {
    val set = AnimationSet(true)
    var animation: Animation = AlphaAnimation(0.0f, 1.0f)
    val controller = LayoutAnimationController(set, 0.1f)

    animation.duration = 1000
    set.addAnimation(animation)

    animation = TranslateAnimation(
        Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0.0f,
        Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f
    )
    animation.setDuration(500)
    set.addAnimation(animation)

    controller.interpolator = AccelerateInterpolator()

    this.layoutAnimation = controller
}