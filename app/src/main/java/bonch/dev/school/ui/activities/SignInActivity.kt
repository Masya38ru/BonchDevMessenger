package bonch.dev.school.ui.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import bonch.dev.school.R

class SignInActivity : AppCompatActivity() {
    private lateinit var signUpButton: Button
    private lateinit var signInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        initializeView()
        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity().javaClass))
            finish()
        }
        signInButton.setOnClickListener {
            startActivity(Intent(this, MainAppActivity().javaClass))
            finish()
        }
    }

    fun initializeView() {
        signUpButton = findViewById(R.id.sign_up_button)
        signInButton = findViewById(R.id.sign_in_button)
    }
}
