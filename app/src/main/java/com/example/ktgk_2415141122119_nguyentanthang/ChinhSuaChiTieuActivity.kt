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
        caiDatTieuDe_119()

        // Hiển thị sẵn thông tin hiện tại
        binding_119.edtSuaTen119.setText(intent.getStringExtra("TEN_119") ?: "")
        binding_119.edtSuaSoTien119.setText(intent.getDoubleExtra("TIEN_119", 0.0).toString())
        binding_119.edtSuaGhiChu119.setText(intent.getStringExtra("GHICHU_119") ?: "")
        binding_119.chkSuaDaThanhToan119.isChecked = intent.getBooleanExtra("THANHTOAN_119", false)

        // Khi nhấn Lưu chỉnh sửa
        binding_119.btnLuu119.setOnClickListener {
            val tenMoi_119 = binding_119.edtSuaTen119.text.toString().trim()
            val tienMoi_119 = binding_119.edtSuaSoTien119.text.toString().trim().toDoubleOrNull()
            val ghiChuMoi_119 = binding_119.edtSuaGhiChu119.text.toString().trim()
            val daThanhToanMoi_119 = binding_119.chkSuaDaThanhToan119.isChecked

            if (!kiemTraHopLe_119(tenMoi_119, tienMoi_119)) {
                thongBao_119("Tên không được để trống và số tiền phải > 0!")
                return@setOnClickListener
            }

            val intentKetQua_119 = Intent().apply {
                putExtra("TEN_119", tenMoi_119)
                putExtra("TIEN_119", tienMoi_119!!)
                putExtra("GHICHU_119", ghiChuMoi_119)
                putExtra("THANHTOAN_119", daThanhToanMoi_119)
            }
            setResult(Activity.RESULT_OK, intentKetQua_119)
            finish()
        }

        // Khi nhấn Hủy chỉnh sửa -> Không thay đổi dữ liệu ban đầu
        binding_119.btnHuy119.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}