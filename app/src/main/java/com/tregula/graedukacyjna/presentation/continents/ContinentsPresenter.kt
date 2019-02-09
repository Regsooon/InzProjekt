package com.tregula.graedukacyjna.presentation.continents

import com.tregula.graedukacyjna.concurrent.GameSchedulers
import com.tregula.graedukacyjna.domain.data.ContinentData
import com.tregula.graedukacyjna.domain.data.mode.Mode
import com.tregula.graedukacyjna.domain.repository.ContinentsRepository
import com.tregula.graedukacyjna.navigation.GameNavigation
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class ContinentsPresenter @Inject constructor(private val gameSchedulers: GameSchedulers,
                                              private val continentsRepository: ContinentsRepository,
                                              private val gameNavigation: GameNavigation) : ContinentsContract.Presenter {

    private var view: ContinentsContract.View? = null
    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onContinentChosen(continent: ContinentData, mode: Mode) {
        if (mode == Mode.LEARNING) {
            gameNavigation.openCountries(continent)
        }
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
        view?.showLoading()

        val disposable: Disposable = continentsRepository.getContinentsData()
                .subscribeOn(gameSchedulers.io())
                .observeOn(gameSchedulers.main())
                .subscribe({ continents ->
                    view?.hideLoading()
                    view?.displayContinents(continents)
                }, {
                    view?.hideLoading()
                    view?.displayError()
                })
        disposables.add(disposable)
    }
}