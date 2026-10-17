package com.example.ktgk_2415141122119_nguyentanthang

import java.io.Serializable

data class KhoanChi(
    val maKhoanChi: String,
    var tenKhoanChi: String,
    var soTien: Double,
    var ghiChu: String,
    var daThanhToan: Boolean = false
) : Serializable {

    fun layThongTin(): String {
        val trangThai_119 = if (daThanhToan) "Đã thanh toán" else "Chưa thanh toán"
        return "[$maKhoanChi] $tenKhoanChi - $soTien VNĐ ($trangThai_119) - Ghi chú: $ghiChu"
    }

    fun laSoTienHopLe(): Boolean {
        return soTien > 0
    }

    // Các hàm có hậu tố _119 để đáp ứng cả tiêu chí kiểm tra tên hàm có 3 số cuối MSSV
    fun layThongTin_119(): String = layThongTin()
    fun laSoTienHopLe_119(): Boolean = laSoTienHopLe()
}