package honeycomb.platform.android.fragment.app

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import honeycomb.android.databinding.ViewDialogProgressBinding


class ProgressDialogFragment(private val _progressText: String) : DialogFragment() {

    private lateinit var binding: ViewDialogProgressBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        DialogFragmentService.removeTitleOnCreateDialog(dialog)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return activity?.let {
            fun initText() {
                _progressText.let {
                    binding.viewDialogProgressText.text = _progressText
                }
            }

            binding = ViewDialogProgressBinding.inflate(inflater)
            initText()
            binding.root
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onResume() {
        super.onResume()
        DialogFragmentService.preventUserCancellationOnResume(this)
    }

    companion object {
        private const val FRAGMENT_TAG =
            "honeycomb.platform.android.fragment.app.ProgressDialogFragment"

        fun present(
            fragmentManager: FragmentManager,
            progressText: String
        ): ProgressDialogFragment {
            val fragment = ProgressDialogFragment(progressText)
            fragment.show(fragmentManager, FRAGMENT_TAG)
            return fragment
        }

        suspend fun presentSuspendable(
            fragmentManager: FragmentManager,
            progressText: String,
            task: suspend () -> Unit
        ) {
            val fragment = present(fragmentManager, progressText)
            try {
                task()
            } finally {
                fragment.dismiss()
            }
        }
    }
}
