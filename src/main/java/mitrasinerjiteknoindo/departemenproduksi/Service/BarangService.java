package mitrasinerjiteknoindo.departemenproduksi.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import mitrasinerjiteknoindo.departemenproduksi.Repository.BarangRepository;
import mitrasinerjiteknoindo.departemenproduksi.model.entity.Barang;

@Service
public class BarangService {

    private BarangRepository barangRepository;

    public BarangService(BarangRepository barangRepository) {
        this.barangRepository = barangRepository;
    }

    public List<Barang> getAllBarang() {
        return barangRepository.findAll();
    }

    public Barang getBarangById(Integer id) {
        return barangRepository.findById(id).orElse(null);
    }

    public Barang createBarang(Barang barang) {
        return barangRepository.save(barang);
    }

    public Barang updateBarang(Integer id, Barang barang) {
        Barang existingBarang = barangRepository.findById(id).orElse(null);
        if (existingBarang != null) {
            existingBarang.setKode(barang.getKode());
            existingBarang.setNama(barang.getNama());
            existingBarang.setHarga(barang.getHarga());
            return barangRepository.save(existingBarang);
        } else {
            return null;
        }
    }

    public void deleteBarang(Integer id) {
        barangRepository.deleteById(id);
    }
}