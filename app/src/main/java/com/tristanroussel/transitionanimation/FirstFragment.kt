package com.tristanroussel.transitionanimation

import android.content.res.ColorStateList
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
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment() {

    private lateinit var button: TextView
    private lateinit var imageFragment: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAnimation()
        sharedElementEnterTransition = ChangeBounds()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_first, container, false).apply {
                button = this.show_other_fragment
                imageFragment = this.image
            }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let {
            imageFragment.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(it, R.color.colorAccent))
        }

        configAction()
    }

    private fun configAction() {
        button.setOnClickListener {
            setAnimation()
            fragmentManager?.beginTransaction()
                    ?.replace(R.id.main_view, SecondFragment())
                    ?.addToBackStack("SecondFragment")
                    ?.addSharedElement(imageFragment, imageFragment.transitionName)
                    ?.addSharedElement(button, button.transitionName)
                    ?.commit()
        }
    }

    private fun setAnimation() {
        val slide = Slide(Gravity.START).apply {
            duration = 300
            interpolator = AccelerateDecelerateInterpolator()
        }

        enterTransition = slide
        reenterTransition = slide
        returnTransition = slide
        exitTransition = slide
    }
}