package id.ac.ibda.pads.proyekuas.Model

data class CartItem(
    val productId: Int,
    val productName: String,
    val price: Double,
    var quantity: Int
)
