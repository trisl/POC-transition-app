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

class SecondFragment : MotherOfFragment(Gravity.END) {

    private lateinit var button: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_second, container, false).apply {
                button = this.show_other_fragment
            }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configAction()
    }

    private fun configAction() {
        button.setOnClickListener { activity?.onBackPressed() }
    }
}