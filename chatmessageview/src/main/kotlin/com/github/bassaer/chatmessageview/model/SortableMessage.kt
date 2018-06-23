package com.github.bassaer.chatmessageview.model

import com.github.bassaer.chatmessageview.util.DateFormatter
import com.github.bassaer.chatmessageview.util.ITimeFormatter
import java.util.*

/**
 * Created by marcos-ambrosi on 2/21/18.
 */
abstract class SortableMessage {

    /**
     * Date separator text format.
     * This text is shown if the before or after message was sent different day
     */
    var mDateFormatter: ITimeFormatter? = null


    /**
     * The time message that was created
     */
    var sendTime = Calendar.getInstance()

    /**
     * Message status
     * You can use to know the message status such as fail, delivered, seen.. etc.
     */

    var status: Int = 0

    val dateSeparateText: String
        get() = mDateFormatter!!.getFormattedTimeText(sendTime!!)

    init {
        sendTime = Calendar.getInstance()
        mDateFormatter = DateFormatter()
    }
}