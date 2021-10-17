package com.asimodabas.backstack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragmentbirinci.view.*

class FragmentBirinci : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragmentbirinci,container,false)
        rootView.buttonTikla.setOnClickListener {
            Toast.makeText(activity, "Tılandı", Toast.LENGTH_SHORT).show()

        }
        return rootView
    }

}