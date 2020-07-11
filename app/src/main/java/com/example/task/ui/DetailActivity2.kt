package com.example.task.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.task.DetailViewModel
import com.example.task.R
import com.example.task.databinding.ActivityDetail2Binding
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityDetail2Binding
    val viewModel: DetailViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)

        binding = ActivityDetail2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = intent.getStringExtra("keyTitle")


        displayDetailData()

        viewModel.error.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            binding.scrollView.visibility = View.VISIBLE
            it.printStackTrace()
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        })



        viewModel.result_exp.observe(this, Observer {

            binding.progressBar.visibility = View.GONE
            binding.scrollView.visibility = View.VISIBLE
            showAllData()
            binding.adressText.text = it.result.loc.addressText
            binding.descriptionLocation.text = it.result.loc.description
            binding.desc.text = it.result.description
        })


    }


    private fun displayDetailData(){

            viewModel.loadDetails(intent.getStringExtra("id")!!)

    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    private fun showAllData(){
        binding.titleTextView.text = intent.getStringExtra("keyTitle")

        if(intent.getStringExtra("keyType")!!.equals("culture")){
            binding.circleView.setImageResource(R.drawable.green_circle)
        }
        else if(intent.getStringExtra("keyType")!!.equals("food")){
            binding.circleView.setImageResource(R.drawable.blue_circle)
        }

        Picasso.with(this).load(intent.getStringExtra("keyImgUrl")).into(binding.imgView)


        val latitude = intent.getDoubleExtra("keyLat", 0.0)
        val longitude = intent.getDoubleExtra("keyLon", 0.0)

        binding.location.text = "lon - $longitude  lat - $latitude"

        binding.zz.text = "Location: "


        binding.typeTextView.text = intent.getStringExtra("keyType")


        val dates = intent.getStringArrayListExtra("keyList")

        var content: String = ""

        for(d in dates!!){
            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            parser.setTimeZone(TimeZone.getTimeZone("UTC"))
            val date = parser.parse(d)

            val formatter = SimpleDateFormat("HH:mm, dd.MM.yyyy", Locale.getDefault())
//            formatter.timeZone = TimeZone.getDefault()
            val newDate = formatter.format(date!!)

            content += "$newDate \n\n"


        }
        binding.shedules.append(content)


    }


}