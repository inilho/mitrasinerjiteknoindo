package mitrasinerjiteknoindo.departemenproduksi.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_sales_det")
public class SalesDet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sales sales;

    @ManyToOne
    @JoinColumn(name = "barang_id")
    private Barang barang;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "harga_diskon", precision = 10, scale = 2)
    private BigDecimal hargaDiskon;

    public SalesDet(Integer id, Sales sales, Barang barang, Integer qty, BigDecimal subtotal, BigDecimal hargaDiskon) {
        this.id = id;
        this.sales = sales;
        this.barang = barang;
        this.qty = qty;
        this.subtotal = subtotal;
        this.hargaDiskon = hargaDiskon;
    }

    public SalesDet() {
        // konstruktor default
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getHargaDiskon() {
        return hargaDiskon;
    }

    public void setHargaDiskon(BigDecimal hargaDiskon) {
        this.hargaDiskon = hargaDiskon;
    }

    // Constructors, getters, and setters
    // ...
}
