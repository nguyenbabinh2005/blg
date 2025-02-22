import java.util.HashSet;
import java.util.Scanner;
import java.util.LinkedList;
public class Main{
  static class node{
    int data;
    node next;
    public node(int data){
      this.data = data;
      next = null;
    }
  }
  static class danhsach{
    node dau;
    public void dau(int data){
      node moi = new node(data);
      moi.next = dau;
      dau = moi;
    }
    public void gop(danhsach y){
        if(dau == null){
            dau = y.dau;
            return;
        }
        node hientai = dau;
        while(hientai.next != null){
            hientai = hientai.next;
        }
        hientai.next = y.dau;
    }
    public void dich(int k) {
      if (dau == null) return;
      node hientai = dau;
      int length = 1;
      while (hientai.next != null) {
        hientai = hientai.next;
        length++;
        
      }
      hientai.next = dau; // Tạo vòng lặp
      k = k % length;
      int stepsToNewHead = length - k;
      hientai = dau;
      for (int i = 1; i < stepsToNewHead; i++) {
        hientai = hientai.next;
      }
      dau = hientai.next;
      hientai.next = null;
    }
    public void xoaphantu(){
      int index = 0;
      node hientai = dau;
      node pre = null;
      if(dau == null){
        return;
      }
      while(hientai != null){
        if(index % 2 == 0){
          if(pre == null){
            dau = hientai.next;
          }
          else{
            pre.next = hientai.next;
          }
        }
        else{
          pre = hientai;
        }
        hientai = hientai.next;
        index++;
      }
    }
    public int max(){
      int max = 0;
      node hientai = dau;
      while(hientai != null){
        if(hientai.data > max){
          max = hientai.data;
        }
        hientai = hientai.next;
      }
      return max;
    }
    public void dem(){
      int count = 0;
      node hientai = dau;
      while(hientai != null){
        count += 1;
        hientai = hientai.next;
      }
      System.out.println("Số lượng phần tử trong danh sách");
      System.out.println(count);
    }
    public void cuoi(int data){
      node moi = new node(data);
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
    public void lap(){
      HashSet<Integer> a = new HashSet<>();
      node hientai = dau;
      node pre = null;
      while(hientai != null){
        if(a.contains(hientai.data)){
          pre.next = hientai.next;
        }
        else{
          a.add(hientai.data);
          pre = hientai;
        }
        hientai = hientai.next;
      }
    }
    public void xoa(int data){
      if(dau == null){
        return;
      }
      if(dau.data == data){
        dau = dau.next;
        return;
      }
      node hientai = dau;
      while(hientai.next != null){
        if(hientai.next.data == data){
          hientai.next = hientai.next.next;
          return;
        }
        hientai = hientai.next;
      }
    }
    public int giua(){
      node nhanh = dau, cham = dau;
      while(nhanh != null && nhanh.next != null){
        nhanh = nhanh.next.next;
        cham = cham.next;
      }
      return cham.data;
    }
    public void nguoc(){
      node pre= null;
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
    public void in(){
      if(dau == null){
        System.out.print("danh sach rong");
        return;
      }
      node hientai = dau;
      while(hientai != null){
        System.out.print(hientai.data + "\t");
        hientai = hientai.next;
      }
      System.out.println();
    }
  }
  public static void main(String[] args){
    danhsach ds = new danhsach();
    danhsach t = new danhsach();
    t.dau(5);
    t.cuoi(6);
    t.cuoi(99);
    t.cuoi(56);
    ds.cuoi(7);
    ds.dau(8);
    ds.dau(1);
    ds.dau(7);
    ds.dau(9);
    ds.cuoi(2);
    ds.cuoi(3);
    ds.cuoi(4);
    ds.cuoi(5);
    ds.cuoi(6);
    System.out.println("danh sach truoc khi xoa la: ");
    ds.in();
    System.out.println("danh sach sau khi xoa: ");
    ds.xoa(4);
    ds.in();
    System.out.println("danh sach bi dao nguooc:");
    ds.nguoc();
    ds.in();
    System.out.println("phan tu o giua");
    System.out.println(ds.giua());
    System.out.println("danh sach sau khi xoa phan tu trung lap");
    ds.lap();
    ds.in();
    ds.dem();
    System.out.println("gia tri lon nhat trong danh sach la: "+ds.max());
    System.out.println("danh sach sau khi xoa phan tu o chi so chan");
    ds.xoaphantu();
    ds.in();
    ds.cuoi(19);
    ds.cuoi(20);
    ds.cuoi(11);
    System.out.println("danh sach chua dich chuyen");
    ds.in();
    Scanner a = new Scanner(System.in);
    int b = a.nextInt();
    System.out.println("danh sach sau khi dich phai " + b + " lan");
    ds.dich(b);
    ds.in();
    System.out.println("danh sach thu 2");
    t.in();
    System.out.println("noi 2 danh sach");
    ds.gop(t);
    ds.in();
  }
}
