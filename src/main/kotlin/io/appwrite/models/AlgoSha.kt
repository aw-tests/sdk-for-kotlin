package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * AlgoSHA
 */
data class AlgoSha(
    /**
     * Algo type.
     *
     */
    @SerializedName("type")
    val type: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = AlgoSha(
            type = map["type"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "type" to type as Any
    )
}
