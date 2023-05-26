package mitrasinerjiteknoindo.departemenproduksi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mitrasinerjiteknoindo.departemenproduksi.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Mencari customer berdasarkan kode
    Customer findByKode(String kode);

    // Mencari customer berdasarkan nama
    List<Customer> findByNamaContaining(String nama);

    // Menghitung jumlah total customer
    Long countBy();

    // Menghapus customer berdasarkan kode
    void deleteByKode(String kode);
    // Anda dapat menambahkan metode tambahan sesuai kebutuhan Anda
}