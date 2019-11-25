package honeycomb.platform.android.fragment.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import honeycomb.android.R


class ProgressDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return activity?.let {
            val contentView = inflater.inflate(R.layout.view_dialog_progress, null)
            contentView
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