package com.example.gamingnews

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<news>
    lateinit var title: Array<String>
    lateinit var info: Array<String>
    lateinit var img: Array<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        title= arrayOf(
            "God of War",
            "Overwatch",
            "Grand Theft Auto",
            "Halo Infinite",
            "Forza Horizon 5",
            "Elder Ring",
            "Call Of Duty Vanguard",
            "Battlefield 2042",

            )

        info= arrayOf(


            getString(R.string.God_of_war),
            getString(R.string.overwatch),
            getString(R.string.gta),
            getString(R.string.halo),
            getString(R.string.Forza),
            getString(R.string.Elder),
            getString(R.string.COD),
            getString(R.string.battlefield),



            )

        img= arrayOf(

            R.drawable.gow,
            R.drawable.over,
            R.drawable.gta,
            R.drawable.halo,
            R.drawable.froza,
            R.drawable.elder,
            R.drawable.cod,
            R.drawable.battle,

        )

        newRecyclerView=findViewById(R.id.Plantlist)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf()

        getuserdata()


    }

    private fun getuserdata() {
        for (i in title.indices ){
            val plant = news(title[i])
            newArrayList.add(plant)
            var adapter=newsAdapter(newArrayList)
            newRecyclerView.adapter=adapter
            adapter.setonItemClickListener(object :newsAdapter.onItemClickListener{
                override fun onitemclick(position: Int) {
//                    Toast.makeText(this@MainActivity, "you clicked on item no. $position", Toast.LENGTH_SHORT).show()

                    val intent= Intent(this@MainActivity,InfoActivity::class.java)
                    intent.putExtra("title", newArrayList[position].title)
                    intent.putExtra("info",info[position])
                    intent.putExtra("img",img[position])
                    startActivity(intent)
                }

            })
        }
    }


}
