package pt.ismai.inf.ricardosousa.e_findit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var email: EditText
    lateinit var confirm_email: EditText
    lateinit var password: EditText
    lateinit var confirm_password: EditText
    lateinit var register_button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        email = findViewById(R.id.editTextEmail)

        /*confirm_email = findViewById(R.id.editTextConfirmEmail)*/

        password = findViewById(R.id.editTextPassword)

        confirm_password = findViewById(R.id.editTextConfirmPassword)

        register_button = findViewById(R.id.button_register)

        register_button.setOnClickListener {
            when {
                email.text.toString().isEmpty() -> {
                    Toast.makeText(baseContext, "Insert Email",
                        Toast.LENGTH_SHORT).show()
                }
                password.text.toString().isEmpty() -> {
                    Toast.makeText(baseContext, "Insert a valid Password",
                        Toast.LENGTH_SHORT).show()
                }/*
                email.text.toString() != confirm_email.text.toString() -> {
                    Toast.makeText(baseContext, "E-Mails are different",
                        Toast.LENGTH_SHORT).show()
                }*/
                password.text.toString() != confirm_password.text.toString() -> {
                    Toast.makeText(baseContext, "Passwords are different",
                        Toast.LENGTH_SHORT).show()
                }
                else -> {
                    registerUser(email.text.toString(), password.text.toString())
                }
            }
        }
    }

    private fun registerUser(email: String, password: String)
    {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    Toast.makeText(this, "You have successfully registered", Toast.LENGTH_SHORT).show()
                    val myIntent = Intent(this, LoginActivity::class.java)
                    myIntent.putExtra("email",email)
                    startActivity(myIntent)
                    finish()
                }
                else{
                    Toast.makeText(baseContext, "Registration failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}