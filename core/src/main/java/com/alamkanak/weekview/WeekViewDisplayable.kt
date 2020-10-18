package com.alamkanak.weekview

import android.content.Context

/**
 * This interface can be implemented by classes that should be displayed in [WeekView].
 * Instead of having to provide a list of [WeekViewEvent]s, you can provide a list of elements
 * of your class. The conversion to [WeekViewEvent] will happen in the background.
 */
interface WeekViewDisplayable<T> {

    /**
     * Returns a [WeekViewEvent] for use in [WeekView].
     */
    @Deprecated(
        message = "Override toWeekViewEvent(Context) instead.",
        replaceWith = ReplaceWith(
            expression = "toWeekViewEvent(context: Context)",
            imports = arrayOf("android.content.Context")
        )
    )
    fun toWeekViewEvent(): WeekViewEvent<T> {
        throw IllegalStateException("Override toWeekViewEvent(Context) instead.")
    }

    /**
     * Returns a [WeekViewEvent] for use in [WeekView].
     */
    fun toWeekViewEvent(context: Context): WeekViewEvent<T> = toWeekViewEvent()
}
