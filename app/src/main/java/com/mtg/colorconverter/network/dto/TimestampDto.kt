package com.mtg.colorconverter.network.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TimestampDto(
    @Json(name = "abbreviation")
    val abbreviation: String,
    @Json(name = "client_ip")
    val clientIp: String,
    @Json(name = "datetime")
    val datetime: String,
    @Json(name = "day_of_week")
    val dayOfWeek: Int,
    @Json(name = "day_of_year")
    val dayOfYear: Int,
    @Json(name = "dst")
    val dst: Boolean,
    @Json(name = "dst_from")
    val dstFrom: String,
    @Json(name = "dst_offset")
    val dstOffset: Int,
    @Json(name = "dst_until")
    val dstUntil: String,
    @Json(name = "raw_offset")
    val rawOffset: Int,
    @Json(name = "timezone")
    val timezone: String,
    @Json(name = "unixtime")
    val unixtime: Int,
    @Json(name = "utc_datetime")
    val utcDatetime: String,
    @Json(name = "utc_offset")
    val utcOffset: String,
    @Json(name = "week_number")
    val weekNumber: Int
)