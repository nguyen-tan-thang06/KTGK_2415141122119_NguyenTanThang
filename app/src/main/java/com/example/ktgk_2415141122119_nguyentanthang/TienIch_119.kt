package com.example.ktgk_2415141122119_nguyentanthang

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Hàm đặt tiêu đề bắt buộc cho mọi màn hình
fun AppCompatActivity.caiDatTieuDe_119() {
    title = "NguyenTanThang - 2415141122119 - Quản lý chi tiêu cá nhân"
    supportActionBar?.title = title
}

// Hàm hiển thị thông báo Toast ngắn gọn
fun AppCompatActivity.thongBao_119(noiDung_119: String) {
    Toast.makeText(this, noiDung_119, Toast.LENGTH_SHORT).show()
}

// Hàm kiểm tra tên không trống và số tiền > 0
fun kiemTraHopLe_119(ten_119: String, soTien_119: Double?): Boolean {
    return ten_119.isNotBlank() && soTien_119 != null && soTien_119 > 0
}