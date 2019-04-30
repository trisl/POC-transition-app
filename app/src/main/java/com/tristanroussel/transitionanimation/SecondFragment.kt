package com.tristanroussel.transitionanimation

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment() {

    private lateinit var button: TextView
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAnimation()
        sharedElementEnterTransition = ChangeBounds()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_second, container, false).apply {
                button = this.show_other_fragment
                this@SecondFragment.image = this.image
            }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configAction()
    }

    private fun configAction() {
        button.setOnClickListener {
            /*fragmentManager?.beginTransaction()
                    ?.replace(R.id.main_view, FirstFragment())
                    ?.addSharedElement(image, image.transitionName)
                    ?.addSharedElement(button, button.transitionName)
                    ?.commit()*/
            activity?.onBackPressed()
        }
    }

    private fun setAnimation() {
        val slide = Slide(Gravity.END).apply {
            duration = 300
            interpolator = AccelerateDecelerateInterpolator()
        }

        enterTransition = slide
        reenterTransition = slide
        returnTransition = slide
        exitTransition = slide
    }
}