package com.tregula.graedukacyjna.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.tregula.graedukacyjna.R
import javax.inject.Inject

class FragmentNavigator @Inject constructor(activity: FragmentActivity,
                                            private val dequeueProvider: DequeueProvider) : Navigator<@JvmSuppressWildcards Fragment> {

    private val fragmentManager = activity.supportFragmentManager

    override fun startWith(page: Fragment) {
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, page)
                .commitAllowingStateLoss()
    }

    override fun navigateTo(page: Fragment, tag: String?) {
        if (tag?.isNotEmpty() == true) {
            dequeueProvider.dequeue.add(tag)
        }

        val rootFrame = fragmentManager.findFragmentById(R.id.fragment_container)

        fragmentManager.beginTransaction().also {
            if (rootFrame != null) {
                it.hide(rootFrame)
            }
        }.add(R.id.fragment_container, page, tag)
                .addToBackStack(tag)
                .commitAllowingStateLoss()
    }

    override fun handleOnBackPress(): Boolean {
        val count = fragmentManager.backStackEntryCount
        return if (count == 0) {
            false
        } else {
            val tag: String? = dequeueProvider.dequeue.pollLast()
            tag?.let {
                fragmentManager.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            } ?: fragmentManager.popBackStack()

            true
        }
    }
}