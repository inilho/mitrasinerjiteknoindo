package mitrasinerjiteknoindo.departemenproduksi.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "m_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kode", length = 10)
    private String kode;

    @Column(name = "nama", length = 100)
    private String nama;

    @Column(name = "telp", length = 20)
    private String telp;

    public Customer() {
        // konstruktor default
    }

    public Customer(Integer id, String kode, String nama, String telp) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.telp = telp;
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }
}