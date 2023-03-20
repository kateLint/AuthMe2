package com.example.authme2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainViewActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toolbarmenu)
        toolbar = findViewById(R.id.my_toolbar)
        toolbar.title = ""
        supportActionBar?.setDisplayShowTitleEnabled(false);

        //setting the title

        setSupportActionBar(toolbar);

        supportFragmentManager.beginTransaction().add(
            R.id.fragment_container, GenerateCode.newInstance()).commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id: Int = item.itemId
        if(id == R.id.first_item){
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container, GenerateCode.newInstance()).commit()

        }else if(id == R.id.second_item){
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container, InOffice.newInstance()).commit()

        }

       return true
    }

}
