package id.ac.ibda.pads.proyekuas.Model

data class ProductModel(
    val active_qty: Int,
    val available_qty: Int,
    val id: Int,
    val img_src: String,
    val name: String,
    val price: Double,
    val warehouse_qty: Int
)
