package com.example.ktgk_2415141122119_nguyentanthang

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415141122119_nguyentanthang.databinding.ActivityMainBinding
import com.example.ktgk_2415141122119_nguyentanthang.repository.KhoanChiRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding_119: ActivityMainBinding
    private var khoanChi_119: KhoanChi = KhoanChiRepository.khoanChiHienTai_119

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_119 = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding_119.root)

        title = "NguyenTanThang - 2415141122119 - Quản lý chi tiêu cá nhân"
        supportActionBar?.title = "NguyenTanThang - 2415141122119 - Quản lý chi tiêu cá nhân"

        hienThiDuLieu_119()
        xuLySuKienNut_119()
    }

    override fun onResume() {
        super.onResume()
        khoanChi_119 = KhoanChiRepository.khoanChiHienTai_119
        hienThiDuLieu_119()
    }

    private fun hienThiDuLieu_119() {
        binding_119.edtTenKhoanChi119.setText(khoanChi_119.tenKhoanChi)
        binding_119.edtSoTien119.setText(khoanChi_119.soTien.toString())
        binding_119.edtMoTaKhoanChi119.setText(khoanChi_119.ghiChu)
        binding_119.chkDaThanhToan119.isChecked = khoanChi_119.daThanhToan
    }

    private fun xuLySuKienNut_119() {
        binding_119.btnThemKhoanChi119.setOnClickListener {
            val tenNhap_119 = binding_119.edtTenKhoanChi119.text.toString().trim()
            val tienNhap_119 = chuyenDoiSoTienHopLe_119(binding_119.edtSoTien119.text.toString())
            val ghiChuNhap_119 = binding_119.edtMoTaKhoanChi119.text.toString().trim()
            val trangThaiNhap_119 = binding_119.chkDaThanhToan119.isChecked

            if (!kiemTraTenHopLe_119(tenNhap_119)) {
                binding_119.edtTenKhoanChi119.error = "Tên khoản chi không được để trống!"
                thongBao_119("Tên khoản chi không được để trống!")
                return@setOnClickListener
            }

            if (tienNhap_119 == null) {
                binding_119.edtSoTien119.error = "Số tiền phải lớn hơn 0!"
                thongBao_119("Số tiền không hợp lệ!")
                return@setOnClickListener
            }

            khoanChi_119 = KhoanChi(
                maKhoanChi = "KC_2415141122119",
                tenKhoanChi = tenNhap_119,
                soTien = tienNhap_119,
                ghiChu = ghiChuNhap_119,
                daThanhToan = trangThaiNhap_119
            )
            KhoanChiRepository.capNhatKhoanChi_119(khoanChi_119)
            thongBao_119("Đã lưu: ${khoanChi_119.layThongTin()}")
        }

        binding_119.btnXemChiTiet119.setOnClickListener {
            val tenTruyen_119 = binding_119.edtTenKhoanChi119.text.toString().trim()
            val tienTruyen_119 = binding_119.edtSoTien119.text.toString().trim().toDoubleOrNull() ?: -1.0
            val ghiChuTruyen_119 = binding_119.edtMoTaKhoanChi119.text.toString().trim()
            val trangThaiTruyen_119 = binding_119.chkDaThanhToan119.isChecked

            val intentChiTiet_119 = Intent(this, ChiTietChiTieuActivity::class.java).apply {
                putExtra("EXTRA_TEN_119", tenTruyen_119)
                putExtra("EXTRA_SOTIEN_119", tienTruyen_119)
                putExtra("EXTRA_GHICHU_119", ghiChuTruyen_119)
                putExtra("EXTRA_DATHANHTOAN_119", trangThaiTruyen_119)
            }
            startActivity(intentChiTiet_119)
        }
    }
}