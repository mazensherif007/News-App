package com.example.newsapp.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private var _binding: VB? = null
    open val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflateBinding()
        setContentView(binding?.root)
    }

    abstract fun inflateBinding(): VB

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun interface OnDialogClick {
        fun onClick()
    }

    fun showDialog(
        message: String,
        posText: String? = null,
        negText: String? = null,
        posAction: OnDialogClick? = null,
        negAction: OnDialogClick? = null,
        isCancelable: Boolean = true
    ) {
        val builder = AlertDialog.Builder(this)
            .setMessage(message)
        posText?.let {
            builder.setPositiveButton(posText) { dialog, i ->
                dialog.dismiss()
                posAction?.onClick()
            }
        }
        negText?.let {
            builder.setPositiveButton(posText) { dialog, i ->
                dialog.dismiss()
                negAction?.onClick()
            }
        }
        builder.setCancelable(isCancelable)
    }

    fun showDialog(
        @StringRes message: Int,
        @StringRes posText: Int? = null,
        @StringRes negText: Int? = null,
        posAction: OnDialogClick? = null,
        negAction: OnDialogClick? = null,
        isCancelable: Boolean = true
    ) {
        val builder = AlertDialog.Builder(this)
            .setMessage(message)
        posText?.let {
            builder.setPositiveButton(posText) { dialog, i ->
                dialog.dismiss()
                posAction?.onClick()
            }
        }
        negText?.let {
            builder.setPositiveButton(negText) { dialog, i ->
                dialog.dismiss()
                negAction?.onClick()
            }
        }
        builder.setCancelable(isCancelable)
    }

}