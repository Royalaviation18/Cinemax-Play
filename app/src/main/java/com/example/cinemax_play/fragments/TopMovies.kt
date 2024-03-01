package com.example.cinemax_play.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemax.ApiInterface
import com.example.cinemax.MyData
import com.example.cinemax.PopularMovieAdapter
import com.example.cinemax_play.MoviesMoreDetails
import com.example.cinemax_play.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TopMovies : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: PopularMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = activity?.findViewById(R.id.recyclerMain1)!!
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val response = retrofitBuilder.getTopRatedMovies("1bb73a66ee51d81eb2d007133cb02c83",1)
        response.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val responseBody = response.body()
                val topRatedMoviesList = responseBody?.results!!
                myAdapter = PopularMovieAdapter(activity!!, topRatedMoviesList)
                recyclerView.adapter = myAdapter
                recyclerView.layoutManager = LinearLayoutManager(activity)
                myAdapter.setItemClickListener(object : PopularMovieAdapter.onItemClickListener{
                    override fun onItemClick(position: Int) {
                        val intent = Intent(activity, MoviesMoreDetails::class.java)
                        intent.putExtra("title",topRatedMoviesList[position].title)
                        intent.putExtra("language",topRatedMoviesList[position].original_language)
                        intent.putExtra("date",topRatedMoviesList[position].release_date)
                        intent.putExtra("image",topRatedMoviesList[position].poster_path)
                        intent.putExtra("desc",topRatedMoviesList[position].overview)
                        startActivity(intent)
                    }

                })
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}