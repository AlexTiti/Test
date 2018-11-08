package com.example.administrator.test

import android.view.View
import android.widget.ImageView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

/**
 * @author  : Alex
 * @date    : 2018/11/08
 * @version : V 2.0.2
 */
class ImageHasDrawableMatcher {

    companion object {
        /**
         * 自定义Matcher
         */
        fun hasDrawable():BoundedMatcher<View,ImageView> = object :BoundedMatcher<View,ImageView>(ImageView::class.java){
            override fun describeTo(description: Description?) {
               description?.appendText("has drawable")
            }

            override fun matchesSafely(item: ImageView): Boolean {
                return item.drawable != null
            }

        }
    }


}