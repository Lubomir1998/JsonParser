package com.example.task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task.adapters.MyAdapter
import com.example.task.R
import com.example.task.data.Experience
import com.example.task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listOfData: List<Experience>
    private lateinit var myAdapter: MyAdapter
    private lateinit var listener: MyAdapter.OnItemClickListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//
//        listener = object : MyAdapter.OnItemClickListener {
//            override fun onItemClicked(exp: Experience) {
//                val intent = Intent(this@MainActivity, DetailActivity2::class.java)
//                intent.putExtra("id", exp.id)
//                intent.putExtra("keyTitle", exp.title)
//                intent.putExtra("keyType", exp.type)
//                intent.putExtra("keyImgUrl", exp.imgUrl.original)
//                intent.putExtra("keyLon", exp.loc.coordinates.lon)
//                intent.putExtra("keyLat", exp.loc.coordinates.lat)
//                intent.putStringArrayListExtra("keyList", exp.date as ArrayList<String>)
//                startActivity(intent)
//            }
//
//        }
//        listOfData = mutableListOf()
//        myAdapter = MyAdapter(this, listOfData, listener)




        //getFirstData()




    }

//    private fun createRecyclerView(list: List<Experience>){
//        binding.recyclerView.apply {
//            adapter =
//                MyAdapter(this@MainActivity, list, listener)
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            setHasFixedSize(true)
//        }
//    }

//    private fun getFirstData(){
//        Repository().getData().enqueue(object : Callback<ResultObj> {
//
//            override fun onResponse(call: Call<ResultObj>, response: Response<ResultObj>) {
//                if(!response.isSuccessful){
//                    Toast.makeText(this@MainActivity, "Error ${response.code()}", Toast.LENGTH_LONG).show()
//                    return
//                }
//
//                binding.progressbar.visibility = View.INVISIBLE
//                binding.layout.visibility = View.VISIBLE
//
//                response.body()?.let {
//                    createRecyclerView(it.result)
//                    myAdapter.notifyDataSetChanged()
//
//                }
//
//
//           }

//            override fun onFailure(call: Call<ResultObj>, t: Throwable) {
//
//                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_LONG).show()
//            }
//
//        })
//    }


}