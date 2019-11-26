package honeycomb.platform.android.fragment.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import honeycomb.android.databinding.ViewDialogProgressBinding


class ProgressDialogFragment : DialogFragment() {

    private lateinit var binding: ViewDialogProgressBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return activity?.let {
            binding = ViewDialogProgressBinding.inflate(inflater)
            binding.root
        } ?: throw IllegalStateException("Activity cannot be null")
    }


    companion object {
        private const val FRAGMENT_TAG =
            "honeycomb.platform.android.fragment.app.ProgressDialogFragment"

        fun present(fragmentManager: FragmentManager): ProgressDialogFragment {
            val fragment = ProgressDialogFragment()
            fragment.show(fragmentManager, FRAGMENT_TAG)
            return fragment
        }
    }
}
