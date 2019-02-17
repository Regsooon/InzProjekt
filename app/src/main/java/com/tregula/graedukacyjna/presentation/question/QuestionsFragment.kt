package com.tregula.graedukacyjna.presentation.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.base.InjectedFragment
import com.tregula.graedukacyjna.domain.data.CountryData
import com.tregula.graedukacyjna.navigation.Navigator
import com.tregula.graedukacyjna.view.question.QuestionsView
import com.tregula.graedukacyjna.view.question.adapter.QuestionsAdapter
import javax.inject.Inject

class QuestionsFragment : InjectedFragment() {

    companion object {
        private const val ARG_CONTENT = "arg_content"

        fun newInstance(questionPool: List<CountryData>): QuestionsFragment {
            val bundle = Bundle().apply {
                putParcelableArrayList(ARG_CONTENT, ArrayList(questionPool))
            }
            return QuestionsFragment().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var questionsContainer: QuestionsView
    private var questionPool: List<CountryData> = emptyList()

    @Inject
    lateinit var navigator: Navigator<Fragment>
    @Inject
    lateinit var presenter: QuestionsContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_questions, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questionsContainer = view.findViewById(R.id.questions_container)
        questionsContainer.onNavigationBack = {
            navigator.handleOnBackPress()
        }

        fragmentManager?.let {
            questionsContainer.questionsAdapter = QuestionsAdapter(it)
        }
        presenter.attach(questionsContainer)
        presenter.prepareQuestions(questionPool)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pool: ArrayList<CountryData>? = arguments?.getParcelableArrayList(ARG_CONTENT)
        questionPool = pool.orEmpty()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}