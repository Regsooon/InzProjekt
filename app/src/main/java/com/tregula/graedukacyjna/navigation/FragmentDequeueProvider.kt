package com.tregula.graedukacyjna.navigation

import java.util.*
import javax.inject.Inject

class FragmentDequeueProvider @Inject constructor() : DequeueProvider {

    override val dequeue: Deque<String> = LinkedList()

}