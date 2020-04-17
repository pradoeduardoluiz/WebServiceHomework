package com.pos.pucpr.webservicehomework.ui.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.pos.pucpr.webservicehomework.models.json.Character
import com.pos.pucpr.webservicehomework.ui.holders.characterViewHolder

class CharacterListController : TypedEpoxyController<List<Character>>() {

    override fun buildModels(data: List<Character>?) {
        data?.forEach {
            characterViewHolder {
                id(it.id)
                name(it.name)
                imageUrl(it.image)
            }
        }
    }
}