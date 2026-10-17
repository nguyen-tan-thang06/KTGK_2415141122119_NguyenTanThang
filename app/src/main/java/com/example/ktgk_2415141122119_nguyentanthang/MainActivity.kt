package com.example.ktgk_2415141122119_nguyentanthang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415141122119_nguyentanthang.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding_119: ActivityMainBinding

    // Khởi tạo dữ liệu cá nhân hóa không trùng lặp (>80%)
    private var tenKhoanChi_119: String = "Mua tai lieu Kotlin NguyenTanThang 119"
    private var soTien_119: Double = 119000.0
    private var moTaKhoanChi_119: String = "Giao trinh Android lop 2119KTPM01"
    private var daThanhToan_119: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_119 = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding_119.root)

        // Thiết lập tiêu đề Toolbar/ActionBar theo đúng yêu cầu đề thi
        title = "NguyenTanThang - 2415141122119 - Quản lý chi tiêu cá nhân"
        supportActionBar?.title = "NguyenTanThang - 2415141122119 - Quản lý chi tiêu cá nhân"

        hienThiDuLieuMacDinh_119()
        xuLySuKienNut_119()
    }

    private fun hienThiDuLieuMacDinh_119() {
        binding_119.edtTenKhoanChi119.setText(tenKhoanChi_119)
        binding_119.edtSoTien119.setText(soTien_119.toString())
        binding_119.edtMoTaKhoanChi119.setText(moTaKhoanChi_119)
        binding_119.chkDaThanhToan119.isChecked = daThanhToan_119
    }

    private fun xuLySuKienNut_119() {
        binding_119.btnThemKhoanChi119.setOnClickListener {
            val tenNhap_119 = binding_119.edtTenKhoanChi119.text.toString().trim()
            val tienNhap_119 = chuyenDoiSoTienHopLe_119(binding_119.edtSoTien119.text.toString())
            val ghiChuNhap_119 = binding_119.edtMoTaKhoanChi119.text.toString().trim()

            if (!kiemTraTenHopLe_119(tenNhap_119)) {
                binding_119.edtTenKhoanChi119.error = "Tên khoản chi không được để trống!"
                thongBao_119("Vui lòng nhập tên khoản chi hợp lệ!")
                return@setOnClickListener
            }

            if (tienNhap_119 == null) {
                binding_119.edtSoTien119.error = "Số tiền phải lớn hơn 0!"
                thongBao_119("Số tiền không hợp lệ!")
                return@setOnClickListener
            }

            tenKhoanChi_119 = tenNhap_119
            soTien_119 = tienNhap_119
            moTaKhoanChi_119 = ghiChuNhap_119
            daThanhToan_119 = binding_119.chkDaThanhToan119.isChecked

            thongBao_119("Đã thêm khoản chi: $tenKhoanChi_119 - $soTien_119 VNĐ")
        }

        binding_119.btnXemChiTiet119.setOnClickListener {
            thongBao_119("Mở màn hình chi tiết khoản chi")
        }
    }
}