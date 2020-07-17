package com.example.task.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task.Repository
import com.example.task.adapters.MyAdapter
import com.example.task.data.Experience
import com.example.task.databinding.FragmentMainBinding
import com.example.task.room.DbHelper
import com.example.task.viewModels.MainViewModel


class FragmentMain : Fragment() {

    private val TAG = "FragmentMain"

    private lateinit var binding: FragmentMainBinding
    private lateinit var listener: MyAdapter.OnItemClickListener
    private val model: MainViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun displayData(experience: List<Experience>) {

        val adapter = binding.recyclerView.adapter as MyAdapter
        adapter.list = experience
        adapter.notifyDataSetChanged()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.repository = Repository(DbHelper.getDbInstance(requireContext())!!)

        listener = object : MyAdapter.OnItemClickListener {
            override fun onItemClicked(exp: Experience) {


                val experienceStringId: String = exp.id

                val action = FragmentMainDirections.actionFragmentMainToFragmentDetail(experienceStringId)

                view.findNavController().navigate(action)

            }

        }

        binding.recyclerView.apply {
            adapter = MyAdapter(requireContext(), emptyList(), listener)
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }


        model.experiences.observe(requireActivity(), Observer {

            binding.progressbar.visibility = View.GONE
            binding.layout.visibility = View.VISIBLE
            displayData(it)

        })

        // Error handling
        model.error.observe(requireActivity(), Observer {
            binding.progressbar.visibility = View.GONE

            it.printStackTrace()
            Toast.makeText(activity, it.localizedMessage, Toast.LENGTH_SHORT).show()
//            if(it.localizedMessage == "Unable to resolve host \"a1ea1343-8fcb-408e-ba56-395933b2e4c8.mock.pstmn.io\": No address associated with hostname") {
//                Toast.makeText(activity, "No connection", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                Toast.makeText(activity, it.localizedMessage, Toast.LENGTH_SHORT).show()
//            }
        })


        model.loadFromDB()

        model.updateFromAPI()



    }



}