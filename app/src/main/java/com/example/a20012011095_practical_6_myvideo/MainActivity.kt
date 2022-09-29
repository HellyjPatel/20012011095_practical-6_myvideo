package com.example.a20012011095_practical_6_myvideo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.core.view.WindowCompat
import com.example.a20012011095_practical_6_myvideo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window,false)

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSwitch.setOnClickListener{
            Intent(this,youtubeActivity::class.java).apply {
                startActivity(this)
            }

        }

    }
    private fun initVideoPlayer(){
        var mediaController=android.widget.MediaController(this)
        var uri=Uri.parse("android.resource://"+packageName+"/"+R.raw.thestoryoflight)
        binding.myVideo.setMediaController(mediaController)
        mediaController.setAnchorView(binding.myVideo)
        binding.myVideo.setVideoURI(uri)
        binding.myVideo.requestFocus()
        binding.myVideo.start()
    }
}