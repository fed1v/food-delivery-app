package com.ivan.fooddelivery.presentation.food_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ivan.fooddelivery.R
import com.ivan.fooddelivery.databinding.FragmentFoodMenuBinding
import com.ivan.fooddelivery.presentation.food_menu.banner_adapter.BannerAdapter
import com.ivan.fooddelivery.presentation.models.Banner
import com.ivan.fooddelivery.presentation.util.OnItemClickListener


class FoodMenuFragment : Fragment(), OnItemClickListener<Banner> {

    private lateinit var binding: FragmentFoodMenuBinding
    private lateinit var bannerAdapter: BannerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val banners = listOf(
            Banner(1, R.drawable.image_banner_1),
            Banner(2, R.drawable.image_banner_2),
            Banner(3, R.drawable.image_banner_1),
        )

        initBannerRecyclerView(banners)
    }

    override fun onItemClicked(item: Banner) {
        Toast.makeText(requireContext(), "banner ${item.id} clicked", Toast.LENGTH_SHORT).show()
    }

    private fun initBannerRecyclerView(banners: List<Banner>) {
        println("initBannerRecyclerView")
        bannerAdapter = BannerAdapter(banners, this)
        binding.recyclerViewBanners.adapter = bannerAdapter
    }

    companion object {
        fun newInstance() = FoodMenuFragment()
    }
}