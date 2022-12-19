package io.appwrite.models

import com.google.gson.annotations.SerializedName

/**
 * AlgoBcrypt
 */
data class AlgoBcrypt(
    /**
     * Algo type.
     *
     */
    @SerializedName("type")
    val type: String
) {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun from(map: Map<String, Any>) = AlgoBcrypt(
            type = map["type"] as String
        )
    }

    fun toMap(): Map<String, Any> = mapOf(
        "type" to type as Any
    )
}
