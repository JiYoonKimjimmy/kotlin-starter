package rxkotlin

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

class RxKotlinExample {
    fun run() {
        println("Hello RxKotlin")
        val list:List<Any> = listOf("One", "Two", "Three")
        val observable: Observable<Any> = list.toObservable()

        observable.subscribeBy(
            onNext = { println(it) },
            onError = { it.printStackTrace() },
            onComplete = { println("DONE!!") }
        )

        val subject: Subject<Int> = PublishSubject.create()

        subject
            .map { isEven(it) }
            .subscribe {
                println("The number is ${(if (it) "Even" else "Odd")}")
            }

        subject.onNext(2)
        subject.onNext(3)
    }

    private fun isEven(n: Int): Boolean = (n % 2 == 0)
}

fun main() {
    RxKotlinExample().run()
}
