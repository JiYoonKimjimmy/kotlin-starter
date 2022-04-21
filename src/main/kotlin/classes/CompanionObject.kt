package classes

import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class User3 private constructor(val nickName: String) {
    companion object {
        fun newNickName(email: String) = User3(email.substringBefore('@'))
    }
}

fun countClicks(window: Window) {
    var clickCount = 0
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            clickCount++
        }
    })
}

fun main() {
    val user = User3.newNickName("jimmyberg.kim@gmail.com")
    println(user.nickName)
}