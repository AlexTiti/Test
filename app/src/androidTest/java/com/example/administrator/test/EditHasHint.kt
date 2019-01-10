package com.example.administrator.test

import android.service.autofill.FieldClassification
import android.view.View
import android.widget.EditText
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`


/**
 * @author  : Alex
 * @date    : 2018/11/09
 * @version : V 2.0.2
 */
class EditHasHint {

    companion object {

        fun hint(string: String) = hasHint(`is`(string))

        private fun hasHint(matcher : Matcher<String>): BoundedMatcher<View, EditText> = object : BoundedMatcher<View,EditText>(EditText::class.java){
            override fun describeTo(description: Description?) {
                description?.appendText("editText has hint")
            }

            override fun matchesSafely(item: EditText?): Boolean {
                return item?.hint != null && matcher.matches(item.hint)
            }
        }


        fun hasHintEqualsText(string: String) = object :BoundedMatcher<View,EditText>(EditText::class.java){
            override fun describeTo(description: Description?) {
                description?.appendText("editText has hint")
            }

            override fun matchesSafely(item: EditText?): Boolean {
                return string == item?.hint
            }

        }
    }
}