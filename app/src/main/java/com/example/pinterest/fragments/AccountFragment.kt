package com.example.pinterest.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.pinterest.R
import com.example.pinterest.SettingActivity
//import Kairat Nurtas

class AccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.settings)
        button.setOnClickListener {
            val username = arguments?.getString("USERNAME", "") ?: ""
            val intent = Intent(context, SettingActivity::class.java)
            intent.putExtra("USERNAME", username)
            startActivity(intent)
        }

        val username = arguments?.getString("USERNAME", "") ?: ""

        println(username)

        val firstLetter = username.firstOrNull()?.toUpperCase().toString()
        Toast.makeText(context, "First letter of username: $firstLetter", Toast.LENGTH_LONG).show()
    }
}
