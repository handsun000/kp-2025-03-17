package com.back.standard.util

object Ut {
    object str {
        @JvmStatic
        fun lcfirst(str: String): String {
            return str[0].lowercaseChar() + str.substring(1)
        }
    }
}