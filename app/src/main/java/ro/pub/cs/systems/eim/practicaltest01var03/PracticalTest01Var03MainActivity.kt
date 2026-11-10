package ro.pub.cs.systems.eim.practicaltest01var03

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var03MainActivity : AppCompatActivity() {
    private var upText: EditText? = null
    private var downText: EditText? = null
    private var plusButton: Button? = null
    private var minusButton: Button? = null
    private var secondActivityButton: Button? = null
    private var opText: TextView? = null

    private val buttonClickListener = ButtonClickListener()
    private var serviceStarted: Boolean = false

    private inner class ButtonClickListener : View.OnClickListener {
        private var leftCount: Int = 0
        private var rightCount: Int = 0
        override fun onClick(view: View) {
            when (view.id) {
                R.id.plus_button -> {
                    try {
                        val a: Int = upText!!.text.toString().toInt()
                        val b: Int = downText!!.text.toString().toInt()
                        opText!!.setText("$a + $b = ${a+b}")
                    } catch (e: NumberFormatException) {
                        Toast.makeText(this@PracticalTest01Var03MainActivity, "Invalid input", Toast.LENGTH_LONG).show()
                    }
                    //opText!!.setText("$a + $b = ${a+b}")
                    //checkAndStartService(leftCount, rightCount)
                }
                R.id.minus_button -> {
                    try {
                        val a: Int = upText!!.text.toString().toInt()
                        val b: Int = downText!!.text.toString().toInt()
                        opText!!.setText("$a - $b = ${a-b}")
                    } catch (e: NumberFormatException) {
                        Toast.makeText(this@PracticalTest01Var03MainActivity, "Invalid input", Toast.LENGTH_LONG).show()
                    }
                    //checkAndStartService(leftCount, rightCount)
                }
                /*R.id.secondary_activity_button -> {
                    val intent = Intent(this@PracticalTest01MainActivity, PracticalTest01SecondaryActivity::class.java)
                    //val intent = Intent("ro.pub.cs.systems.eim.practicaltest01.intent.action.PracticalTest01SecondaryActivity")

                    val numberOfClicks = leftText!!.text.toString().toInt() +
                            rightText!!.text.toString().toInt()

                    intent.putExtra(Constants.NUMBER_OF_CLICKS, numberOfClicks)

                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE)
                }*/
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var03_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        upText = findViewById<View>(R.id.up_text) as EditText
        downText = findViewById<View>(R.id.down_text) as EditText
        opText = findViewById<View>(R.id.op_text) as TextView
        plusButton = findViewById<View>(R.id.plus_button) as Button
        minusButton = findViewById<View>(R.id.minus_button) as Button
        secondActivityButton = findViewById<View>(R.id.secondary_activity_button) as Button

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.UP_TEXT)) {
                upText!!.setText(savedInstanceState.getString(Constants.UP_TEXT))
            } else{
                upText!!.setText("1")
            }
            if (savedInstanceState.containsKey(Constants.DOWN_TEXT)) {
                downText!!.setText(savedInstanceState.getString(Constants.DOWN_TEXT))
            } else {
                downText!!.setText("1")
            }
            if (savedInstanceState.containsKey(Constants.OP_TEXT)) {
                opText!!.setText(savedInstanceState.getString(Constants.OP_TEXT))
            } else {
                opText!!.setText("1 + 1 = 2")
            }
        } else {
            upText!!.setText("1")
            downText!!.setText("1")
            opText!!.setText("1 + 1 = 2")
        }

        plusButton!!.setOnClickListener(buttonClickListener)
        minusButton!!.setOnClickListener(buttonClickListener)
        secondActivityButton!!.setOnClickListener(buttonClickListener)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(Constants.UP_TEXT, upText!!.text.toString())
        outState.putString(Constants.DOWN_TEXT, downText!!.text.toString())
        outState.putString(Constants.OP_TEXT, opText!!.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey(Constants.UP_TEXT)) {
            upText!!.setText(savedInstanceState.getString(Constants.UP_TEXT))
        } else{
            upText!!.setText("1")
        }
        if (savedInstanceState.containsKey(Constants.DOWN_TEXT)) {
            downText!!.setText(savedInstanceState.getString(Constants.DOWN_TEXT))
        } else {
            downText!!.setText("1")
        }
        if (savedInstanceState.containsKey(Constants.OP_TEXT)) {
            opText!!.setText(savedInstanceState.getString(Constants.OP_TEXT))
        } else {
            opText!!.setText("1 + 1 = 2")
        }
    }
}