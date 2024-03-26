package com.ivan.fooddelivery.presentation.food_menu.banner_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivan.fooddelivery.databinding.ItemBannerBinding
import com.ivan.fooddelivery.presentation.models.Banner

class BannerAdapter(
    private val banners: List<Banner>,
    private val onBannerClicked: (Banner) -> Unit
) : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding, onBannerClicked)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val banner = banners[position]
        holder.bind(banner)
    }

    override fun getItemCount(): Int = banners.size

    class BannerViewHolder(
        private val binding: ItemBannerBinding,
        private val onBannerClicked: (Banner) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(banner: Banner) {
            binding.imageBanner.setImageResource(banner.resource)

            binding.cardBanner.setOnClickListener {
                onBannerClicked(banner)
            }
        }
    }
}