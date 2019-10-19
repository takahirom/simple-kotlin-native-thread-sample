package sample

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val handler = Handler()
        Api().apiWithFreeze { response ->
            handler.post {
                Toast.makeText(applicationContext, response.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}
