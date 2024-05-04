package com.example.pinterest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pinterest.databinding.ActivityMainBinding
import com.example.pinterest.fragments.AccountFragment
import com.example.pinterest.fragments.CreateFragment
import com.example.pinterest.fragments.HomeFragment
import com.example.pinterest.fragments.MessageFragment
import com.example.pinterest.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the username passed from LoginActivity
        username = intent.getStringExtra("USERNAME")

        replaceFragment(HomeFragment())  // Load the HomeFragment by default

        binding.bottomNavigationView.setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.home -> HomeFragment()
                R.id.search -> SearchFragment()
                R.id.create -> CreateFragment()
                R.id.message -> MessageFragment()
                R.id.account -> {
                    val accountFragment = AccountFragment()
                    // Set the username as an argument to AccountFragment if available
                    username?.let { username ->
                        accountFragment.arguments = Bundle().apply {
                            putString("USERNAME", username)
                        }
                    }
                    accountFragment
                }
                else -> return@setOnItemSelectedListener false
            }
            replaceFragment(fragment)
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
