//BukuFiksi dan NonFiksi

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

class Main {
    public static void main(String[] args) {
        BukuFiksi bukuFiksi1 = new BukuFiksi("Buku Fiksi 1", "Penulis Fiksi 1", 2018, "Genre Fiksi 1");
        BukuFiksi bukuFiksi2 = new BukuFiksi("Buku Fiksi 2", "Penulis Fiksi 2", 2019, "Genre Fiksi 2");
        BukuNonFiksi bukuNonFiksi1 = new BukuNonFiksi("Buku Non Fiksi 1", "Penulis Non Fiksi 1", 2020, "Kategori Non Fiksi 1");
        BukuNonFiksi bukuNonFiksi2 = new BukuNonFiksi("Buku Non Fiksi 2", "Penulis Non Fiksi 2", 2021, "Kategori Non Fiksi 2");

        System.out.println("Informasi Buku Fiksi 1:");
        bukuFiksi1.tampilkanInfo();

        System.out.println("\nInformasi Buku Fiksi 2:");
        bukuFiksi2.tampilkanInfo();

        System.out.println("\nInformasi Buku Non Fiksi 1:");
        bukuNonFiksi1.tampilkanInfo();

        System.out.println("\nInformasi Buku Non Fiksi 2:");
        bukuNonFiksi2.tampilkanInfo();
    }
} 
    
