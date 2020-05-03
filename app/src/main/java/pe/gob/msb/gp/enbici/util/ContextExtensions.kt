package pe.gob.msb.gp.enbici.util

import android.content.Context
import android.widget.Toast

fun Context.showMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}