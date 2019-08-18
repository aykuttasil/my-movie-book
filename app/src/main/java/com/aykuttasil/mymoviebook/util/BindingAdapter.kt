/**
 * Designed and developed by Aykut Asil (@aykuttasil)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aykuttasil.mymoviebook.util

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aykuttasil.mymoviebook.ui.fragment.popularmovies.DataHolder

interface BindableAdapter<T> {
    fun setData(items: DataHolder<List<T>>)
}

@BindingAdapter("listData")
fun <T> recyclerViewDataListBinding(recyclerView: RecyclerView, list: DataHolder<List<T>>?) {
    if (recyclerView.adapter is BindableAdapter<*>) {
        list?.apply {
            (recyclerView.adapter as BindableAdapter<T>).setData(this)
        }
    }
}

@BindingAdapter("visibleIf")
fun viewVisibleBinding(view: View, isVisible: Boolean) {
    if (isVisible) view.visibility = View.VISIBLE
    else view.visibility = View.GONE
}
