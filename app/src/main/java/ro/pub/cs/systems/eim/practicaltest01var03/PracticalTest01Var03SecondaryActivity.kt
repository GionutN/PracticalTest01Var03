package ro.pub.cs.systems.eim.practicaltest01var03

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var03SecondaryActivity : AppCompatActivity() {
    private var opText: TextView? = null
    private var okButton: Button? = null
    private var cancelButton: Button? = null

    private val buttonClickListener = ButtonClickListener()

    private inner class ButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            when (view.id) {
                R.id.ok_button -> {
                    setResult(RESULT_OK, null)
                }
                R.id.cancel_button -> {
                    setResult(RESULT_CANCELED, null)
                }
            }
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var03_secondary)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.secondActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        opText = findViewById<View>(R.id.op_text_view) as TextView
        okButton = findViewById<View>(R.id.ok_button) as Button
        cancelButton = findViewById<View>(R.id.cancel_button) as Button

        val intent = intent
        if (intent != null) {
            if (intent.extras!!.containsKey(Constants.OP_TEXT_SECOND)) {
                val op: String = intent.getStringExtra(Constants.OP_TEXT_SECOND) ?: "1+1=2"
                opText!!.text = op
            }
        }

        okButton!!.setOnClickListener(buttonClickListener)
        cancelButton!!.setOnClickListener(buttonClickListener)
    }
}