package com.oybekdev.quizapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.oybekdev.quizapp.R
import com.oybekdev.quizapp.adapter.LeaderAdapter
import com.oybekdev.quizapp.databinding.ActivityLeaderBinding
import com.oybekdev.quizapp.domain.UserModel

class LeaderActivity : AppCompatActivity() {

    lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@LeaderActivity.window
        window.statusBarColor = ContextCompat.getColor(this@LeaderActivity, R.color.grey)

        binding.apply {
            scoreTopOneTxt.text = loadData().get(0).score.toString()
            scoreTopTwoTxt.text = loadData().get(1).score.toString()
            scoreTopThreeTxt.text = loadData().get(2).score.toString()
            titleTop1Txt.text = loadData().get(0).name
            titleTop2Txt.text = loadData().get(1).name
            titleTop3Txt.text = loadData().get(2).name

            val drawableResourceId1 :Int = binding.root.resources.getIdentifier(
                loadData().get(0).pic,"drawable",binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(pic1)

            val drawableResourceId2 :Int = binding.root.resources.getIdentifier(
                loadData().get(1).pic,"drawable",binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(pic2)

            val drawableResourceId3 :Int = binding.root.resources.getIdentifier(
                loadData().get(0).pic,"drawable",binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceId3)
                .into(pic3)


        }
    }

    //you can get below list from your API service, this is a example list
    private  fun loadData():MutableList<UserModel>{
        val users:MutableList<UserModel> = mutableListOf()
        users.add(UserModel(1,"oybek","person1",4850))
        users.add(UserModel(2,"sherbek","person2",4850))
        users.add(UserModel(3,"alli","person3",4850))
        users.add(UserModel(4,"bekki","person4",4850))
        users.add(UserModel(5,"jon","person5",4850))
        users.add(UserModel(6,"behzpd","person6",4850))
        users.add(UserModel(7,"zam","person7",4850))
        users.add(UserModel(8,"bek","person8",4850))
        users.add(UserModel(9,"joni","person9",4850))
        users.add(UserModel(10,"jek","person10",4850))
        return TODO("Bu yerni tugirlash kere")
    }
}