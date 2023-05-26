package mitrasinerjiteknoindo.departemenproduksi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mitrasinerjiteknoindo.departemenproduksi.model.entity.SalesDet;

@Repository
public interface SalesDetRepository extends JpaRepository<SalesDet, Integer> {
    // Anda dapat menambahkan metode tambahan sesuai kebutuhan Anda
    // Mencari detail penjualan berdasarkan penjualan ID
    List<SalesDet> findBySalesId(Long salesId);

    // Mencari detail penjualan berdasarkan barang ID
    List<SalesDet> findByBarangId(Long barangId);

    // Menghitung jumlah total detail penjualan
    Long countBy();

    // Menghitung jumlah detail penjualan berdasarkan penjualan ID
    Long countBySalesId(Long salesId);

    // Tambahkan metode tambahan di sini jika diperlukan
}
