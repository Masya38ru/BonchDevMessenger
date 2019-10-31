package bonch.dev.school.ui.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import bonch.dev.school.R
import bonch.dev.school.ui.fragments.ChatFragment
import bonch.dev.school.ui.fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView

class MainAppActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val fm = supportFragmentManager

    lateinit var fragmentContainer: FrameLayout
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        setSupportActionBar(toolbar)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        fm.beginTransaction()
            .add(fragmentContainer.id, ChatFragment())
            .commit()
    }

    private fun initializeViews() {
        fragmentContainer = findViewById(R.id.fragment_container)
        drawerLayout = findViewById(R.id.drawer_layout)
        toolbar = findViewById(R.id.toolbar)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        fragmentContainer = findViewById(R.id.fragment_container)
        when (item.itemId) {
            R.id.nav_chat -> fm.beginTransaction()
                .replace(fragmentContainer.id, ChatFragment())
                .commit()
            R.id.nav_profile -> fm.beginTransaction()
                .replace(fragmentContainer.id, ProfileFragment())
                .commit()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
