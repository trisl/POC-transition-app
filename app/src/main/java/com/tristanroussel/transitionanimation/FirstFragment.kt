package com.tristanroussel.transitionanimation

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : MotherOfFragment(Gravity.START) {

    private lateinit var button: TextView
    private lateinit var imageFragment: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_first, container, false).apply {
                button = this.show_other_fragment
                imageFragment = this.image
            }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
}
