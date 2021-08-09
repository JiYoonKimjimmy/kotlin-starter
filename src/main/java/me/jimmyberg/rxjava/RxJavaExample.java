package me.jimmyberg.rxjava;

import io.reactivex.Observable;

public class RxJavaExample {
    public static void main(String[] args) {
        Observable.just(1, 2, 3)
                .map(i -> i * 10)
                .subscribe(System.out::println);
    }
}
