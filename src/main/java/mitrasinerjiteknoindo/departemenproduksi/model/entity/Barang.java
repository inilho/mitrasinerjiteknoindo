package mitrasinerjiteknoindo.departemenproduksi.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_barang")
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kode", length = 10)
    private String kode;

    @Column(name = "nama", length = 100)
    private String nama;

    @Column(name = "harga", precision = 10, scale = 2)
    private BigDecimal harga;

    // Constructors
    public Barang() {
    }

    public Barang(Integer id, String kode, String nama, BigDecimal harga) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    // getters, and setters

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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

}