package id.ac.ibda.pads.proyekuas.Utils

object AccessTokenManager {
    private var accessToken: String? = null
    private var tokenListener: ((String?) -> Unit)? = null

    fun setAccessToken(token: String) {
        accessToken = token
        tokenListener?.invoke(token)
    }

    fun getAccessToken(listener: (String?) -> Unit) {
        if (accessToken != null) {
            listener(accessToken)
        } else {
            tokenListener = listener
        }
    }
}