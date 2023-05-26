package mitrasinerjiteknoindo.departemenproduksi.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kode", length = 15)
    private String kode;

    @Column(name = "tgl")
    private Date tgl;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @Column(name = "harga_bandrol", precision = 10, scale = 2)
    private BigDecimal hargaBandrol;

    @Column(name = "diskon_pct", precision = 5, scale = 2)
    private BigDecimal diskonPct;

    @Column(name = "diskon_nilai", precision = 10, scale = 2)
    private BigDecimal diskonNilai;

    @Column(name = "ongkir", precision = 10, scale = 2)
    private BigDecimal ongkir;

    @Column(name = "total_bayar", precision = 10, scale = 2)
    private BigDecimal totalBayar;

    public Sales() {
        // konstruktor default
    }

    public Sales(Integer id, String kode, Date tgl, Customer customer, BigDecimal hargaBandrol, BigDecimal diskonPct,
            BigDecimal diskonNilai, BigDecimal ongkir, BigDecimal totalBayar) {
        this.id = id;
        this.kode = kode;
        this.tgl = tgl;
        this.customer = customer;
        this.hargaBandrol = hargaBandrol;
        this.diskonPct = diskonPct;
        this.diskonNilai = diskonNilai;
        this.ongkir = ongkir;
        this.totalBayar = totalBayar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getHargaBandrol() {
        return hargaBandrol;
    }

    public void setHargaBandrol(BigDecimal hargaBandrol) {
        this.hargaBandrol = hargaBandrol;
    }

    public BigDecimal getDiskonPct() {
        return diskonPct;
    }

    public void setDiskonPct(BigDecimal diskonPct) {
        this.diskonPct = diskonPct;
    }

    public BigDecimal getDiskonNilai() {
        return diskonNilai;
    }

    public void setDiskonNilai(BigDecimal diskonNilai) {
        this.diskonNilai = diskonNilai;
    }

    public BigDecimal getOngkir() {
        return ongkir;
    }

    public void setOngkir(BigDecimal ongkir) {
        this.ongkir = ongkir;
    }

    public BigDecimal getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(BigDecimal totalBayar) {
        this.totalBayar = totalBayar;
    }

    // Constructors, getters, and setters
    // ...
}
