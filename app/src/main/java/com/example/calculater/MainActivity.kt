package com.example.calculater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var nStr :String = ""
    val nList = ArrayList<Double>()
    val oList = ArrayList<Char>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num0.setOnClickListener {
            formula.text = "${formula.text}0"
            nStr += "0"
        }

        num1.setOnClickListener{
            formula.text = "${formula.text}1"
            nStr += "1"
        }
        num2.setOnClickListener {
            formula.text = "${formula.text}2"
            nStr += "2"
        }

        num3.setOnClickListener{
            formula.text = "${formula.text}3"
            nStr += "3"
        }
        num4.setOnClickListener {
            formula.text = "${formula.text}4"
            nStr += "4"
        }

        num5.setOnClickListener{
            formula.text = "${formula.text}5"
            nStr += "5"
        }
        num6.setOnClickListener {
            formula.text = "${formula.text}6"
            nStr += "6"
        }

        num7.setOnClickListener{
            formula.text = "${formula.text}7"
            nStr += "7"
        }
        num8.setOnClickListener {
            formula.text = "${formula.text}8"
            nStr += "8"
        }

        num9.setOnClickListener{
            formula.text = "${formula.text}9"
            nStr += "9"
        }

        add.setOnClickListener{
            formula.text = "${formula.text}＋"
            addList(nStr, '+')
            nStr = ""
        }

        subtract.setOnClickListener{
            formula.text = "${formula.text}－"
            addList(nStr, '-')
            nStr = ""
        }

        multiply.setOnClickListener{
            formula.text = "${formula.text}×"
            addList(nStr,'*')
            nStr = ""
        }

        divide.setOnClickListener{
            formula.text = "${formula.text}÷"
            addList(nStr, '/')
            nStr = ""
        }

        equal.setOnClickListener{
            formula.text = "${formula.text}＝"
            addList(nStr)
            var result = calculate().toString()
            formula.text = result
            nStr = result
            nList.clear()
            oList.clear()
        }

        point.setOnClickListener{
            formula.text = "${formula.text}."
            nStr += "."
        }

        delete.setOnClickListener{
            var formulaStr = formula.text.toString()
            if(!formulaStr.isEmpty()){
                formula.text = formulaStr.subSequence(0, formulaStr.lastIndex)
            }
            if(!nStr.isEmpty()){
                nStr = nStr.substring(0, formulaStr.lastIndex)
            }
        }

        clear.setOnClickListener{
            formula.text = ""
            nStr = ""
            nList.clear()
            oList.clear()
        }

    }

    fun addList (str : String, ope : Char){
        try{
            val num = str.toDouble()
            nList.add(num)
            oList.add(ope)
        }catch(e:Exception){
            formula.text = "Numeric error"
        }
    }

    fun addList(str: String) {
        try {
            val num = str.toDouble()
            nList.add(num)
        } catch (e: Exception) {
            formula.text = "Numeric error"
        }
    }

    fun calculate():Double {

        var i = 0
        while (i < oList.size) {

            if (oList.get(i) == '*' || oList.get(i) == '/') {
                val result =
                    if (oList.get(i) == '*') nList.get(i) * nList.get(i + 1) else nList.get(i) / nList.get(i + 1)
                nList.set(i, result)
                nList.removeAt(i + 1)
                oList.removeAt(i)
                i--
            } else if (oList.get(i) == '-') {
                nList.set(i + 1, nList.get(i + 1) * -1)
                oList.set(i, '+')
            }
            i++
        }
        var result = 0.0
        for(i in nList){
            result += i
        }
        return result

    }



} // end class