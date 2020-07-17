package com.example.task.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.task.R
import com.example.task.Repository
import com.example.task.databinding.FragmentDetailBinding
import com.example.task.room.DbHelper
import com.example.task.viewModels.DetailViewModel
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*


class FragmentDetail : Fragment() {

    private val TAG = "FragmentDetail"

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    private val args: FragmentDetailArgs by navArgs()


    override fun onResume() {
        super.onResume()

        val title = args.titleArg

        (activity as MainActivity?)?.supportActionBar?.title = title
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.repository = Repository(DbHelper.getDbInstance(requireContext())!!)

        viewModel.experienceInDetail.observe(requireActivity(), Observer {
            binding.progressBar.visibility = View.GONE
            binding.scrollView.visibility = View.VISIBLE

//            viewModel.loadFromDB(it)

            Picasso.with(requireContext()).load(it.coverImage.original).into(binding.imgView)
            binding.titleTextView.text = it.title

            binding.adressText.text = it.location.addressText
            binding.desc.text = it.description


            if(it.type == "culture"){
                binding.circleView.setImageResource(R.drawable.green_circle)
            }
            else if(it.type == "food"){
                binding.circleView.setImageResource(R.drawable.blue_circle)
            }

            binding.typeTextView.text = it.type

            binding.zz.text = "Location: "


            val latitude = it.location.coordinates.lat
            val longitude = it.location.coordinates.lon

            binding.location.text = "lon - $longitude  lat - $latitude"

            binding.descriptionLocation.text = it.location.description

                val dates = it.nextSchedules




                var content = ""

                for (d in dates) {

                    val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    parser.timeZone = TimeZone.getTimeZone("UTC")
                    val date = parser.parse(d)

                    val formatter = SimpleDateFormat("HH:mm, dd.MM.yyyy", Locale.getDefault())
                    val newDate = formatter.format(date!!)

                    content += "$newDate \n\n"


                }
//                binding.shedules.append(content)

                binding.shedules.text = content


        })



     // Error handling
        viewModel.error.observe(requireActivity(), Observer {
            binding.progressBar.visibility = View.GONE
            binding.scrollView.visibility = View.VISIBLE
            it.printStackTrace()
            if(it.localizedMessage == "Unable to resolve host \"a1ea1343-8fcb-408e-ba56-395933b2e4c8.mock.pstmn.io\": No address associated with hostname") {
                Toast.makeText(activity, "No connection", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(activity, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })


        val experienceID = args.experienceID
        viewModel.loadFromDB(experienceID)
        viewModel.updateFromAPI(experienceID)


    }




}