package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv: TextView
    private lateinit var fragment1btn: Button
    private lateinit var fragment2btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.textView2)

        val username = intent.getParcelableExtra<user>("User")?.username
        val password = intent.getParcelableExtra<user>("User")?.password
        tv.text = "username: $username dan Password: $password"

        fragment1btn = findViewById(R.id.fragment1btn)
        fragment2btn = findViewById(R.id.fragment2btn)
        fragment1btn.setOnClickListener(this)
        fragment2btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_implicit -> {
//                val message = "Hallo World!"
//                val intent = Intent()
//                intent.action = Intent.ACTION_SEND
//                intent.putExtra(Intent.EXTRA_TEXT, message)
//                intent.type = "text/plain"
//                startActivity(intent)
                val intent = Intent()
                intent.putExtra("history", "Anda sudah login")
                setResult(RESULT_OK,intent)
                finish()
            }

            R.id.fragment1btn -> {
                replaceFragment(Fragment1())
            }

            R.id.fragment2btn -> {
                replaceFragment(Fragment2())
            }

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }

}