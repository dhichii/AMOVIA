package com.adhi.amovia.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhi.amovia.data.source.remote.response.FilmResponse
import com.adhi.amovia.databinding.ItemsListHomeBinding
import com.adhi.amovia.utils.Utility.loadImage

class UpcomingMovieAdapter : RecyclerView.Adapter<UpcomingMovieAdapter.MovieViewHolder>() {
    private val listMovie = ArrayList<FilmResponse>()

    fun setMovie(movie: List<FilmResponse>) {
        listMovie.clear()
        listMovie.addAll(movie)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val binding: ItemsListHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: FilmResponse) {
            binding.apply {
                movie.apply {
                    tvTitle.text = title
                    tvRating.text = rating.toString()
                    imgPoster.loadImage(posterPath)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            ItemsListHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size
}