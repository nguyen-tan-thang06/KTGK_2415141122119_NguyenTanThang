package com.example.ktgk_2415141122119_nguyentanthang

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415141122119_nguyentanthang.databinding.ActivityChiTietChiTieuBinding
import com.example.ktgk_2415141122119_nguyentanthang.repository.KhoanChiRepository

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var binding_119: ActivityChiTietChiTieuBinding
    private lateinit var khoanChi_119: KhoanChi

    private val boNhanKetQuaChinhSua_119 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua_119 ->
        if (ketQua_119.resultCode == Activity.RESULT_OK) {
            val duLieu_119 = ketQua_119.data
            if (duLieu_119 != null) {
                khoanChi_119 = KhoanChi(
                    maKhoanChi = khoanChi_119.maKhoanChi,
                    tenKhoanChi = duLieu_119.getStringExtra("RES_TEN_119") ?: khoanChi_119.tenKhoanChi,
                    soTien = duLieu_119.getDoubleExtra("RES_SOTIEN_119", khoanChi_119.soTien),
                    ghiChu = duLieu_119.getStringExtra("RES_GHICHU_119") ?: khoanChi_119.ghiChu,
                    daThanhToan = duLieu_119.getBooleanExtra("RES_DATHANHTOAN_119", khoanChi_119.daThanhToan)
                )
                KhoanChiRepository.capNhatKhoanChi_119(khoanChi_119)
                hienThiChiTiet_119()
                thongBao_119("Cập nhật khoản chi thành công!")
            }
        } else {
            thongBao_119("Đã hủy chỉnh sửa, giữ nguyên dữ liệu ban đầu!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_119 = ActivityChiTietChiTieuBinding.inflate(layoutInflater)
        setContentView(binding_119.root)

        title = "NguyenTanThang - 2415141122119 - Quản lý chi tiêu cá nhân"
        supportActionBar?.title = "NguyenTanThang - 2415141122119 - Quản lý chi tiêu cá nhân"

        khoanChi_119 = KhoanChi(
            maKhoanChi = "KC_2415141122119",
            tenKhoanChi = intent.getStringExtra("EXTRA_TEN_119") ?: "",
            soTien = intent.getDoubleExtra("EXTRA_SOTIEN_119", -1.0),
            ghiChu = intent.getStringExtra("EXTRA_GHICHU_119") ?: "",
            daThanhToan = intent.getBooleanExtra("EXTRA_DATHANHTOAN_119", false)
        )

        hienThiChiTiet_119()

        binding_119.btnMoChinhSua119.setOnClickListener {
            val intentSua_119 = Intent(this, ChinhSuaChiTieuActivity::class.java).apply {
                putExtra("EXTRA_TEN_119", khoanChi_119.tenKhoanChi)
                putExtra("EXTRA_SOTIEN_119", khoanChi_119.soTien)
                putExtra("EXTRA_GHICHU_119", khoanChi_119.ghiChu)
                putExtra("EXTRA_DATHANHTOAN_119", khoanChi_119.daThanhToan)
            }
            boNhanKetQuaChinhSua_119.launch(intentSua_119)
        }

        binding_119.btnQuayLai119.setOnClickListener {
            finish()
        }
    }

    private fun hienThiChiTiet_119() {
        if (!kiemTraTenHopLe_119(khoanChi_119.tenKhoanChi) || !khoanChi_119.laSoTienHopLe()) {
            binding_119.tvThongBaoLoi119.visibility = View.VISIBLE
            binding_119.tvThongBaoLoi119.text = "Cảnh báo: Tên khoản chi trống hoặc số tiền không hợp lệ!"
            thongBao_119("Dữ liệu khoản chi không hợp lệ!")
        } else {
            binding_119.tvThongBaoLoi119.visibility = View.GONE
        }

        binding_119.tvTenKhoanChi119.text = "Tên khoản chi: ${khoanChi_119.tenKhoanChi}"
        binding_119.tvSoTien119.text = "Số tiền: ${khoanChi_119.soTien} VNĐ"
        binding_119.tvGhiChu119.text = "Ghi chú: ${khoanChi_119.ghiChu}"
        val trangThaiStr_119 = if (khoanChi_119.daThanhToan) "Đã thanh toán" else "Chưa thanh toán"
        binding_119.tvTrangThai119.text = "Trạng thái: $trangThaiStr_119\nMô tả: ${khoanChi_119.layThongTin()}"
    }
}