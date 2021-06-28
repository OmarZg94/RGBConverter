package com.mtg.colorconverter

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.mtg.colorconverter.databinding.ActivityMainBinding
import com.mtg.colorconverter.extension.isComplete
import com.mtg.colorconverter.extension.toLocalDateFormat
import com.mtg.colorconverter.network.dto.TimestampDto
import retrofit2.HttpException
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    /* */
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MainActivity
        }
    }

    /* */
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initBinding()
    }

    /** */
    private fun initBinding() {
        binding.apply {
            viewModel = mainViewModel
            btnConvert.setOnClickListener(::onConvertAction)
        }
    }

    /** */
    private fun onConvertAction(view: View) {
        var complete = true
        val message = getString(R.string.input_error)
        binding.apply {
            inputBlue.let {
                if (!it.isComplete()) {
                    it.error = message
                    complete = false
                } else null
            }
            inputGreen.let {
                if (!it.isComplete()) {
                    it.error = message
                } else null
            }
            inputRed.let {
                if (!it.isComplete()) {
                    it.error = message
                } else null
            }
            /* If all inputs are complete then convert to hex */
            if (complete) {
                hexadecimal = mainViewModel.convertRgbToHex().uppercase()
                imageView.setBackgroundColor(Color.parseColor(hexadecimal))
                downloadTimestampFromApi()
            }
        }
    }

    /** */
    private fun downloadTimestampFromApi() {
        mainViewModel.getTimestamp().observe(this, createTimestampObserver())
    }

    /** */
    private fun createTimestampObserver(): Observer<in Response<TimestampDto>> = Observer {
        if (it.isSuccessful) {
            it.body()?.let { timestampDto ->
                binding.timestamp = timestampDto.datetime.toLocalDateFormat()
            }
        } else manageTimestampError(HttpException(it))
    }

    /** */
    private fun manageTimestampError(exception: Exception) {
        val message = exception.localizedMessage ?: exception.stackTraceToString()
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }
}