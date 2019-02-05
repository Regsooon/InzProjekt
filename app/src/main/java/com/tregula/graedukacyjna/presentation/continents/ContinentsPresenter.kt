package com.tregula.graedukacyjna.presentation.continents

import com.tregula.graedukacyjna.concurrent.GameSchedulers
import com.tregula.graedukacyjna.concurrent.action.GetContinentsData
import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.domain.data.mode.Mode
import com.tregula.graedukacyjna.navigation.GameNavigation
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ContinentsPresenter @Inject constructor(private val gameSchedulers: GameSchedulers,
                                              private val getContinentsData: GetContinentsData,
                                              private val gameNavigation: GameNavigation) : ContinentsContract.Presenter {

    private var view: ContinentsContract.View? = null
    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onContinentChosen(continent: ContinentData, mode: Mode) {
        //todo navigation
    }

    override fun attach(view: ContinentsContract.View) {
        this.view = view
        subscribeToEvents()
    }

    override fun detach() {
        view = null
        if (disposables.isDisposed.not()) {
            disposables.dispose()
        }
    }

    private fun subscribeToEvents() {
        val disposable: Disposable = getContinentsData.execute()
                .subscribeOn(gameSchedulers.io())
                .observeOn(gameSchedulers.main())
                .subscribe({ continents ->
                    view?.displayContinents(continents)
                }, {
                    view?.displayError()
                })
        disposables.add(disposable)
    }
}