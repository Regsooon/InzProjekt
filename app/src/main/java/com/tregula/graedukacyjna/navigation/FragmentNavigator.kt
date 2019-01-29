package com.tregula.graedukacyjna.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.tregula.graedukacyjna.R
import javax.inject.Inject

class FragmentNavigator @Inject constructor(activity: FragmentActivity) : Navigator<@JvmSuppressWildcards Fragment> {

    private val fragmentManager = activity.supportFragmentManager

    override fun navigateTo(page: Fragment) {
        val rootFrame = fragmentManager.findFragmentById(R.id.fragment_container)

        fragmentManager.beginTransaction().also {
            if (rootFrame != null) {
                it.hide(rootFrame)
            }
        }.add(R.id.fragment_container, page)
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }

    override fun handleOnBackPress(): Boolean {
        val count = fragmentManager.backStackEntryCount
        return if (count == 0) {
            false
        } else {
            fragmentManager.popBackStack()
            true
        }
    }
}