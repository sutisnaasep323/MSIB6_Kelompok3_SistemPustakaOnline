import java.util.*;

class Buku {
    private String judul;
    private String penulis;
    private int tahunTerbit;

    public Buku(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
        System.out.println("Tahun Terbit: " + tahunTerbit);
    }
}

class BukuFiksi extends Buku {
    private String genre;

    public BukuFiksi(String judul, String penulis, int tahunTerbit, String genre) {
        super(judul, penulis, tahunTerbit);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Genre: " + genre);
    }
}

class BukuNonFiksi extends Buku {
    private String kategori;

    public BukuNonFiksi(String judul, String penulis, int tahunTerbit, String kategori) {
        super(judul, penulis, tahunTerbit);
        this.kategori = kategori;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kategori: " + kategori);
    }
}

class PenjualanOnline {
    boolean loop = true;
    ArrayList<Buku> daftarBuku = new ArrayList<>();

    PenjualanOnline() {
        tryFunction();
    }

    String getInputUser() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    void showMenu() {
        System.out.println("============= Pilihan Menu =============");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Hapus Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Exit");
        System.out.print("Pilihan anda : ");
    }

    void tambahBuku() {
        System.out.println("============= Tambah Buku =============");
        System.out.print("Judul: ");
        String judul = getInputUser();
        System.out.print("Penulis: ");
        String penulis = getInputUser();
        System.out.print("Tahun Terbit: ");
        int tahunTerbit = Integer.parseInt(getInputUser());
        System.out.print("Jenis Buku (Fiksi / NonFiksi): ");
        String jenisBuku = getInputUser();

        if (jenisBuku.equalsIgnoreCase("Fiksi")) {
            System.out.print("Genre: ");
            String genre = getInputUser();
            BukuFiksi bukuFiksi = new BukuFiksi(judul, penulis, tahunTerbit, genre);
            daftarBuku.add(bukuFiksi);
            System.out.println("Berhasil menambah buku Fiksi");
        } else if (jenisBuku.equalsIgnoreCase("NonFiksi\n")) {
            System.out.print("Kategori: ");
            String kategori = getInputUser();
            BukuNonFiksi bukuNonFiksi = new BukuNonFiksi(judul, penulis, tahunTerbit, kategori);
            daftarBuku.add(bukuNonFiksi);
            System.out.println("Berhasil menambah buku Non Fiksi\n");
        } else {
            loop = false;
            System.out.println("Jenis buku tidak valid.");
        }
    }

    void hapusBuku() {
        System.out.println("============= Hapus Buku =============");
        System.out.print("Judul Buku yang akan dihapus: ");
        String judulHapus = getInputUser();

        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judulHapus)) {
                daftarBuku.remove(buku);
                System.out.println("Buku dengan judul '" + judulHapus + "' berhasil dihapus.");
                return;
            }
        }
        System.out.println("Buku dengan judul '" + judulHapus + "' tidak ditemukan.");
    }

    void cariBuku() {
        System.out.println("============= Cari Buku =============");
        System.out.print("Judul Buku yang akan dicari: ");
        String judulCari = getInputUser();

        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judulCari)) {
                System.out.println("Informasi Buku:");
                buku.tampilkanInfo();
                return;
            }
        }
        System.out.println("Buku dengan judul '" + judulCari + "' tidak ditemukan.");
    }

    void tryFunction(){
        try{
            do {
                showMenu();
                String pilihan = getInputUser();
                switch (pilihan) {
                    case "1":
                        tambahBuku();
                        break;
                    case "2":
                        hapusBuku();
                        break;
                    case "3":
                        cariBuku();
                        break;
                    case "4":
                        loop = false;
                        System.out.println("Terimakasih....");
                        break;
                    default:
                        System.err.println("Tidak ada menu dalam pilihan anda!");
                }
            }while (loop == true);
        }catch(Exception e){
            System.err.print("Mohon maaf ada kegagalan pada program, kami akan segera menyelesaikan.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        new PenjualanOnline();
    }
}
