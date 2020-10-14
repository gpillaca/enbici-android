package pe.gob.msb.gp.enbici.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import pe.gob.msb.gp.enbici.R
import pe.gob.msb.gp.enbici.databinding.ActivityMainBinding
import pe.gob.msb.gp.enbici.ui.map.MapFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.frameLayoutContent,
                MapFragment.newInstance(),
                MapFragment::class.java.simpleName
            )
            .addToBackStack(null).commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}