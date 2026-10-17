package com.example.ktgk_2415141122119_nguyentanthang

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415141122119_nguyentanthang.databinding.ActivityChiTietChiTieuBinding

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var binding_119: ActivityChiTietChiTieuBinding

    private var tenKhoanChi_119: String = ""
    private var soTien_119: Double = 0.0
    private var moTaKhoanChi_119: String = ""
    private var daThanhToan_119: Boolean = false

    // Đăng ký nhận kết quả từ ChinhSuaChiTieuActivity bằng Activity Result API
    private val boNhanKetQuaChinhSua_119 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua_119 ->
        if (ketQua_119.resultCode == Activity.RESULT_OK) {
            val duLieu_119 = ketQua_119.data
            if (duLieu_119 != null) {
                tenKhoanChi_119 = duLieu_119.getStringExtra("RES_TEN_119") ?: tenKhoanChi_119
                soTien_119 = duLieu_119.getDoubleExtra("RES_SOTIEN_119", soTien_119)
                moTaKhoanChi_119 = duLieu_119.getStringExtra("RES_GHICHU_119") ?: moTaKhoanChi_119
                daThanhToan_119 = duLieu_119.getBooleanExtra("RES_DATHANHTOAN_119", daThanhToan_119)

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

        tenKhoanChi_119 = intent.getStringExtra("EXTRA_TEN_119") ?: ""
        soTien_119 = intent.getDoubleExtra("EXTRA_SOTIEN_119", -1.0)
        moTaKhoanChi_119 = intent.getStringExtra("EXTRA_GHICHU_119") ?: ""
        daThanhToan_119 = intent.getBooleanExtra("EXTRA_DATHANHTOAN_119", false)

        hienThiChiTiet_119()

        binding_119.btnMoChinhSua119.setOnClickListener {
            val intentSua_119 = Intent(this, ChinhSuaChiTieuActivity::class.java).apply {
                putExtra("EXTRA_TEN_119", tenKhoanChi_119)
                putExtra("EXTRA_SOTIEN_119", soTien_119)
                putExtra("EXTRA_GHICHU_119", moTaKhoanChi_119)
                putExtra("EXTRA_DATHANHTOAN_119", daThanhToan_119)
            }
            boNhanKetQuaChinhSua_119.launch(intentSua_119)
        }

        binding_119.btnQuayLai119.setOnClickListener {
            finish()
        }
    }

    private fun hienThiChiTiet_119() {
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