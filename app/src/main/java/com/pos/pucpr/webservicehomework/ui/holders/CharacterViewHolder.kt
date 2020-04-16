package com.pos.pucpr.webservicehomework.ui.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import coil.api.load
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.pos.pucpr.webservicehomework.R
import kotlinx.android.synthetic.main.list_item_character.view.*

@EpoxyModelClass
abstract class CharacterViewHolder : EpoxyModelWithHolder<CharacterHolder>() {
    override fun getDefaultLayout() = R.layout.list_item_character

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    lateinit var imageUrl: String

    override fun bind(holder: CharacterHolder) {
        holder.apply {
            tvName.text = name
            imgCharacter.load(imageUrl)
        }
    }
}

class CharacterHolder : EpoxyHolder() {
    lateinit var tvName: TextView
    lateinit var imgCharacter: ImageView

    override fun bindView(itemView: View) {
        tvName = itemView.txt_name
        imgCharacter = itemView.img_character
    }
}