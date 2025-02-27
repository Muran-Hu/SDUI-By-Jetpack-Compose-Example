package com.example.jetpackcompose.sdui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpackcompose.R
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class PactActivity : AppCompatActivity() {

    var mProgressBar:ProgressBar ?= null

    val mHandler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when(msg?.what) {
                0 -> {
                    mProgressBar?.visibility = View.GONE
                }
                1 -> {
                    mProgressBar?.visibility = View.GONE
                    Toast.makeText(this@PactActivity, "Something went wrong~", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pact_sdui_activity)

        val mUrlView = findViewById<EditText>(R.id.mUrlView)
        val mPreviewBtn = findViewById<TextView>(R.id.mPreviewBtn)
        mProgressBar = findViewById(R.id.indeterminateBar)

        mPreviewBtn.setOnClickListener {
            if (TextUtils.isEmpty(mUrlView.text.toString())) {
                Toast.makeText(this, "Please input JSON url", Toast.LENGTH_LONG).show()
            } else {
                getJson(mUrlView.text.toString().trim())
            }
        }
    }

    private val TIMEOUT_CONNECTION = 60
    private val TIMEOUT_WRITE = 120
    private val TIMEOUT_READ = 120

    private fun getJson(url: String) {
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_CONNECTION.toLong(), TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_WRITE.toLong(), TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_READ.toLong(), TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()

        mProgressBar?.visibility = View.VISIBLE
        client.newCall(Request.Builder().url(url).build())
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    val message = Message()
                    message.what = 1
                    mHandler.sendMessage(message)
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    // Enhancement with try-catch code:
                    // Fixed App crash issue which caused by MalformedJsonException:
                    // com.google.gson.JsonSyntaxException: com.google.gson.stream.MalformedJsonException:
                    // Use JsonReader.setLenient(true) to accept malformed JSON at line 1 column 5 path $
                    // com.google.gson.JsonParser.parse
                    val message = Message()
                    message.what = 0
                    mHandler.sendMessage(message)
                    try {
                        val res = response.body()!!.string()
                        val sduiBean = Gson().fromJson(res, SDUIBean::class.java)

                        println(sduiBean.name + " / " + sduiBean.componentGroups.size)

                        val intent = Intent(this@PactActivity, PactSDUIScreenActivity::class.java)
                        intent.putExtra(Constants.SDUI_BEAN, sduiBean)
                        startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            })
    }
}

