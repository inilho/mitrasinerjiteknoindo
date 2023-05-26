package mitrasinerjiteknoindo.departemenproduksi.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mitrasinerjiteknoindo.departemenproduksi.model.entity.Barang;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Integer> {
    // Mencari barang berdasarkan kode
    Barang findByKode(String kode);

    // Mencari barang berdasarkan nama
    List<Barang> findByNamaContaining(String nama);

    // Menghitung jumlah total barang
    Long countBy();

    // Menghitung jumlah barang berdasarkan harga
    Long countByHargaGreaterThan(BigDecimal harga);

    // Menghapus barang berdasarkan kode
    void deleteByKode(String kode);
}