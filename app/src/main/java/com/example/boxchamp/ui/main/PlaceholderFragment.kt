package com.example.boxchamp.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.boxchamp.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    lateinit var horizontalRV: RecyclerView
    lateinit var verticalRV: RecyclerView

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
        pageViewModel.text.observe(viewLifecycleOwner, Observer<Int> {
            onSelectedTab(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    @SuppressLint("WrongConstant")
    private fun initRecyclerView() {
        horizontalRV = recycler_view_horizontal
        verticalRV = recycler_view_vertical
        horizontalRV.isNestedScrollingEnabled = false
        horizontalRV.setHasFixedSize(false)
        verticalRV.isNestedScrollingEnabled = false
        verticalRV.setHasFixedSize(false)
        horizontalRV.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayout.HORIZONTAL, false)
            adapter = HorizontalGameListAdapter()
        }
        verticalRV.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
            adapter = VerticalGameListAdapter()
        }
    }

    private fun onSelectedTab(pos: Int) {
        when (pos) {
            1 -> {
                horizontalRV.visibility = View.VISIBLE
            }
            2 -> {
                horizontalRV.visibility = View.GONE
            }
            3 -> {
                horizontalRV.visibility = View.GONE
            }
            4 -> {
                horizontalRV.visibility = View.GONE
            }
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}