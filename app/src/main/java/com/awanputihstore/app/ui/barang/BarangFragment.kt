package com.awanputihstore.app.ui.barang

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import com.awanputihstore.app.R
import com.awanputihstore.app.databinding.FragmentBarangBinding
import com.awanputihstore.app.ui.home.MainActivity

class BarangFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }

    private lateinit var binding: FragmentBarangBinding
    private val viewModel: BarangViewModel by lazy { BarangViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBarangBinding.inflate(inflater, container, false).apply {
            viewModel = this@BarangFragment.viewModel
            lifecycleOwner = this@BarangFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }


    private fun init() {
        binding.recyclerView.adapter = BarangAdapter(parent)
        viewModel.listBarang()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listBarang()
        }
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it

        }

        viewModel.actionState.observe(viewLifecycleOwner) {
            if (it.isConsumed) {
                Log.i("ActionState", "isConsumed")
            } else if (!it.isSuccess) {
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}