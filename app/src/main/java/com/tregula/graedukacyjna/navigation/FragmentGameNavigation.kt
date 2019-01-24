package com.tregula.graedukacyjna.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.domain.view.data.ExternalLink
import com.tregula.graedukacyjna.view.WebBrowserFragment
import javax.inject.Inject

class FragmentGameNavigation @Inject constructor(activity: FragmentActivity) : GameNavigation {

    private val fragmentManager = activity.supportFragmentManager

    override fun openWebBrowser(externalLink: ExternalLink) {
        navigateToFragment(WebBrowserFragment.newInstance(externalLink))
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

    private fun navigateToFragment(fragment: Fragment) {
        val rootFrame = fragmentManager.findFragmentById(R.id.fragment_container)

        fragmentManager.beginTransaction().also {
            if (rootFrame != null) {
                it.hide(rootFrame)
            }
        }.add(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
    }
}