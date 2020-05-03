package pe.gob.msb.gp.enbici.ui.launch

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pe.gob.msb.gp.enbici.R
import pe.gob.msb.gp.enbici.ui.main.MainActivity

class LaunchActivity : AppCompatActivity(), SplashFragment.ActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayoutContent, SplashFragment.newInstance())
            .commit()
    }

    override fun navigateToActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}