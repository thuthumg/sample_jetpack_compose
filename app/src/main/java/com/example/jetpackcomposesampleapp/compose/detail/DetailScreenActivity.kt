package com.example.jetpackcomposesampleapp.compose.detail

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposesampleapp.ui.theme.GroceryAppTheme


class DetailScreenActivity : ComponentActivity() {
    private var pageChangeStatus:Boolean = false

    companion object {
        private const val PAGE_CHANGE_STATUS = "PAGE_CHANGE_STATUS"

        fun newIntent(
            context: Context,
            pageChangeStatus: Boolean): Intent {
            val intent = Intent(context, DetailScreenActivity::class.java)
            intent.putExtra(PAGE_CHANGE_STATUS, pageChangeStatus)

            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryAppTheme {
                getIntentParam()
               // DetailScreen(pageState = pageChangeStatus)/////???
            }


        }


    }


    @Composable
    private fun getIntentParam() {

        val context = LocalContext.current
        val activity = context.findActivity()
        val intent = activity?.intent
        pageChangeStatus = intent?.getBooleanExtra(PAGE_CHANGE_STATUS,false)?:false
    }

    fun Context.findActivity(): Activity? = when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    GroceryAppTheme {
      //  DetailScreen(pageState = true)
    }
}