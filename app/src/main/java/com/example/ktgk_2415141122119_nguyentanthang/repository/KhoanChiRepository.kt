package com.example.ktgk_2415141122119_nguyentanthang.repository

import com.example.ktgk_2415141122119_nguyentanthang.KhoanChi

object KhoanChiRepository {
    var khoanChiHienTai_119: KhoanChi = KhoanChi(
        maKhoanChi = "KC_2415141122119",
        tenKhoanChi = "Mua tai lieu Kotlin NguyenTanThang 119",
        soTien = 119000.0,
        ghiChu = "Giao trinh Android lop 2119KTPM01",
        daThanhToan = true
    )

    fun capNhatKhoanChi_119(khoanChiMoi_119: KhoanChi) {
        khoanChiHienTai_119 = khoanChiMoi_119
    }
}