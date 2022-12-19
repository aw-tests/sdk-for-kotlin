package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * AlgoMD5
 */
data class AlgoMd5(
    /**
     * Algo type.
     *
     */
    @SerializedName("type")
    val type: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = AlgoMd5(
            type = map["type"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "type" to type as Any
    )
}
