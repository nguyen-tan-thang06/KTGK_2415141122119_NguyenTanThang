package com.example.ktgk_2415141122119_nguyentanthang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415141122119_nguyentanthang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding_119: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_119 = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding_119.root)
        caiDatTieuDe_119()

        // Khởi tạo dữ liệu ban đầu riêng biệt tránh trùng lặp >80%
        binding_119.edtTenKhoanChi119.setText("Mua giao trinh Kotlin 119")
        binding_119.edtSoTien119.setText("119000")
        binding_119.edtGhiChu119.setText("Sach hoc Android lop 2119KTPM01")

        // Sự kiện nút Thêm khoản chi
        binding_119.btnThemKhoanChi119.setOnClickListener {
            val tenKhoanChi_119 = binding_119.edtTenKhoanChi119.text.toString().trim()
            val soTien_119 = binding_119.edtSoTien119.text.toString().trim().toDoubleOrNull()

            if (!kiemTraHopLe_119(tenKhoanChi_119, soTien_119)) {
                val khoanChiMoi_119 = KhoanChi(
                    maKhoanChi = "KC_119",
                    tenKhoanChi = tenKhoanChi_119,
                    soTien = soTien_119!!,
                    ghiChu = binding_119.edtGhiChu119.text.toString().trim(),
                    daThanhToan = binding_119.chkDaThanhToan119.isChecked
                )
                com.example.ktgk_2415141122119_nguyentanthang.repository.KhoanChiRepository.khoanChiHienTai_119 = khoanChiMoi_119
                thongBao_119("Đã thêm:\n${khoanChiMoi_119.layThongTin()}")
                return@setOnClickListener
            }

            thongBao_119("Đã thêm: $tenKhoanChi_119 - $soTien_119 VNĐ")
        }
        override fun onResume() {
            super.onResume()
            val kc_119 = com.example.ktgk_2415141122119_nguyentanthang.repository.KhoanChiRepository.khoanChiHienTai_119
            binding_119.edtTenKhoanChi119.setText(kc_119.tenKhoanChi)
            binding_119.edtSoTien119.setText(kc_119.soTien.toString())
            binding_119.edtGhiChu119.setText(kc_119.ghiChu)
            binding_119.chkDaThanhToan119.isChecked = kc_119.daThanhToan
        }
        // SỬA ĐOẠN NÀY TRONG MainActivity.kt:
        binding_119.btnXemChiTiet119.setOnClickListener {
            val intent_119 = Intent(this, ChiTietChiTieuActivity::class.java).apply {
                putExtra("TEN_119", binding_119.edtTenKhoanChi119.text.toString().trim())
                putExtra("TIEN_119", binding_119.edtSoTien119.text.toString().trim().toDoubleOrNull() ?: -1.0)
                putExtra("GHICHU_119", binding_119.edtGhiChu119.text.toString().trim())
                putExtra("THANHTOAN_119", binding_119.chkDaThanhToan119.isChecked)
            }
            startActivity(intent_119)
        }
    }
}