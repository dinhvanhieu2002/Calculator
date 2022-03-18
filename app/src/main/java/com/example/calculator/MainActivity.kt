package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var etShowNumber : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        etShowNumber = binding.etShowNumber
    }

    fun buNumberEvent(view:View){
        if(isNewOp){
            etShowNumber.setText("")
        }
        isNewOp=false

        val buSelect= view as Button
        var buClickValue:String=etShowNumber.text.toString()
        when(buSelect.id){
            binding.bu0.id->{
                buClickValue+="0"
            }
            binding.bu1.id->{
                buClickValue+="1"
            }
            binding.bu2.id->{
                buClickValue+="2"
            }
            binding.bu3.id->{
                buClickValue+="3"
            }
            binding.bu4.id->{
                buClickValue+="4"
            }
            binding.bu5.id->{
                buClickValue+="5"
            }
            binding.bu6.id->{
                buClickValue+="6"
            }
            binding.bu7.id->{
                buClickValue+="7"
            }
            binding.bu8.id->{
                buClickValue+="8"
            }
            binding.bu9.id->{
                buClickValue+="9"
            }
            binding.buDot.id->{
                buClickValue+="."
            }
            binding.buPlusMins.id->{
                buClickValue= "-$buClickValue"
            }
        }
        etShowNumber.setText(buClickValue)
    }

    var op="*"
    var oldNumber=""
    var isNewOp=true

    fun buOpEvent(view:View){
        val buSelect= view as Button
        when(buSelect.id) {
            binding.buMul.id -> {
                op="*"
            }
            binding.buDiv.id -> {
                op="/"
            }
            binding.buSub.id -> {
                op="-"
            }
            binding.buSum.id -> {
                op="+"
            }

        }
        oldNumber=etShowNumber.text.toString()
        isNewOp=true
    }

    fun buEqualEvent(view: View){
        val newNumber=etShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->{
                finalNumber=  oldNumber.toDouble() *newNumber.toDouble()
            }
            "/"->{
                finalNumber=  oldNumber.toDouble() /newNumber.toDouble()
            }
            "+"->{
                finalNumber=  oldNumber.toDouble()+newNumber.toDouble()
            }
            "-"->{
                finalNumber=  oldNumber.toDouble() *newNumber.toDouble()
            }
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercent(view:View){
        val number:Double=etShowNumber.text.toString().toDouble()/100

        etShowNumber.setText(number.toString())
        isNewOp=true

    }

    fun buClean(view: View){
        etShowNumber.setText("0")
        isNewOp=true
    }



}