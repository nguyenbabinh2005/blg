import java.util.HashSet;
public class Main{
  static class sinhvien{
    String ten;
    String mssv;
    float gpa;
    public sinhvien(String ten, String mssv, float gpa){
      this.ten = ten;
      this.mssv = mssv;
      this.gpa = gpa;
    }
    public void xuat(){
      System.out.println("tên: " + ten + "\t" + "mssv: " + mssv + "\t" + "gpa: " + gpa);
    }
    public String get(){
      return ten;
    }
  }
  static class node{
    sinhvien sv;
    node next;
    public node(sinhvien sv){
      this.sv = sv;
      next = null;
    }
  }
  static class danhsach{
    node dau;
    public void dau(sinhvien sv){
      node moi = new node(sv);
      moi.next = dau;
      dau = moi;
    }
    public void lap(){
      HashSet<String> a = new HashSet<>();
      node hientai = dau;
      node pre = null;
      while(hientai != null){
        if(a.contains(hientai.sv.ten)){
          pre.next = hientai.next;
        }
        else{
          a.add(hientai.sv.ten);
          pre = hientai;
        }
        hientai = hientai.next;
      }
    }
    public void cuoi(sinhvien sv){
      node moi = new node(sv);
      if(dau == null){
        dau = moi;
        return;
      }
      node hientai = dau;
      while(hientai.next != null){
        hientai = hientai.next;
      }
      hientai.next = moi;
    }
    public void xoa(String ten){
      if(dau == null){
        return;
      }
      if(dau.sv.ten.equals(ten)){
        dau = dau.next;
        return;
      }
      node hientai = dau;
      while(hientai.next != null){
        if(hientai.next.sv.ten.equals(ten)){
          hientai.next = hientai.next.next;
          return;
        }
        hientai = hientai.next;
      }
    }
    public void nguoc(){
      node pre = null;
      node hientai = dau;
      node next = null;
      while(hientai != null){
        next = hientai.next;
        hientai.next = pre;
        pre = hientai;
        hientai = next;
      }
      dau = pre;
    }
    public sinhvien giua(){
      node cham = dau;
      node nhanh = dau;
      while(nhanh != null && nhanh.next != null){
        nhanh = nhanh.next.next;
        cham = cham.next;
      }
      return cham.sv;
    }
    public void in(){
      if(dau == null){
        System.out.print("danh sách rỗng");
        return;
      }
      node hientai = dau;
      while(hientai != null){
        hientai.sv.xuat();
        hientai = hientai.next;
      }
    }
  }
  public static void main(String [] arg){
    danhsach ds = new danhsach();
    sinhvien x = new sinhvien("binh", "0003268", 3);
    sinhvien y = new sinhvien("chien", "0123579", 2);
    sinhvien z = new sinhvien("hung", "0021368", 1);
    sinhvien a = new sinhvien("nhat", "0001256", 2);
    sinhvien b = new sinhvien("manh", "0135802", 3);
    sinhvien c = new sinhvien("quang", "0035922", 1);
    sinhvien g = new sinhvien("manh", "0132352", 2);
    ds.cuoi(g);
    ds.dau(x);
    ds.cuoi(y);
    ds.cuoi(z);
    ds.dau(a);
    ds.cuoi(b);
    ds.cuoi(c);
    System.out.println("danh sách sinh viên ban đầu");
    ds.in();
    System.out.println("danh sách bị đảo ngược");
    ds.nguoc();
    ds.in();
    System.out.println("danh sách sau khi xoá tên " + a.get());
    ds.xoa(a.get());
    ds.in();
    System.out.println("sinh viên ở giữa");
    ds.giua().xuat();
    System.out.println("danh sách sau khi xoá sinh viên trùng lặp là");
    ds.lap();
    ds.in();
  }
}
