package com.o5appstudio.androidconcepts.androidarchitecture.livedata
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.o5appstudio.androidconcepts.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {
    lateinit var binding: ActivityDataBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Posts("Poetry","Zain Shakeel Poetry", "https://scontent.flhe3-1.fna.fbcdn.net/v/t39.30808-6/441495867_997906011705436_3781980757256198123_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeG3ihjQ2SJHwp-_meOnAtfoIIANJ--u1hkggA0n767WGUBd-ciLXm3GXmws1razgC_poQOEbCT6nEtWPP7HOkYi&_nc_ohc=DZHpScEUADMQ7kNvgHske9_&_nc_ht=scontent.flhe3-1.fna&oh=00_AYA-oWAilViBZsCj2PmpneJVsgbpuk51iWtPHyETNMWROQ&oe=66636B2C")
        binding.posts = post


    }
}