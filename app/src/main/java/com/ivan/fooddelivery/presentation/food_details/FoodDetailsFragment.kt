package com.ivan.fooddelivery.presentation.food_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ivan.fooddelivery.R

private const val ID_PARAM = "food_id"

class FoodDetailsFragment : Fragment() {
    private var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ID_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_details, container, false)
    }

    companion object {
        fun newInstance(id: Int) =
            FoodDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ID_PARAM, id)
                }
            }
    }
}