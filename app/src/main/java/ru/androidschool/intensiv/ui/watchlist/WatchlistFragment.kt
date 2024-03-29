package ru.androidschool.intensiv.ui.watchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import ru.androidschool.core_network.data.dto.Movie
import ru.androidschool.intensiv.databinding.FragmentWatchlistBinding
import ru.androidschool.intensiv.ui.feed.MovieItem

class WatchlistFragment : Fragment() {

    private var _binding: FragmentWatchlistBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWatchlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.moviesRecyclerView.layoutManager = GridLayoutManager(context, 4)
        binding.moviesRecyclerView.adapter = adapter.apply { addAll(listOf()) }

        val moviesList = mutableListOf<Movie>().map { it -> MovieItem(it) {} }

        binding.moviesRecyclerView.adapter = adapter.apply { addAll(moviesList) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = WatchlistFragment()
    }
}
