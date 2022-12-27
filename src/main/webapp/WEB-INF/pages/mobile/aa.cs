/// <summary>
/// 
/// </summary>
/// <param name="MaTuaSach"></param>
void HienThiTuaSachTheoMa(string MaTuaSach)
{
    DataTable dt = new TuaSachBLL().truyXuatDuLieuBang_TuaSach();
    if (dt.Rows.Count > 0)
    {
        foreach (DataRow dr in dt.Rows)
        {
            if (dr["MaTuaSach"].ToString() == MaTuaSach)
            {
                txtMaTuaSach.Text = dr["MaTuaSach"].ToString();
                txtTenTuaSach.Text = dr["TenTuaSach"].ToString();
                cboMaTacGia.SelectedValue = dr["MaTacGia"];
                cboMaTheLoai.SelectedValue = dr["MaTheLoai"];
                txtNDTomTat.Text = dr["NDTomTat"].ToString();

            }
        }
    }
}
/// <summary>
/// Tìm kiếm Cuốn Sách theo tên nếu không tìm thấy trả về null
/// </summary>
/// <param name="MaCuonSach"></param>
/// <returns>CuonSach</returns>
CuonSach GetCuonSach(string Tencuonsach)
{

    CuonSach  Sach = null;
    if(!String.IsNullOrEmpty(TenCuonSach)){
        DataTable dt = new CuonSachBLL().truyXuatDuLieuBang_CuonSach();
        if (dt.Rows.Count > 0)
        {           
            foreach (DataRow dr in dt.Rows)
            {
                if (dr["Tencuonsach"].ToString() == Tencuonsach)
                {
                    Sach = new CuonSach{
                        MaCuonSach =dr["MaCuonSach"].ToString() ,
                        Tencuonsach = dr["TenCuonSach"].ToString(),
                        MaDauSach = dr["MaDauSach"].ToString(),
                        TinhTrang = Boolean.Parse(dr["TinhTrang"].ToString()),                   
                    };               
                    break;
                }
            }
        }
    }
    return CuonSach;     
}

/// <summary>
/// 
/// </summary>
void HienThongTinMuonSach()
{
    DataTable dt = new MuonBLL().truyXuatDuLieuBang_Muon();
    if (dt.Rows.Count > 0)
    {
        lvwMuonSach.Items.Clear();
        int i = 1;
        foreach (DataRow dr in dt.Rows)
        {
            ListViewItem li = lvwMuonSach.Items.Add(i.ToString());
            li.SubItems.Add(dr["MaMuon"].ToString());
            li.SubItems.Add(dr["MaDocGia"].ToString());
            li.SubItems.Add(GetTenCuonSach(dr["MaCuonSach"].ToString()));
            li.SubItems.Add(dr["SoLuong"].ToString());
            li.SubItems.Add(dr["NgayMuon"].ToString());
            li.SubItems.Add(dr["NgayHenTra"].ToString());
            li.SubItems.Add(dr["NgayTra"].ToString());
            li.Tag = dr["MaMuon"].ToString();
            i++;
        }
    }
}


/// <summary>
/// Xóa  thông tin cho bảng DOCGIA (DAL)
/// </summary>
/// <param name="maDocGia">mã cđọc giả</param>
/// <returns> 0:có lỗi; 1:không có lỗi;  2: không có mã đọc giả trong bảng DOCGIA;
///          3:có mã đọc giả trong bảng MUON ; 4: bảng DOCGIA không có dữ liệu</returns>
public int Xoa(string maDocGia)
{
    DataTable dt = new DocGiaBLL().truyXuatDuLieuBang_DocGia();
    if (dt.Rows.Count > 0)
    {
        foreach (DataRow dr in dt.Rows)
        {
            if (dr["MaDocGia"].ToString() == maDocGia)
            {
                if (KiemTraMaDocGia_BangMuon(maDocGia) == false)
                {
                    //câu lệnh sql
                    string strSQL = "delete from DOCGIA"
                        "where MaDocGia='" + maDocGia + "'";
                    return objDAconnect.ExecuteQuery(strSQL);
                }
                else
                    return 3;
            }
        }      
        return 2;        
    }
    return 4;
   
}

