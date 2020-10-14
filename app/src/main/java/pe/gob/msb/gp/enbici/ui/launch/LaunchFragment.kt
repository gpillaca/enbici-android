package pe.gob.msb.gp.enbici.ui.launch

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import pe.gob.msb.gp.enbici.R
import pe.gob.msb.gp.enbici.util.PermissionHelper
import javax.inject.Inject

private const val REQUEST_LOCATION = 1

@AndroidEntryPoint
class LaunchFragment : Fragment() {

    @Inject
    lateinit var permissionHelper: PermissionHelper

    private var listener: ActionListener? = null

    interface ActionListener {
        fun navigateToActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_launch, container, false)

    companion object {
        @JvmStatic
        fun newInstance() = LaunchFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestLocationPermission(REQUEST_LOCATION)
    }

    private fun requestLocationPermission(requestCode: Int) {
        context?.let {
            if (permissionHelper.locationPermissionNotGranted(it)) {
                permissionHelper.requestLocationPermission(requestCode, this)
                return
            }

            listener?.navigateToActivity()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults.isNotEmpty() &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            if (requestCode == REQUEST_LOCATION) {
                listener?.navigateToActivity()
            }
        } else {
            requestLocationPermission(REQUEST_LOCATION)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ActionListener) {
            listener = context as ActionListener
        }
    }
}