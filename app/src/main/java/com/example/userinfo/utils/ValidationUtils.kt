package com.example.userinfo.utils

import android.widget.EditText

private const val MAX_NAME_TEXT_LENGTH: Int = 50
private const val MIN_NAME_TEXT_LENGTH: Int = 2
private const val MOBILE_NUMBER_LENGTH: Int = 10

fun EditText.validateName(): Pair<Boolean, String> =
    if (text == null || text.isEmpty())
        Pair(false, "User Name is required field")
    else if (text.length < MIN_NAME_TEXT_LENGTH)
        Pair(false, "Required a name with min length of $MIN_NAME_TEXT_LENGTH")
    else if (MAX_NAME_TEXT_LENGTH < text.length)
        Pair(false, "Required a name with max length of $MAX_NAME_TEXT_LENGTH")
    else if (!text.matches(Regex("[a-zA-Z0-9 ]*")))
        Pair(false, "Special characters not allowed")
    else Pair(true, text.toString())

fun EditText.validateMobile(): Pair<Boolean, String> =
    if (text != null && text.toString().isNotEmpty()) {
        when {
            text.length != MOBILE_NUMBER_LENGTH ->
                Pair(false, "Required a $MOBILE_NUMBER_LENGTH digit mobile number")
            !text.matches(Regex("^[0-9]{10}")) ->
                Pair(false, "Invalid mobile number")
            else -> Pair(true, text.toString())
        }
    } else Pair(false, "Mobile No. Required")

fun EditText.validateEmail(): Pair<Boolean, String> =
    if (text != null && text.toString().isNotEmpty())
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(
                text.toString().replace(
                    " ",
                    ""
                )
            ).matches().not()
        )
            Pair(false, "Required a valid email!")
        else Pair(true, text.toString())
    else Pair(false, "Email Address required!")
