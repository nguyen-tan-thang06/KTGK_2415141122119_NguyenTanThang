package com.example.ktgk_2415141122119_nguyentanthang

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415141122119_nguyentanthang.databinding.ActivityChiTietChiTieuBinding

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var binding_119: ActivityChiTietChiTieuBinding

    private var tenKhoanChi_119: String = ""
    private var soTien_119: Double = 0.0
    private var moTaKhoanChi_119: String = ""
    private var daThanhToan_119: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_119 = ActivityChiTietChiTieuBinding.inflate(layoutInflater)
        setContentView(binding_119.root)

        title = "NguyenTanThang - 2415141122119 - Quản lý chi tiêu cá nhân"
        supportActionBar?.title = "NguyenTanThang - 2415141122119 - Quản lý chi tiêu cá nhân"

        // Nhận dữ liệu từ Intent
        tenKhoanChi_119 = intent.getStringExtra("EXTRA_TEN_119") ?: ""
        soTien_119 = intent.getDoubleExtra("EXTRA_SOTIEN_119", -1.0)
        moTaKhoanChi_119 = intent.getStringExtra("EXTRA_GHICHU_119") ?: ""
        daThanhToan_119 = intent.getBooleanExtra("EXTRA_DATHANHTOAN_119", false)

        hienThiChiTiet_119()

        binding_119.btnQuayLai119.setOnClickListener {
            finish()
        }
    }

    private fun hienThiChiTiet_119() {
        // Kiểm tra trường hợp thiếu tên hoặc số tiền không hợp lệ
        if (!kiemTraTenHopLe_119(tenKhoanChi_119) || soTien_119 <= 0) {
            binding_119.tvThongBaoLoi119.visibility = View.VISIBLE
            binding_119.tvThongBaoLoi119.text = "Cảnh báo: Tên khoản chi bị trống hoặc số tiền không hợp lệ!"
            thongBao_119("Dữ liệu nhận được không hợp lệ!")
        } else {
            binding_119.tvThongBaoLoi119.visibility = View.GONE
        }

        binding_119.tvTenKhoanChi119.text = "Tên khoản chi: $tenKhoanChi_119"
        binding_119.tvSoTien119.text = "Số tiền: $soTien_119 VNĐ"
        binding_119.tvGhiChu119.text = "Ghi chú: $moTaKhoanChi_119"
        val trangThaiStr_119 = if (daThanhToan_119) "Đã thanh toán" else "Chưa thanh toán"
        binding_119.tvTrangThai119.text = "Trạng thái: $trangThaiStr_119"
    }
}