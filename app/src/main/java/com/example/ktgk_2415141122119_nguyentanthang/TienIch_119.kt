package com.example.ktgk_2415141122119_nguyentanthang

import android.content.Context
import android.widget.Toast

// Hàm mở rộng (Extension function) giúp gọi Toast ngắn gọn ở mọi Activity
fun Context.thongBao_119(noiDung_119: String) {
    Toast.makeText(this, noiDung_119, Toast.LENGTH_SHORT).show()
}

// Kiểm tra tên không được rỗng và không chỉ chứa khoảng trắng
fun kiemTraTenHopLe_119(ten_119: String?): Boolean {
    return !ten_119.isNullOrBlank()
}

// Chuyển chuỗi sang số thực và kiểm tra lớn hơn 0
fun chuyenDoiSoTienHopLe_119(chuoiTien_119: String?): Double? {
    val soTien_119 = chuoiTien_119?.trim()?.toDoubleOrNull()
    return if (soTien_119 != null && soTien_119 > 0) soTien_119 else null
}