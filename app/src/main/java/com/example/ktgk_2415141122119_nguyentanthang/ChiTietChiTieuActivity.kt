package com.example.ktgk_2415141122119_nguyentanthang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415141122119_nguyentanthang.databinding.ActivityChiTietChiTieuBinding

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var binding_119: ActivityChiTietChiTieuBinding
    private var tenKhoanChi_119: String = ""
    private var soTien_119: Double = -1.0
    private var moTaKhoanChi_119: String = ""
    private var daThanhToan_119: Boolean = false

    // (VỊ TRÍ 1: Lát nữa ở Câu 3 sẽ thêm boNhanKetQua_119 tại đây)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_119 = ActivityChiTietChiTieuBinding.inflate(layoutInflater)
        setContentView(binding_119.root)
        caiDatTieuDe_119()

        // Nhận dữ liệu từ Intent
        tenKhoanChi_119 = intent.getStringExtra("TEN_119") ?: ""
        soTien_119 = intent.getDoubleExtra("TIEN_119", -1.0)
        moTaKhoanChi_119 = intent.getStringExtra("GHICHU_119") ?: ""
        daThanhToan_119 = intent.getBooleanExtra("THANHTOAN_119", false)

        hienThiChiTiet_119()

        // (VỊ TRÍ 2: Lát nữa ở Câu 3 sẽ thêm sự kiện btnMoChinhSua119 tại đây)

        binding_119.btnQuayLai119.setOnClickListener {
            finish()
        }
    }

    private fun hienThiChiTiet_119() {
        if (!kiemTraHopLe_119(tenKhoanChi_119, soTien_119)) {
            binding_119.tvThongTinChiTiet119.text = "Cảnh báo: Thiếu tên khoản chi hoặc số tiền không hợp lệ!"
            thongBao_119("Dữ liệu khoản chi không hợp lệ!")
        } else {
            val trangThai_119 = if (daThanhToan_119) "Đã thanh toán" else "Chưa thanh toán"
            binding_119.tvThongTinChiTiet119.text =
                "Tên khoản chi: $tenKhoanChi_119\nSố tiền: $soTien_119 VNĐ\nGhi chú: $moTaKhoanChi_119\nTrạng thái: $trangThai_119"
        }
    }
}