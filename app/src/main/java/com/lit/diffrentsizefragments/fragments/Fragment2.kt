package com.lit.diffrentsizefragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lit.diffrentsizefragments.databinding.Layout2Binding

class Fragment2 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
    }

    private var dBinding: Layout2Binding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = dBinding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        dBinding = Layout2Binding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        dBinding = null
    }

}