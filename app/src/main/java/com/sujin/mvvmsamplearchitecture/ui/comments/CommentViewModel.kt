package com.sujin.mvvmsamplearchitecture.ui.comments

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CommentViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    private val disposables = CompositeDisposable()
}