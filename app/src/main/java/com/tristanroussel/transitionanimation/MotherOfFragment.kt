package com.tristanroussel.transitionanimation

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Slide
import android.transition.TransitionSet
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment

open class MotherOfFragment(private val gravity: Int) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAnimation()
    }

    override fun onResume() {
        super.onResume()
        setAnimation()
    }

    protected fun setAnimation() {
        val slide = Slide(gravity).apply {
            duration = 300
            interpolator = AccelerateDecelerateInterpolator()
        }

        enterTransition = slide
        reenterTransition = slide
        returnTransition = slide
        exitTransition = slide
        sharedElementEnterTransition = TransitionSet().apply {
            addTransition(ChangeBounds())
            duration = 3000
            interpolator = AccelerateDecelerateInterpolator()
        }
        sharedElementReturnTransition = TransitionSet().apply {
            addTransition(ChangeBounds())
            duration = 3000
            interpolator = AccelerateDecelerateInterpolator()
        }
    }
}