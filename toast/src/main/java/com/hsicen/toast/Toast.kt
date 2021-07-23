package com.hsicen.toast

import android.content.Context
import android.widget.Toast

/**
 * 作者：hsicen  7/23/21 15:32
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：MavenPublish
 */
object Toast {

    /**
     * info 类型提示
     * @param ctx Context
     * @param msg String
     */
    fun info(ctx: Context, msg: String) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
    }
}