package com.example.pmdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pm.rsrsdk.DummyActivity
import com.example.pm.rsrsdk.ListView
import com.example.pm.rsrsdk.ToasterMsg
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeView -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.parkView -> {
                    val intent = Intent(this, ListView::class.java)
                    startActivity(intent)
                    true
                }
                R.id.reservationView -> {
                    ToasterMsg.toastMessage(this,"Calling view")

                    val intent = Intent(this, DummyActivity::class.java)
                    startActivity(intent)

                    true
                }
                R.id.settingsView -> {
                    loadFragment(SettingFragment())
                    true
                }
                else -> { false }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}