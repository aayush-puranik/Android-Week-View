package com.alamkanak.weekview.jsr310

import com.alamkanak.weekview.WeekView
import com.alamkanak.weekview.WeekViewEntity
import java.time.LocalDate
import java.time.LocalDateTime

fun <T : Any> WeekViewEntity.Event.Builder<T>.setStartTime(
    startTime: LocalDateTime
) = setStartTime(startTime.toCalendar())

fun <T : Any> WeekViewEntity.Event.Builder<T>.setEndTime(
    endTime: LocalDateTime
) = setEndTime(endTime.toCalendar())

fun WeekViewEntity.BlockedTime.Builder.setStartTime(
    startTime: LocalDateTime
) = setStartTime(startTime.toCalendar())

fun WeekViewEntity.BlockedTime.Builder.setEndTime(
    endTime: LocalDateTime
) = setEndTime(endTime.toCalendar())

/**
 * Returns the minimum date that [WeekView] will display as a [LocalDate], or null if none is set.
 * Events before this date will not be shown.
 */
var WeekView.minDateAsLocalDate: LocalDate?
    get() = minDate?.toLocalDate()
    set(value) {
        minDate = value?.toCalendar()
    }

/**
 * Returns the maximum date that [WeekView] will display as a [LocalDate], or null if none is set.
 * Events after this date will not be shown.
 */
var WeekView.maxDateAsLocalDate: LocalDate?
    get() = maxDate?.toLocalDate()
    set(value) {
        maxDate = value?.toCalendar()
    }

/**
 * Returns the first visible date as a [LocalDate].
 */
val WeekView.firstVisibleDateAsLocalDate: LocalDate
    get() = firstVisibleDate.toLocalDate()

/**
 * Returns the last visible date as a [LocalDate].
 */
val WeekView.lastVisibleDateAsLocalDate: LocalDate
    get() = lastVisibleDate.toLocalDate()

/**
 * Shows a specific date. If it is before [WeekView.minDate] or after [WeekView.maxDate], these will be shown
 * instead.
 *
 * @param date The [LocalDate] to show.
 */
fun WeekView.goToDate(date: LocalDate) {
    goToDate(date.toCalendar())
}

fun WeekView.setDateFormatter(formatter: (LocalDate) -> String) {
    setDateFormatter { formatter(it.toLocalDate()) }
}
