package com.mirandafelipe.domain.observer

import io.reactivex.observers.DisposableCompletableObserver

open class CompletableObserver : DisposableCompletableObserver() {
    override fun onComplete() {}
    override fun onError(exception: Throwable) {
        exception.printStackTrace()
    }
}