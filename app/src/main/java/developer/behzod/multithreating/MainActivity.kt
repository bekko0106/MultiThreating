package developer.behzod.multithreating

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import developer.behzod.multithreating.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var handler: Handler
    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val runnable = object : Runnable {
            override fun run() {
//binding.myProgressBar.progress = progressInt
//            binding.tvProgress.text = progressInt.toString()
                handler.postDelayed(this, 100)
                finish()
                startActivity(Intent(this@MainActivity, MainActivity::class.java))
            }

        }



        mediaPlayer = MediaPlayer.create(this, R.raw.jinni)
        mediaPlayer.start()
        handler = Handler(Looper.getMainLooper()!!)
        handler.postDelayed(runnable, 100)


       onBackPressed()
    }
}