package com.example.recibo

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recibo.R
import com.example.recibo.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity(){

    private lateinit var binding:ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.tvSignIn.setOnClickListener{
            val intent = Intent(this , SignInActivity::class.java)
            startActivity(intent)
        }


        binding.btRegister.setOnClickListener{
            val rUserNameEt = binding.rUserNameEt.text.toString()
            val rEmailEt = binding.rEmailEt.text.toString()
            val rPasswordEt = binding.rPasswordEt.text.toString()
            val rConfirmPasswordEt = binding.rConfirmPasswordEt.text.toString()
            if(rEmailEt.isNotEmpty() && rPasswordEt.isNotEmpty() && rConfirmPasswordEt.isNotEmpty() && rUserNameEt.isNotEmpty()){
                if(rPasswordEt == rConfirmPasswordEt){
                    firebaseAuth.createUserWithEmailAndPassword(rEmailEt, rPasswordEt).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this , SignInActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }


        /*
        mBinding.userNameEt.onFocusChangeListener = this
        mBinding.emailEt.onFocusChangeListener = this
        mBinding.passwordEt.onFocusChangeListener = this
        mBinding.confirmPasswordEt.onFocusChange
        Listener = this

         */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    /*
    private fun validateFullName(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.userNameEt.text.toString()
        if(value.isEmpty()){
            errorMessage = "Nombre es Requerido"
        }

        if(errorMessage != null){
            mBinding.userNameTil.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }

        return errorMessage == null
    }

    private fun validateEmail(): Boolean {
        var errorMessage: String? = null
        val value = mBinding.emailEt.text.toString()
        if(value.isEmpty()){
            errorMessage = "Email es Requerido"
        }else if(Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage = "Email no es válido"
        }

        if(errorMessage != null){
            mBinding.emailTil.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }

        return errorMessage == null
    }

    private fun validatePassword(): Boolean {
        var errorMessage: String? = null
        val value = mBinding.passwordEt.text.toString()
        if(value.isEmpty()){
            errorMessage = "Contraseña es Requerida"
        }else if(value.length < 6){
            errorMessage = "Contraseña debe tener al menos 6 caracteres"
        }

        if(errorMessage != null){
            mBinding.passwordTil.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }

        return errorMessage == null
    }

    private fun validateConfirmPassword(): Boolean {
        var errorMessage: String? = null
        val confirmPassword = mBinding.confirmPasswordEt.text.toString()
        val password = mBinding.passwordEt.text.toString()
        if(confirmPassword.isEmpty()){
            errorMessage = "Confirmar Contraseña es Requerida"
        }else if(confirmPassword != password){
                errorMessage = "Las contraseñas no coinciden"
        }

        if(errorMessage != null){
            mBinding.confirmPasswordTil.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }

        return errorMessage == null
    }

    override fun onClick(view: View?) {
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if(view != null) {
            when(view.id){
                R.id.rUserNameEt -> {
                    if(hasFocus){
                        if(mBinding.userNameTil.isErrorEnabled){
                            mBinding.userNameTil.isErrorEnabled = false
                        }
                    }else{
                        validateFullName()
                    }
                }
                R.id.rEmailEt -> {
                    if(hasFocus){
                        if(mBinding.emailTil.isErrorEnabled){
                            mBinding.emailTil.isErrorEnabled = false
                        }
                    }else{
                        if(validateEmail()){
                            //Hacer validacion por su unicidad Xd
                        }
                    }
                }
                R.id.rPasswordEt -> {
                    if(hasFocus){
                        if(mBinding.passwordTil.isErrorEnabled){
                            mBinding.passwordTil.isErrorEnabled = false
                        }
                    }else{
                        if(validatePassword() && mBinding.confirmPasswordEt.text!!.isNotEmpty() && validateConfirmPassword()){
                            if(mBinding.confirmPasswordTil.isErrorEnabled){
                                mBinding.confirmPasswordTil.isErrorEnabled = false
                            }
                            mBinding.confirmPasswordTil.apply {
                                setStartIconDrawable(R.drawable.check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }
                R.id.rConfirmPasswordEt -> {
                    if(hasFocus){
                        if(mBinding.confirmPasswordTil.isErrorEnabled){
                            mBinding.confirmPasswordTil.isErrorEnabled = false
                        }
                    }else{
                        if(validateConfirmPassword() && validatePassword()){
                            if(mBinding.passwordTil.isErrorEnabled){
                                mBinding.passwordTil.isErrorEnabled = false
                            }
                            mBinding.confirmPasswordTil.apply {
                                setStartIconDrawable(R.drawable.check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }

     */
}