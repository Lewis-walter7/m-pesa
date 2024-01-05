package com.licoding.m_pesa.data.model

data class User1(
    val phoneNumber: String,
    val name: String,
    val profilePicture: ByteArray?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User1

        if (phoneNumber != other.phoneNumber) return false
        if (name != other.name) return false
        if (!profilePicture.contentEquals(other.profilePicture)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = phoneNumber.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + profilePicture.contentHashCode()
        return result
    }
}