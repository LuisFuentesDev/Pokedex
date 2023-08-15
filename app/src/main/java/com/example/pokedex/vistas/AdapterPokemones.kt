package com.example.pokedex.vistas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.data.local.PokeEntity
import com.example.pokedex.databinding.ItemPokemonBinding

class AdapterPokemones : RecyclerView.Adapter<AdapterPokemones.ItemPokemonViewHolder>() {

    lateinit var binding: ItemPokemonBinding
    private val listItemPokemones = mutableListOf<PokeEntity>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterPokemones.ItemPokemonViewHolder {

        binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemPokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterPokemones.ItemPokemonViewHolder, position: Int) {

        val pokemon = listItemPokemones[position]
        holder.bind(pokemon)
    }

    fun setData(pokemones: List<PokeEntity>) {
        this.listItemPokemones.clear()
        this.listItemPokemones.addAll(pokemones)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return listItemPokemones.size
    }

    class ItemPokemonViewHolder(val pokemonesVista: ItemPokemonBinding) :
        RecyclerView.ViewHolder(pokemonesVista.root) {
        fun bind(pokemon: PokeEntity) {
            pokemonesVista.textViewName.text = pokemon.name
            pokemonesVista.cardViewPokemon.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("name", pokemon.name)
                Navigation.findNavController(pokemonesVista.root)
                    .navigate(R.id.action_fragmentoListaPokemon_to_fragmentoPokeDetalle, bundle)
            }
        }

    }
}