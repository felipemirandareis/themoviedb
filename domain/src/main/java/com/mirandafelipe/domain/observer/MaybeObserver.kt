package com.mirandafelipe.domain.observer

import io.reactivex.observers.DisposableMaybeObserver

open class MaybeObserver<T> : DisposableMaybeObserver<T>() {
    override fun onSuccess(value: T) {}

    override fun onComplete() {}

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }
}