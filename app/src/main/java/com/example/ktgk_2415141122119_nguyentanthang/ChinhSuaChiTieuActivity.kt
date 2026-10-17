package com.example.ktgk_2415141122119_nguyentanthang

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_2415141122119_nguyentanthang.databinding.ActivityChinhSuaChiTieuBinding

class ChinhSuaChiTieuActivity : AppCompatActivity() {

    private lateinit var binding_119: ActivityChinhSuaChiTieuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding_119 = ActivityChinhSuaChiTieuBinding.inflate(layoutInflater)
        setContentView(binding_119.root)

        title = "NguyenTanThang - 2415141122119 - Quản lý chi tiêu cá nhân"
        supportActionBar?.title = "NguyenTanThang - 2415141122119 - Quản lý chi tiêu cá nhân"

        // Hiển thị sẵn dữ liệu hiện tại
        val tenHienTai_119 = intent.getStringExtra("EXTRA_TEN_119") ?: ""
        val soTienHienTai_119 = intent.getDoubleExtra("EXTRA_SOTIEN_119", 0.0)
        val ghiChuHienTai_119 = intent.getStringExtra("EXTRA_GHICHU_119") ?: ""
        val daThanhToanHienTai_119 = intent.getBooleanExtra("EXTRA_DATHANHTOAN_119", false)

        binding_119.edtSuaTen119.setText(tenHienTai_119)
        binding_119.edtSuaSoTien119.setText(if (soTienHienTai_119 > 0) soTienHienTai_119.toString() else "")
        binding_119.edtSuaGhiChu119.setText(ghiChuHienTai_119)
        binding_119.chkSuaDaThanhToan119.isChecked = daThanhToanHienTai_119

        // Nút Lưu chỉnh sửa
        binding_119.btnLuuChinhSua119.setOnClickListener {
            val tenMoi_119 = binding_119.edtSuaTen119.text.toString().trim()
            val tienMoi_119 = chuyenDoiSoTienHopLe_119(binding_119.edtSuaSoTien119.text.toString())
            val ghiChuMoi_119 = binding_119.edtSuaGhiChu119.text.toString().trim()
            val trangThaiMoi_119 = binding_119.chkSuaDaThanhToan119.isChecked

            if (!kiemTraTenHopLe_119(tenMoi_119)) {
                binding_119.edtSuaTen119.error = "Tên khoản chi không được để trống!"
                thongBao_119("Tên khoản chi không hợp lệ!")
                return@setOnClickListener
            }

            if (tienMoi_119 == null) {
                binding_119.edtSuaSoTien119.error = "Số tiền phải lớn hơn 0!"
                thongBao_119("Số tiền không hợp lệ!")
                return@setOnClickListener
            }

            val ketQuaIntent_119 = Intent().apply {
                putExtra("RES_TEN_119", tenMoi_119)
                putExtra("RES_SOTIEN_119", tienMoi_119)
                putExtra("RES_GHICHU_119", ghiChuMoi_119)
                putExtra("RES_DATHANHTOAN_119", trangThaiMoi_119)
            }
            setResult(Activity.RESULT_OK, ketQuaIntent_119)
            finish()
        }

        // Nút Hủy chỉnh sửa: trả về RESULT_CANCELED để không làm thay đổi dữ liệu ban đầu
        binding_119.btnHuyChinhSua119.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}