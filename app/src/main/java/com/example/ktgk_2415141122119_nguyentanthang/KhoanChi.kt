package com.example.ktgk_2415141122119_nguyentanthang

data class KhoanChi(
    val maKhoanChi: String = "KC_119",
    var tenKhoanChi: String = "",
    var soTien: Double = 0.0,
    var ghiChu: String = "",
    var daThanhToan: Boolean = false
) {
    fun laSoTienHopLe(): Boolean {
        return soTien > 0
    }

    fun layThongTin(): String {
        val trangThai_119 = if (daThanhToan) "Đã thanh toán" else "Chưa thanh toán"
        return "Mã: $maKhoanChi\nTên khoản chi: $tenKhoanChi\nSố tiền: $soTien VNĐ\nGhi chú: $ghiChu\nTrạng thái: $trangThai_119"
    }
}